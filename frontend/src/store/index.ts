import { createStore } from "vuex";
import api from "@/config/api";
import axios from "axios";

import * as VueCookies from "vue-cookies";
const cookies: any = VueCookies;

export default createStore({
  state: {
    token: cookies.get("token") || "",
    contaUser: cookies.get("contaUser") || {
      tipo: "",
      cliente: {
        nome: "",
      },
    },
    totalUsers: 0,
    totalByAccType: {
      prata: 0,
      ouro: 0,
      platina: 0,
      diamante: 0,
    },
  },

  getters: {
    getContaUser: (state) => state.contaUser,
    getUserName: (state: {
      totalByAccType: object;
      totalUsers: number;
      token: "";
      contaUser: { cliente: { nome: "" }; tipo: "" };
    }) => (state.contaUser ? state.contaUser.cliente.nome : null),
    getUserType: (state) => (state.contaUser ? state.contaUser.tipo : null),
    getTotalUsers: (state) => (state.totalUsers ? state.totalUsers : 0),
    getTotalByAccType: (state) => state.totalByAccType,
  },

  mutations: {
    SET_TOTAL_USERS(state, totalUsers) {
      state.totalUsers = totalUsers;
    },
    SET_TOTAL_CONTAS(state, totalByAccType) {
      state.totalByAccType = totalByAccType;
    },
    SET_TOKEN(state, token) {
      state.token = token;
      cookies.set("token", token, "2h");
    },
    SET_CONTA_USER(state, contaUser) {
      state.contaUser = contaUser;
      cookies.set("contaUser", contaUser, "2h");
    },
    logout(state) {
      state.token = "";
      state.contaUser = { tipo: "", cliente: { nome: "" } };
      state.totalUsers = 0;
      state.totalByAccType = {
        prata: 0,
        ouro: 0,
        platina: 0,
        diamante: 0,
      };
      cookies.remove("token");
      cookies.remove("contaUser");
      axios.defaults.headers.common.Authorization = undefined;
    },
  },

  actions: {
    async login({ commit }, credentials) {
      commit("logout");
      try {
        const response = await api.post("/auth/login", credentials);
        const token = response.data.token;

        commit("SET_TOKEN", token);
        axios.defaults.headers.common.Authorization = `Bearer ${token}`;

        return token;
      } catch (error) {
        console.error(error);
      }
    },

    async getUserDetails({ commit }, username) {
      try {
        const contaCliente = await api.get(`/api/conta/v1/cliente/${username}`);
        commit("SET_CONTA_USER", contaCliente.data);
      } catch (error) {
        console.error(error);
      }
    },

    async fetchTotalUsers({ commit }) {
      try {
        const response = await api.get("/api/cliente/v1");
        const todosUsuários = response.data;

        commit("SET_TOTAL_USERS", todosUsuários.length);
      } catch (error) {
        console.error(error);
      }
    },

    async fetchtotalByAccType({ commit }) {
      try {
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
      } catch (error) {
        console.error(error);
      }
    },
  },
});
