<template>
    <button class="submit-button" :disabled="disabled">
        Submit
    </button>
</template>

<script>
export default {
    props: {
        disabled: Boolean,
    },
};
</script>

<style>
</style>