import { createStore } from "vuex";
import api from "@/config/api";
import axios from "axios";

export default createStore({
  state: {
    token: "",
    contaUser: JSON.parse(sessionStorage.getItem("contaUser") || "{}") || {
      tipo: "",
      cliente: {
        nome: "",
      },
    },
    totalUsers: 0,
    totalPorTipoConta: {
      prata: 0,
      ouro: 0,
      platina: 0,
      diamante: 0,
    },
  },

  getters: {
    isAuthenticated: (state) => !!state.token,
    getContaUser: (state) => state.contaUser,
    getUserName: (state: {
      totalPorTipoConta: object;
      totalUsers: number;
      token: "";
      contaUser: { cliente: { nome: "" }; tipo: "" };
    }) => (state.contaUser ? state.contaUser.cliente.nome : null),
    getUserType: (state) => (state.contaUser ? state.contaUser.tipo : null),
    getTotalUsers: (state) => (state.totalUsers ? state.totalUsers : 0),
    getTotalTipoConta: (state) => state.totalPorTipoConta,
  },

  actions: {
    async login({ commit }, credentials) {
      const response = await api.post("/auth/login", credentials);
      const token = response.data.token;

      commit("SET_TOKEN", token);
      axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;

      setTimeout(() => {
        localStorage.removeItem("token");
        window.location.reload();
      }, 3600000);

      return token;
    },

    logout({ commit }) {
      delete axios.defaults.headers.common["Authorization"];
      localStorage.removeItem("token");
      sessionStorage.removeItem("contaUser");
      commit("SET_TOKEN", null);
      commit("SET_USER", null);
      commit("SET_TOTAL_CONTAS", 0);
      commit("SET_TOTAL_USERS", 0);
    },

    async getUserDetails({ commit }, username) {
      const contaCliente = await api.get(`/api/conta/v1/cliente/${username}`);
      commit("SET_USER", contaCliente.data);
    },

    async fetchTotalUsers({ commit }) {
      const response = await api.get("/api/cliente/v1");
      const todosUsuários = response.data;

      commit("SET_TOTAL_USERS", todosUsuários.length);
    },

    async fetchTotalPorTipoConta({ commit }) {
      const tipos = ["ouro", "prata", "platina", "diamante"];
      const results = await Promise.all(
        tipos.map(async (tipo) => {
          const response = await api.get(`/api/conta/v1/tipo/${tipo}`);
          return { tipo, total: response.data.length };
        })
      );

      // Monta o objeto com os totais
      const totalContas = results.reduce((acc: any, item) => {
        acc[item.tipo] = item.total;
        return acc;
      }, {});

      commit("SET_TOTAL_CONTAS", totalContas);
    },
  },

  mutations: {
    SET_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem("token", token);
    },
    SET_USER(state, contaUser) {
      state.contaUser = contaUser;
      sessionStorage.setItem("contaUser", JSON.stringify(contaUser));
    },
    SET_TOTAL_USERS(state, totalUsers) {
      state.totalUsers = totalUsers;
    },
    SET_TOTAL_CONTAS(state, totalPorTipoConta) {
      state.totalPorTipoConta = totalPorTipoConta;
    },
  },
});
