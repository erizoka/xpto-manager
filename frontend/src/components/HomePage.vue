<template>
    <div class="login">
        <div class="title-container">
            <h1 class="title">Bem vindo ao sistema de gerenciamento da XPTO</h1>
        </div>
        <div class="login-container">
            <h1 class="login-title">Acessar Sistema</h1>
            <div class="formulario">
                <span class="input-title">Email</span>
                <input type="text" class="user-input" v-model="user.username">
                <span class="input-title">Senha</span>
                <input type="password" class="user-input" v-model="user.password">
                <button @click="handleLogin">Login</button>
            </div>
        </div>
    </div>
</template>

<script>
import { mapActions } from 'vuex';
import { notyf } from '@/config/notyf';

export default {
    name: 'HomePage',
    data() {
        return {
            user: {
                username: '',
                password: '',
            }
        }
    },
    methods: {
        ...mapActions(['login', 'getUserDetails']),

        async handleLogin() {
            try {
                if (this.user.username === '' || this.user.password === '') {
                    notyf.error('Email e senha precisam ser preenchidos!')
                } else {
                    const response = await this.login({ username: this.user.username, password: this.user.password })

                    if (response) {
                        await this.getUserDetails(this.user.username)
                        this.$router.push('/dashboard')
                    }
                }

            } catch (error) {
                notyf.error(error.response.data.token)
            }
        }
    }
}
</script>

<style scoped>
.login {
    display: flex;
}

.login-title {
    font-weight: bold;
    font-family: Arial, Helvetica, sans-serif;
}

.title {
    background: linear-gradient(to bottom, rgba(255, 255, 255, 1)0%, rgba(255, 255, 255, 0.4) 100%);
    background-clip: text;
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
    font-family: 'Poppins', sans-serif;
    font-weight: 300;
    font-style: italic;
    font-size: 2.8rem;
}

.title-container {
    position: fixed;
    bottom: 40%;
    left: 2%;
    flex: 1;
    width: 30%;
    height: 3rem;
    margin: 0 0 30px 30px;
}

.login-container {
    background-color: #FFF;
    width: 50%;
    height: 100%;
    position: fixed;
    top: 0;
    right: 0;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

.formulario {
    display: flex;
    flex-direction: column;
    padding: 30px;
}

.user-input {
    width: 25rem;
    padding: 7px;
    margin: 0 0 10px 0;
    border-radius: 4px;
    border-color: #cec6c6e0;
}

.user-input:focus {
    outline: none;
    border-width: 1px;
    border-color: rgb(40, 197, 245);
}

.input-title {
    font-family: 'Trebuchet MS', sans-serif;
    font-weight: 300;
    color: #707070;
}

button {
    background-color: rgb(21, 91, 219);
    padding: 7px;
    border-radius: 4px;
    color: #FFF;
    font-family: 'Trebuchet MS', sans-serif;
}
</style>