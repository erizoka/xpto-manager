<template>
    <div class="dashboard">
        <MenuComponent class="menu" @navigate="handleNavigation" />
        <div class="stats" v-if="view === 'stats'">
            <div class="user-container">
                <div class="admin">
                    <i class="fa-solid fa-user-tie icon" />
                    <h2>{{ getUserName }}</h2>
                    <span><i class="fa-regular fa-circle-check" /> {{ getUserType }}</span>
                </div>
                <div class="user">
                    <i class="fa-solid fa-user" />
                    <h2>{{ getTotalUsers }}</h2>
                    <span>Usuários<br>ativos</span>
                </div>
            </div>
            <div class="account">
                <h1>Status por Tipo Conta</h1>
                <div class="cards-container">
                    <div v-for="conta in tiposConta" :key="conta.tipo" class="card">
                        <h3>{{ conta.tipo }}</h3>
                        <span>{{ conta.total }}</span>
                    </div>
                </div>
            </div>
        </div>
        <ListUsers v-else-if="view == 'users'" />
    </div>
</template>

<script>
import { mapGetters, mapActions, mapState } from 'vuex';
import ListUsers from './ListUsers.vue';
import MenuComponent from './MenuComponent.vue'
export default {
    components: { MenuComponent, ListUsers },
    data() {
        return {
            view: 'stats',
        }
    },
    methods: {
        ...mapActions(['getTotalPorTipoConta']),
        handleNavigation(view) {
            this.view = view;
        },
    },
    computed: {
        ...mapGetters(['getUserName', 'getUserType', 'getTotalUsers']),
        ...mapState(['totalPorTipoConta']),
        tiposConta() {
            return [
                { tipo: 'Diamante', total: this.totalPorTipoConta?.diamante || 0 },
                { tipo: 'Platina', total: this.totalPorTipoConta?.platina || 0 },
                { tipo: 'Ouro', total: this.totalPorTipoConta?.ouro || 0 },
                { tipo: 'Prata', total: this.totalPorTipoConta?.prata || 0 },
            ]
        }
    },
    async created() {
        await this.getTotalPorTipoConta();
    }
}
</script>

<style scoped>
.dashboard {
    border: 3px solid #FFF;
    border-radius: 15px;
    display: grid;
    grid-template-columns: 180px 1fr;
    grid-template-areas: "menu" "stats";
}

.stats {
    background-color: #FFF;
    width: max-content;
    border-radius: 0 10px 10px 0;
    padding: 50px 50px 50px 30px;
    display: flex;
    align-items: center;
    justify-content: end;
}

.stats h1 {
    color: #FFF;
    font-family: 'Trebuchet MS', sans-serif;
    font-weight: 300;
    font-style: oblique;
}

.account,
.user,
.admin {
    display: flex;
    flex-direction: column;
    padding: 30px;
    border-radius: 20px;
    box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;
    background: linear-gradient(330deg, rgba(23, 39, 125, 1) 0%, rgba(5, 10, 36, 1) 100%);
}

.cards-container {
    display: grid;
    grid-template-columns: auto auto;
}

.card {
    width: 7rem;
    padding: 10px;
    margin: 5px;
    border-radius: 90px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    background-color: #FFF;
    color: rgba(5, 10, 36, 1);
    box-shadow: rgba(50, 50, 93, 0.25) 0px 50px 100px -20px,
        rgba(0, 0, 0, 0.3) 0px 30px 60px -30px,
        rgba(10, 37, 64, 0.35) 0px -2px 6px 0px inset;
}

.card h3 {
    font-size: 14px;
    font-weight: bold;
    font-family: 'Poppins';
    margin-top: 2px;
    margin-bottom: 6px;
}

.card span {
    font-size: 60px;
    font-weight: 300;
    font-family: 'Trebuchet MS', sans-serif;
}

.user,
.admin {
    color: #FFF;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    padding: 30px;
    margin: 20px;
}

.user span {
    font-family: 'Trebuchet MS', sans-serif;
    font-size: 12px;
    text-align: center;
}

.user i {
    font-size: 70px;
}

.user h2 {
    font-family: 'Trebuchet MS', sans-serif;
    font-size: 50px;
    font-weight: 300;
    margin-top: 1px;
    margin-bottom: 1px;
}

.admin {
    padding: 18px 10px;
}

.admin .icon {
    padding: 10px;
    font-size: 40px;
    margin-bottom: 2px;
    border: 2px solid #FFF;
    border-radius: 35px;
}

.admin h2 {
    margin: 5px;
}

.admin span {
    text-transform: uppercase;
}
</style>