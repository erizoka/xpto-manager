import { createStore } from "vuex";
import api from "@/config/api";
import axios from "axios";

export default createStore({
  state: {
    token: "",
    contaUser: JSON.parse(localStorage.getItem("contaUser") || "{}") || {
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
      totalPorTipoConta: any;
      totalUsers: any;
      token: "";
      contaUser: { cliente: { nome: "" }; tipo: "" };
    }) => (state.contaUser ? state.contaUser.cliente.nome : null),
    getUserType: (state) => (state.contaUser ? state.contaUser.tipo : null),
    getTotalUsers: (state) => (state.totalUsers ? state.totalUsers : 0),
    getTotalTipoConta: (state) => state.totalPorTipoConta,
  },

  actions: {
    async login({ commit }, credentials) {
      try {
        const response = await api.post("/auth/login", credentials);
        const token = response.data.token;

        localStorage.setItem("token", token);
        axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;
        commit("SET_TOKEN", token);

        return response.data;
      } catch (error) {
        console.error("Erro no login:", error);
        throw error;
      }
    },

    logout({ commit }) {
      localStorage.removeItem("token");
      localStorage.removeItem("contaUser");
      delete axios.defaults.headers.common["Authorization"];
      commit("SET_TOKEN", null);
      commit("SET_USER", { tipo: "", cliente: { nome: "" } });
    },

    async getUserDetails({ commit }, username) {
      try {
        const contaCliente = await api.get(`/api/conta/v1/cliente/${username}`);
        commit("SET_USER", contaCliente.data);
      } catch (error) {
        console.error("Erro ao obter usuário: ", error);
        throw error;
      }
    },

    async getTotalUsers({ commit }) {
      try {
        const response = await api.get("/api/cliente/v1");
        const todosUsuários = response.data;

        commit("SET_TOTAL_USERS", todosUsuários.length);
      } catch (error) {
        console.error("Erro ao obter total de usuários: ", error);
        throw error;
      }
    },

    async getTotalPorTipoConta({ commit }) {
      const tipos = ["ouro", "prata", "platina", "diamante"];
      try {
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
      } catch (error) {
        console.error("Erro ao obter total de usuários: ", error);
        throw error;
      }
    },
  },

  mutations: {
    SET_TOKEN(state, token) {
      state.token = token;
    },
    SET_USER(state, contaUser) {
      state.contaUser = contaUser;
      localStorage.setItem("contaUser", JSON.stringify(contaUser));
    },
    SET_TOTAL_USERS(state, totalUsers) {
      state.totalUsers = totalUsers;
      localStorage.setItem("totalUsers", JSON.stringify(totalUsers));
    },
    SET_TOTAL_CONTAS(state, totalPorTipoConta) {
      state.totalPorTipoConta = totalPorTipoConta;
      localStorage.setItem("totalPorTipo", totalPorTipoConta);
    },
  },
});
