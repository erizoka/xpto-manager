<template>
    <div class="cadastro-container">
        <h2 class="title">Cadastrar Novo Cliente</h2>
        <form class="formulario">
            <span>Nome:</span>
            <input type="text" v-model="user.nome" required>
            <span>Email:</span>
            <input type="text" v-model="user.email" required>
            <span>Senha:</span>
            <input type="password" v-model="user.senha" required>
            <span>Idade:</span>
            <input type="number" v-model="user.idade" required>
            <span>Faixa Salarial:</span>
            <input type="text" v-model="user.faixaSalarial" placeholder="R$" required>
            <span>Tipo:</span>
            <select name="role" id="role" v-model="user.privilege" required>
                <option value="CLIENT">CLIENTE</option>
                <option value="USER">USUÁRIO</option>
                <option value="ADMIN">ADMIN</option>
            </select>
            <div class="botoes">
                <button @click="createUser">CADASTRAR</button>
                <button @click="clearForm">LIMPAR</button>
            </div>
        </form>
    </div>
</template>

<script>
import api from '@/config/api';
import { notyf } from '@/config/notyf';
import { mapActions } from 'vuex';

export default {
    data() {
        return {
            user: {}
        }
    },
    methods: {
        ...mapActions(['getTotalPorTipoConta', 'getTotalUsers']),
        clearForm() {
            this.user = {}
        },
        async createUser() {
            try {

                api.post('/api/cliente/v1', this.user)
                await this.getTotalPorTipoConta
                await this.getTotalUsers
                this.$router.push({ path: '/dashboard' })

            } catch (error) {
                console.error('Erro ao fazer cadastro:', error);
                notyf.error(error.response.data)
            }
        }
    }
}
</script>

<style scoped>
.cadastro-container {
    height: 30rem;
    background-color: #FFF;
    width: 90%;
    padding: 30px 32px;
    margin-right: 70px;
    border-radius: 0 10px 20px 0;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: start;
}

.title {
    width: 100%;
    font-weight: bold;
    font-family: Arial, Helvetica, sans-serif;
    font-style: italic;
    margin-bottom: 0;
    margin-top: 30px;
}

.formulario {
    width: 90%;
    display: flex;
    flex-direction: column;
    padding: 10px;
    margin: 30px;
}

span {
    font-family: 'Trebuchet MS', sans-serif;
    font-weight: 300;
    color: #707070;
}

input {
    width: 25rem;
    padding: 7px;
    margin: 0 0 10px 0;
    border-radius: 4px;
    border-color: #cec6c6e0;
}

input:focus {
    outline: none;
    border-width: 1px;
    border-color: rgb(40, 197, 245);
}

select {
    width: max-content;
    padding: 7px;
    border-radius: 5px;
    margin-top: 5px;
}

select option {
    font-weight: bold;
    font-family: 'Trebuchet MS', sans-serif;
}

.botoes {
    align-self: end;
    padding: 5px;
    display: flex;
    justify-content: space-between;
}

button {
    width: max-content;
    padding: 10px;
    margin: 5px;
    border: none;
    border-radius: 5px;
    font-weight: bold;
    font-family: 'Trebuchet MS', sans-serif;
    color: #FFF;
    background-color: rgb(21, 91, 219);
}

button:hover {
    background-color: #09185f;
}

i {
    position: absolute;
    top: 20px;
    left: 20px;
    color: #050A24;
}

i:hover {
    transition-duration: 0.5s;
    transform: scale(1.5);
}
</style>