import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import HomePage from "@/components/HomePage.vue";
import CadastroPage from "@/components/CadastroPage.vue";
import DashboardPage from "@/components/DashboardPage.vue";
import EditarUser from "@/components/EditarUser.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "home",
    component: HomePage,
    meta: { title: "XPTO - Entrar" },
  },
  {
    path: "/cadastrar-cliente",
    name: "cadastro",
    component: CadastroPage,
    meta: { title: "Cadastrar Cliente", requiresAuth: true },
  },
  {
    path: "/dashboard",
    name: "dashboard",
    component: DashboardPage,
    meta: { title: "Visão Geral", requiresAuth: true },
  },
  {
    path: "/editar-cliente",
    name: "editar",
    component: EditarUser,
    meta: { title: "Editar Clietne", requiresAuth: true },
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

router.beforeEach((to, from, next) => {
  const isAuthenticated = localStorage.getItem("token");

  if (to.meta.requiresAuth && !isAuthenticated) {
    next({ path: "/" });
  } else {
    next();
  }
});

export default router;
