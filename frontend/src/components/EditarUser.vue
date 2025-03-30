<template>
    <div class="update-container">
        <div class="select-user">
            <h2>Digite o email do cliente: </h2>
            <div class="search">
                <input name="email" id="email" placeholder="" v-model="user.email" @keyup.enter="fetchUser(user.email)">
                <label for="email">E-mail</label>
                <button @click="fetchUser(user.email)"><i class="fa-solid fa-magnifying-glass" /></button>
            </div>
        </div>
        <div class="edit-user" v-if="hasUser">
            <form class="formulario">
                <label>Nome:</label>
                <input type="text" v-model="user.nome" required>
                <label>Senha:</label>
                <input type="password" v-model="user.senha" required>
                <label>Idade:</label>
                <input type="number" v-model="user.idade" required>
                <label>Faixa Salarial:</label>
                <input type="text" v-model="user.faixaSalarial" placeholder="R$" required>
                <div class="tipo-selecao">
                    <label>Tipo:</label>
                    <select name="role" id="role" v-model="user.privilege" required>
                        <option value="CLIENT">CLIENTE</option>
                        <option value="USER">USUÁRIO</option>
                        <option value="ADMIN">ADMIN</option>
                    </select>
                </div>
                <div class="botoes">
                    <button @click.prevent="updateUser" class="update-btn">
                        <i class="fa-solid fa-pen-to-square" />
                        ATUALIZAR
                    </button>
                    <button @click.prevent="isDeleteModalOpen = true" class="delete-btn">
                        <i class="fa-solid fa-trash" />
                        EXCLUIR
                    </button>
                </div>
            </form>
        </div>
        <div class="spaced" v-else></div>
        <div class="modal-overlay" v-if="isDeleteModalOpen">
            <div class="confirmation-modal">
                <p>Tem certeza que deseja excluir este usuário?</p>
                <button @click="deleteUser(user.email)">SIM</button>
                <button @click="isDeleteModalOpen = false">CANCELAR</button>
            </div>
        </div>
    </div>
</template>

<script setup>
import api from '@/config/api';
import { useStore } from 'vuex';
import { notyf } from '@/config/notyf';
import { ref } from 'vue';
import '../config/router';

const store = useStore();

const user = ref({})
const hasUser = ref(false)
const isDeleteModalOpen = ref(false);

async function fetchUser(email) {
    if (email == null) {
        notyf.error("Informe um email")
        return;
    }
    try {

        const response = await api.get(`/api/cliente/v1/${email}`)

        user.value = response.data
        hasUser.value = true

    } catch (error) {
        notyf.error(error.code)
    }
}

async function updateUser() {
    try {

        console.log(user)
        const response = await api.put('/api/cliente/v1', user.value)
        if (response) {
            notyf.success(`Usuário ${user.value.nome} atualizado com sucesso!`)
        }

    } catch (error) {
        notyf.error(error.response.data)
    }
}

async function deleteUser(email) {
    try {
        const response = await api.delete(`/api/cliente/v1/${email}`)

        if (response) {
            await store.dispatch('fetchTotalUsers')
            await store.dispatch('fetchtotalByAccType')
            window.location.href = '/dashboard'
        }

    } catch (error) {
        console.error("Erro ao excluir o usuário: ", error)
        notyf.error("Erro ao excluir o usuário!")
    }
}

</script>

<style scoped>
.update-container {
    display: flex;
    flex-direction: column;
    background-color: #fff;
    padding: 0 30px 25px;
}

.select-user {
    display: flex;
    flex: 1;
    flex-direction: column;
}

.select-user h2 {
    font-family: 'Trebuchet MS', sans-serif;
    font-style: italic;
    color: rgba(5, 10, 36, 1);
}

.search {
    display: flex;
    padding: 5px;
}

.search button {
    padding: 6px;
    background: none;
    border-radius: 15px;
    border: none;
    color: rgba(5, 10, 36, 1);
    font-weight: 700;
    font-size: 20px;
}

.search button:hover {
    color: #fff;
    background-color: rgba(5, 10, 36, 1);
    transition: ease 0.5s;
}

.search input,
.formulario input {
    display: flex;
    flex: 1;
    outline: 0;
    border: 0;
    border-bottom: 2px solid grey;
}

.search label {
    position: absolute;
    left: 35%;
    top: 20%;
    font-size: 16px;
    color: gray;
    transition: 0.3s;
}

.search input:focus~label,
.search input:not(:placeholder-shown)~label {
    top: 17%;
    font-size: 12px;
    color: rgba(5, 10, 36, 1);
}

.search input:focus {
    border-bottom: 2px solid rgba(5, 10, 36, 1);
}

.spaced {
    padding: 200px 300px;
}

.formulario {
    height: 390px;
    width: 585px;
    display: flex;
    flex-direction: column;
    justify-content: start;
    align-items: start;
    padding: 5px 10px;
    color: rgb(85, 79, 79);
}

.formulario input,
.formulario label {
    margin: 3px;
}

.formulario input {
    width: 90%;
}

.tipo-selecao {
    margin-top: 5px;
}

.botoes {
    width: 85%;
    display: flex;
    padding: 10px;
    margin: 10px;
    justify-content: end;
    align-items: end;
}

.botoes button {
    width: 110px;
    display: flex;
    justify-content: space-around;
    margin-left: 7px;
    background: none;
    padding: 5px;
    border-radius: 7px;
}

.update-btn:hover {
    background-color: rgb(13, 24, 78);
    color: #fff;
    font-weight: bolder;
    transition: ease-in-out 0.2s;
}

.delete-btn:hover {
    background-color: red;
    color: #000;
    font-weight: bolder;
    transition: ease-in-out 0.2s;
}

.modal-overlay {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
    background-color: rgba(0, 0, 0, 0.5);
}

.confirmation-modal {
    background: white;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
    text-align: center;
}

.confirmation-modal p {
    padding: 10px;
    font-size: larger;
    font-family: 'Trebuchet MS', sans-serif;
}

.confirmation-modal button {
    width: 170px;
    margin-left: 5px;
    background: none;
    padding: 10px;
    border-radius: 7px;
    font-weight: 700;
}

.confirmation-modal button:hover {
    background-color: rgba(5, 10, 36, 1);
    color: white;
    transition: ease 0.5s;
}
</style>