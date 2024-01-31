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
            { value: '(' },
            { value: ')' },
            { value: '=' },


        ];
      // Array of the log
        const log = [];
      // Function to update display based on button click
      // When the user clicks =, then the eval function is able to calculate the display.value
      // If not then the value of the button clicked is added to the display (not very smart system)
      // The eval() function evaluates JavaScript code represented as a string and returns its completion value. 
      // The source is parsed as a script.
        function updateDisplay(value) {
            if (value === '=') {
                try {
                    log.push(display.value + '=' + eval(display.value) )
                    return display.value = eval(display.value);
                } catch(SyntaxError) {
                    alert('ERROR ERROR ERROR')
                } finally {
                    console.log('Easter egg');
                }
            }
            if (value === 'AC') {
                return display.value = ''
            }
            if (value === '%') {
                return display.value /= 100
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
</style>
