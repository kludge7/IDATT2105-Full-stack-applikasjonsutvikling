<template>
  <!-- If no user is logged in, show login form -->
  <div v-if="!loggedIn" class="login-container">
    <h2>Login</h2>
    <form @submit.prevent="login" class="login-form">
      <label for="username">Username:</label>
      <input type="text" v-model="username" required />
      <label for="password">Password:</label>
      <input type="password" v-model="password" required />
      <button type="submit">Login</button>
    </form>
  </div>

  <!-- If user is logged in, show the calculator -->
  <div v-else>
    <div class="calculator">
      <!-- Calculator display input. -->
      <input class="display" type="text" v-model="display" disabled />

      <!-- Calculator buttons --> 
      <div class="buttons">
        <button v-for="button in buttons" :key="button.value" @click="updateDisplay(button.value)" class="button">
          {{ button.value }}
        </button>
      </div>

      <!-- Log section -->
      <div class="log">
        <h2>Log</h2>
        <ul>
          <!-- Use v-for to loop through log in reverse order -->
          <li v-for="(item, index) in log.slice().reverse()" :key="index">
            {{ item }}
          </li>
        </ul>
      </div>

      <!-- Logout button -->
      <button @click="logout" class="logout-button">Logout</button>
    </div>
  </div>
</template>

<script>
import { ref } from 'vue';

export default {
  setup() {
    const loggedIn = ref(false);
    const username = ref('');
    const password = ref('');
    const display = ref('');
    const logoutStatus = ref('');
    const buttons = [
      { value: 'AC' },
      { value: '%' },
      { value: '/' },
      { value: '.' },

      { value: '7' },
      { value: '8' },
      { value: '9' },
      { value: '*' },

      { value: '4' },
      { value: '5' },
      { value: '6' },
      { value: '-' },

      { value: '1' },
      { value: '2' },
      { value: '3' },
      { value: '+' },

      { value: '0' },
      { value: '(' },
      { value: ')' },
      { value: '=' },
      ];
      const log = [];

      function updateDisplay(value) {
        if (value === '=') {
          try {
            log.push(display.value + '=' + eval(display.value));
            return (display.value = eval(display.value));
          } catch (SyntaxError) {
            alert('ERROR ERROR ERROR');
          } finally {
            console.log('Easter egg');
          }
        }
        if (value === 'AC') {
          return (display.value = '');
        }
        if (value === '%') {
          return (display.value /= 100);
        }
        display.value += value;
      }

      async function login() {
        try {
          const response = await fetch('http://localhost:8080/login', {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json',
            },
            body: JSON.stringify({
              username: username.value,
              password: password.value,
            }),
          });

          const result = await response.text();

          if (response.ok && result === 'Login successful') {
            loggedIn.value = true;
            log.push(result);
          } else {
            alert(result);
          }
        } catch (error) {
          console.error('Error during login:', error);
          alert('An error occurred during login');
        }
      }

      // Modify the logout function to communicate with the backend
    async function logout() {
      try {
        const response = await fetch('http://localhost:8080/logout', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify({}),
        });

        const result = await response.text();

        if (response.ok) {
          loggedIn.value = false;
          log.push(result);
          logoutStatus.value = 'User logged out successfully.';
        } else {
          logoutStatus.value = result;
        }
      } catch (error) {
        console.error('Error during logout:', error);
        logoutStatus.value = 'An error occurred during logout';
      }
    }

    return {
      loggedIn,
      username,
      password,
      display,
      buttons,
      log,
      updateDisplay,
      login,
      logout,
    };
  },
};

</script>
<style>
  body {
    font-family: 'Arial', sans-serif;
    background-color: #f0f0f0;
    margin: 0;
    padding: 0;
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100vh;
  }

  .login-container {
    text-align: center;
  }

  .login-form {
    display: inline-block;
    text-align: left;
  }

  .calculator {
    max-width: 360px;
    background-color: #ffffff;
    border-radius: 10px;
    padding: 20px;
  }

  .display {
    width: 100%;
    height: 56px;
    font-size: 20px;
    text-align: left;
    margin-bottom: 10px;
    padding: 20px;
    border-radius: 5px;
    color: #333;
    background-color: #f8f8f8;
    border: 1px solid #ccc;
    box-sizing: border-box;
  }

  .buttons {
    display: flex;
    flex-wrap: wrap;
    width: 100%;
    justify-content: space-between;
  }

  .button {
    width: 20%;
    height: 60px;
    margin: 10px 1px;
    border-radius: 10px;
    background-color: #819182;
    color: #ffffff;
    font-size: 18px;
    cursor: pointer;
    border: none;
    align-items: center;
    justify-content: center;
  }

  .button:hover {
    transform: translateY(-7px);
  }

  .log {
    margin-top: 20px;
    color: #333;
  }

  footer {
    margin-top: 15px;
    font-size: 18px;
    color: #333;
    text-align: center;
  }

  .logout-button {
    width: 100%;
    height: 40px;
    margin-top: 10px;
    border-radius: 5px;
    background-color: #d9534f;
    color: #fff;
    font-size: 16px;
    cursor: pointer;
    border: none;
    align-items: center;
    justify-content: center;
  }

  .logout-button:hover {
    background-color: #c9302c;
  }
</style>