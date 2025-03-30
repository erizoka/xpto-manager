import { createApp } from "vue";
import App from "./App.vue";
import router from "./config/router";
import api from "./config/api";
import { notyf } from "./config/notyf";
import store from "./store";
import VueCookies from "vue-cookies";

const app = createApp(App);

app.config.globalProperties.$api = api;
app.config.globalProperties.$notyf = notyf;

app.use(router).use(VueCookies).use(store).mount("#app");
