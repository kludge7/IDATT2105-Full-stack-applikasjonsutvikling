<template>
    <form class="contact-form">
        <h3>Leave a review</h3>
        <label for="name">Name:</label>
        <input id="name" v-model="name">

        <label for="email">Email:</label> 
        <input id="email" v-model="email">    

        <label for="message">Message:</label> 
        <textarea id="message" v-model="message"></textarea>
        <SubmitButton :disabled="isSubmitDisabled" @click="onSubmit" />

        <div v-if="submissionStatus === 'success'" class="success">
            Submission successful
        </div>
    </form>
</template>

<script>
    import SubmitButton from './SubmitButton.vue';
    export default {
        mounted() {
            console.log('Component mounted. submissionStatus:', this.submissionStatus);
        },
        components: {
            SubmitButton,
        },
        data() {
            return {
                name: localStorage.getItem('savedName') || '',
                email: localStorage.getItem('savedEmail') || '',
                message: '',
                submissionStatus: localStorage.getItem('savedStatus') || null
            };
        },
        computed: {
            isSubmitDisabled() {
                return this.name === '' || this.email === '' || this.message === '';
            },
        },
        methods: {
            async onSubmit() {
                if (this.isSubmitDisabled) {
                    alert('Review is incomplete. Please fill out every field.');
                    return;
                }

                localStorage.setItem('savedName', this.name);
                localStorage.setItem('savedEmail', this.email);
                localStorage.setItem('savedStatus', 'success');

                
                if (this.isValidUsername()) {
                    console.log('Form submitted with valid username:', this.name);
                } else {
                    console.log('Invalid username');
                }
                
                if (this.isValidEmail()) {
                    console.log('Form submitted with valid email:', this.email);
                } else {
                    console.log('Invalid email');
                }
                try {
                    await fetch('http://localhost:3001/reviews', {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'json',
                        },
                        body: JSON.stringify({
                            name: this.name,
                            email: this.email,
                            message: this.message,
                        })
                    });
                } catch (error) {
                    console.error('Error submitting the form:', error);
                }
            },
            isValidUsername() {
                return this.name.toUpperCase() === 'AA';
            },
            isValidEmail() {
                return this.email.toUpperCase() === 'AA';
            },
        },
};
</script>

<style>
.submit-button {
    background-color: #3498db;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 16px;
    transition: background-color 0.3s;
}

.submit-button:hover {
    background-color: #2980b9;
}

.submit-button:disabled {
    background-color: #c0c5c9;
    cursor: not-allowed;
}

input,
textarea,
select {
    width: 100%;
    padding: 8px;
    margin-bottom: 16px;
    box-sizing: border-box;
}

.success {
    color: green;
}

.error {
    color: red;
}
</style>