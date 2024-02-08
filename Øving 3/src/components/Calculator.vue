<template>
    <div class="calculator">
        <input class="display" type="text" v-model="display" disabled />
        <div class="buttons">
            <button class="button" v-for="button in buttons" :key="button.value" @click="updateDisplay(button.value)">
                {{ button.value }}
            </button>
        </div>
    </div>
    <div class="log">
        <h2>Log</h2>
        <ul>
            <li v-for="(item, index) in log.slice().reverse()" :key="index">
                {{ item }}
            </li>
        </ul>
    </div>
    <footer class="footer">
        Developed by 🤡Andreas🤡Kluge🤡Svendsrud🤡
    </footer>
</template>

<script>
import { ref } from 'vue';
export default {
    setup() {
        const display = ref('');
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
        const log = ref([]);
        function updateDisplay(value) {
            if (value === '=') {
                try {
                    log.value.push(display.value + '=' + eval(display.value) )
                    return display.value = eval(display.value);
                } catch(SyntaxError) {
                    alert('ERROR ERROR ERROR')
                    return display.value = ''
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
            else if (value !== '=' && value !== 'AC' && value !== '%') {
                display.value += value;
            }
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
    max-height: 100px; /* Adjust the maximum height as needed */
    overflow-y: auto; /* Enable vertical scrolling if content overflows */
    margin-top: 20px;
    color: #333;
    }

    .footer {
        margin-top: 15px;
        font-size: 18px;
        color: #333;
        text-align: center;
    }
</style>
