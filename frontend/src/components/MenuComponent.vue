<template>
    <aside class="menu">
        <div class="title">
            <i class="fa-solid fa-gear" />
            <h1>Menu</h1>
        </div>
        <div class="menu-options">
            <button class="btn" @click="navigate('stats')">
                <i class="fa-solid fa-square-poll-vertical" />
                <span>Dashboard</span>
            </button>
            <button class="btn" @click="navigate('users')">
                <i class="fa-regular fa-address-book" />
                <span>Usuários</span>
            </button>
            <button class="btn">
                <i class="fa-regular fa-pen-to-square" />
                <span>Editar</span>
            </button>
            <button class="btn" @click="this.$router.push(name = 'cadastrar-cliente')">
                <i class="fa-solid fa-user-plus" />
                <span>Cadastrar</span>
            </button>
            <button class="btn" @click="handleLogout">
                <i class="fa-solid fa-right-from-bracket" />
                <span>Sair</span>
            </button>
        </div>
    </aside>
</template>
<script>
import { mapActions } from 'vuex';

export default {
    methods: {
        ...mapActions(['logout']),

        navigate(view) {
            this.$emit('navigate', view)
        },

        handleLogout() {
            this.logout()
            this.$router.push('/')
        }
    }
}
</script>
<style scoped>
.menu {
    padding: 20px;
    color: #FFF;
    border-radius: 10px 0 0 10px;
    background-color: rgba(5, 10, 36, 1);
}

.title {
    display: flex;
}

.title h1 {
    margin-top: 0;
    margin-left: 10px;
    padding: 0;
}

.title i {
    margin-top: 5px;
}

.btn {
    margin: 5px;
    padding: 5px;
    color: #FFF;
    background: none;
    border: none;
    font-size: 15px;
    border-radius: 10px;
}

.btn:hover {
    background-color: #ffffff49;
}

.btn span {
    margin-left: 5px;
}
</style>