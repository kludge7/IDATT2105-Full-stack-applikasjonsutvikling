<!-- eslint-disable vue/multi-word-component-names -->
<!-- src/components/Calculator.vue -->
<template>
    <div class="calculator">
    <!-- Calculator display input. 
    Type is set to text (since it shows text).
    v-model binds the input of the display to the variable display 
    Sets class to display (for CSS)
    Also sets disabled, so that you cant write into the display.
    -->
    <input class="display" type="text" v-model="display" disabled />

    <!-- Calculator buttons
        Set class to buttons (for CSS)
        Use v-for to loop through all the button´s made in the script
        They are all made as buttons, with their key being set to their
        button.value and when they are clicked the updateDisplay function is called
        with the parameters being the button value.
        {{ button.vallue }} is used to display the actual content of the button.
    --> 
    <div class="buttons">
        <button v-for="button in buttons" :key="button.value" @click="updateDisplay(button.value)" class="button">
            {{ button.value }}
        </button>
    </div>
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

    <!-- Developer footer🤡 -->

    <footer>
        Developed by 🤡Andreas🤡Kluge🤡Svendsrud🤡
    </footer>
</template>

<script>
import { ref } from 'vue';
export default {
    setup() {
        // Reactive reference for display using the ref liberary from vue. Is intitially empty
        const display = ref('');
        // Array of buttons
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
            { value: '=' },


        ];
      // Array of the log
    const log = [];
      // Function to update display based on button click
      // When the user clicks =, then the eval function is able to calculate the display.value
      // If not then the value of the button clicked is added to the display (not very smart system)
    function updateDisplay(value) {
        if (value === '=') {
            log.push(display.value + '=' + eval(display.value) )
            return display.value = eval(display.value);
        }
        if (value === 'AC') {
            return display.value = ''
        }
        display.value += value;
    }
      // Return data and functions for the component
    return {
        display,
        buttons,
        log,
        updateDisplay,
    };
},};

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

.calculator {
    max-width: 360px;
    background-color: #ffffff;
    border-radius: 10px;
    padding: 20px;
    box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1), 0 6px 6px rgba(0, 0, 0, 0.23);
}

.display {
    width: 100%;
    height: 56px;
    font-size: 20px;
    text-align: right;
    margin-bottom: 10px;
    padding: 20px;
    border-radius: 5px;
    color: #333; /* Set text color */
    background-color: #f8f8f8; /* Set background color */
    border: 1px solid #ccc; /* Add a border */
    box-sizing: border-box;
}

.buttons {
    display: flex;
    flex-wrap: wrap;
    width: 100%;
    justify-content: space-between;
}

.button {
    width: calc(100% / 5);
    height: 60px;
    margin: 10px 5px;
    border-radius: 10px;
    background-color: #819182; /* Set button background color */
    color: #ffffff; /* Set button text color */
    font-size: 18px;
    cursor: pointer;
    border: none;
    display: flex;
    align-items: center;
    justify-content: center;
    transition: all 0.3s ease-in-out;
    box-shadow: 0px 1px 3px rgba(0, 0, 0, 0.1);
}

.button:hover {
    transform: translateY(-4px);
    box-shadow: 0px 2px 4px 2px rgba(0, 0, 0, 0.1);
}

.button:focus {
    outline: none;
}

/* Add styles for the log section */
.log {
    margin-top: 20px;
}

.log h2 {
    color: #333;
}

.log ul {
    list-style-type: none;
    padding: 0;
}

.log li {
    margin-bottom: 5px;
    padding: 5px;
    background-color: #ddd;
    border-radius: 5px;
}

footer {
    margin-top: 15px;
    font-size: 18px;
    color: #333;
    text-align: center;
}
</style>
