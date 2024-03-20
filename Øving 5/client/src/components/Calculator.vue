<template>
  <div class="container">
    <div v-if="!loggedIn" class="login-form">
      <h2>Login</h2>
      <input type="text" v-model="username" placeholder="Username" />
      <input type="password" v-model="password" placeholder="Password" />
      <button @click="login">Login</button>
    </div>

    <div v-else class="calculator">
      <div class="display">{{ display }}</div>
      <div class="buttons">
        <button v-for="button in buttons" :key="button" @click="appendToDisplay(button)">
          {{ button }}
        </button>
      </div>
      <div class="actions">
        <button @click="calculate" :disabled="calculating">=</button>
        <button @click="logout">Logout</button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      loggedIn: false,
      username: '',
      password: '',
      display: '',
      buttons: ['1', '2', '3', '+', '4', '5', '6', '-', '7', '8', '9', '*', '0', '.', '/'],
      apiUrl: 'http://localhost:8080/api',
      calculating: false,
    };
  },
  methods: {
    async login() {
      try {
        const response = await axios.post(`${this.apiUrl}/auth/login`, {
          username: this.username,
          password: this.password,
        });

        localStorage.setItem('authToken', response.data.token);
        this.loggedIn = true;
        this.display = '';
      } catch (error) {
        alert('Failed to log in. Please check your credentials.');
        console.error('Login error:', error);
      }
    },
    logout() {
      localStorage.removeItem('authToken');
      this.loggedIn = false;
      this.username = '';
      this.password = '';
      this.display = '';
    },
    appendToDisplay(symbol) {
      this.display += symbol;
    },
    async calculate() {
      const token = localStorage.getItem('authToken');
      if (!token) {
        alert('Your session has expired. Please log in again.');
        this.logout();
        return;
      }

      this.calculating = true;
      try {
        const response = await axios.post(
          `${this.apiUrl}/calculations`,
          { expression: this.display },
          { headers: { Authorization: `Bearer ${token}` } }
        );

        this.display = response.data.result.toString();
      } catch (error) {
        alert('Failed to calculate the expression.');
        console.error('Calculation error:', error);
      } finally {
        this.calculating = false;
      }
    },
  },
};
</script>

<style>
.container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.login-form,
.calculator {
  display: flex;
  flex-direction: column;
}

.buttons,
.actions {
  display: flex;
  justify-content: center;
}

.display {
  margin-bottom: 20px;
  text-align: center;
}

button {
  margin: 5px;
  padding: 5px 10px;
}

button:disabled {
  opacity: 0.5;
  cursor: not-allowed;
}
</style>
