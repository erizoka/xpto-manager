<template>
    <div class="users">
        <h1>Lista de usuários</h1>
        <div v-if="loading">
            <h3>Carregando...</h3>
        </div>
        <div v-else>
            <div class="filter-container">
                <label>Filtrar por Tipo Conta: </label>
                <select v-model="selectedType">
                    <option value="" selected>Todos</option>
                    <option value="ouro">Ouro</option>
                    <option value="prata">Prata</option>
                    <option value="platina">Platina</option>
                    <option value="diamante">Diamante</option>
                </select>
            </div>
            <div class="card-container">
                <div v-for="user in users" :key="user.id" class="card" @click="user.isDetailOpen = !user.isDetailOpen">
                    <div class="card-title">
                        <span>{{ user.cliente.nome }}, {{ user.cliente.idade }}</span>
                        <span>{{ user.cliente.email }}</span>
                    </div>
                    <div class="card-detail" v-if="user.isDetailOpen">
                        <span>Tipo: {{ user.tipo }}</span>
                        <span>Faixa Salarial: R${{ user.cliente.faixaSalarial }}</span>
                        <span>Limite: {{ user.limite }}</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script setup>
import api from '@/config/api';
import { onMounted, ref, watch } from 'vue';

const users = ref([]);
const loading = ref(true);
const selectedType = ref("");

async function getUsers() {
    try {
        const response = await api.get('/api/conta/v1')

        users.value = response.data.map(user => ({
            ...user,
            isDetailOpen: false
        }))
    } catch (error) {
        console.log(error)
    } finally {
        loading.value = false
    }
}

async function fetchUsersByAccountType(tipo) {
    if (!tipo || tipo === '') {
        getUsers()
        return
    }

    try {

        const response = await api.get(`/api/conta/v1/tipo/${tipo}`)
        users.value = response.data.map(user => ({
            ...user,
            isDetailOpen: false
        }));

    } catch (error) {
        console.log(error)
    }
}

watch(selectedType, (newType) => {
    fetchUsersByAccountType(newType);
})

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

.filter-container {
    width: 45%;
    margin-left: 20px;
    display: flex;
    justify-content: space-between;
    font-family: 'Trebuchet MS', sans-serif;
    font-size: large;
    font-weight: 800;
}

.filter-container select {
    padding: 3px;
    border-radius: 7px;
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

.card-title,
.card-detail {
    display: flex;
    justify-content: space-between;
    font-family: 'Trebuchet MS', sans-serif;
}

.card-detail {
    margin-top: 15px;
    font-size: small;
}
</style>