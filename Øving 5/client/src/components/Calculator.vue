<template>
  <div class="calculator">
    <!-- Calculator display input -->
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
        <li v-for="(item, index) in log.slice().reverse()" :key="index">
          {{ item }}
        </li>
      </ul>
    </div>

    <!-- Developer footer -->
    <footer>
      Developed by 🤡Andreas🤡Kluge🤡Svendsrud🤡
    </footer>
  </div>
</template>

<script>
import { ref } from 'vue';
import axios from 'axios';

export default {
  setup() {
    const display = ref('');
    const buttons = [
      { value: 'AC' },
      { value: '%' },
      { value: '/' },
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
      { value: '.' },
      { value: '(' },
      { value: ')' },
      { value: '=' },
    ];
    const log = [];

    async function updateDisplay(value) {
      try {
        // Handle different button values
        if (value === '=') {
          // Send a request to the backend when '=' is clicked
          const response = await axios.post('http://localhost:8080/api/calculations', {
            expression: display.value,
          });
          log.push(`${display.value} = ${response.data.result}`);
          display.value = response.data.result;
        } else if (value === 'AC') {
          // Clear the display and log when 'AC' is clicked
          display.value = '';
          log.push('Cleared');
        } else if (value === '%') {
          // Handle percentage calculation
          const result = parseFloat(display.value) / 100;
          display.value = result.toString();
          log.push(`${result}%`);
        } else {
          // Handle other button values (numbers, operators, etc.)
          display.value += value;
        }
      } catch (error) {
        console.error('Error during calculation:', error);
        alert('Error during calculation');
      }
    }
    return {
      display,
      buttons,
      log,
      updateDisplay,
    };
  },
};
</script>

<style>
/* Your existing styles */
</style>

