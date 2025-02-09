<template>
    <div class="users">
        <h1>Lista de usuários</h1>
        <div v-if="loading">
            <h3>Carregando...</h3>
        </div>
        <div v-else>
            <div class="card-container">
                <div v-for="user in users" :key="user.email" class="card" @click="getUserDetail(user.email)">
                    <div class="card-title">
                        <span>{{ user.nome }}, {{ user.idade }}</span>
                        <span>{{ user.email }}</span>
                    </div>
                    <div class="card-detail" v-if="isDetailOpen">
                        <span>{{ userDetail.cliente }}</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script setup>
import api from '@/config/api';
import { onMounted, ref } from 'vue';

let userDetail = ref({});
let isDetailOpen = false;
const users = ref([]);
const loading = ref(true);

async function getUsers() {
    try {
        const response = await api.get('/api/cliente/v1')

        users.value = response.data
    } catch (error) {
        console.log(error)
    } finally {
        loading.value = false
    }
}

async function getUserDetail(email) {
    try {
        const response = await api.get(`/api/conta/v1/cliente/${email}`)

        userDetail.value = response.data
        isDetailOpen = true

    } catch (error) {
        console.log(error)
    }
}

onMounted(() => {
    getUsers()
})
</script>

<style scoped>
.users {
    background-color: #fff;
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 35px 10px;
}

.users h1 {
    color: rgba(5, 10, 36, 1);
    font-family: 'Trebuchet MS', sans-serif;
    font-weight: 300;
    font-style: oblique;
}

.card-container {
    height: 350px;
    width: 600px;
    background: none;
    overflow: auto;
    padding: 10px;
}

.card {
    padding: 15px;
    margin: 10px;
    border: 1px solid;
    border-radius: 5px;
    color: #fff;
    box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;
    background: linear-gradient(330deg, rgba(23, 39, 125, 1) 0%, rgba(5, 10, 36, 1) 100%);
}

.card:hover {
    scale: 1.040;
    transition: ease 0.2s;
}

.card-title {
    display: flex;
    justify-content: space-between;
}
</style>