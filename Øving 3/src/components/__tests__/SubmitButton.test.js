import { mount } from "@vue/test-utils"
import SubmitButton from '../SubmitButton.vue'
import { describe, expect, test } from 'vitest'

describe('SubmitButton component', () => {
    test('emits a "click" event when the button is clicked', async () => {
        const wrapper = mount(SubmitButton);
        await wrapper.trigger('click');
        expect(wrapper.emitted('click')).toBeTruthy();
      });
})


