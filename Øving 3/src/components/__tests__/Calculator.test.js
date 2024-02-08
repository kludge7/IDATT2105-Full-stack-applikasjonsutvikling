import { mount } from "@vue/test-utils"
import Calculator from '../Calculator.vue'
import { describe, expect, test } from 'vitest'

describe('Calculator component', () => {
    test('performs basic calculation', () => {
        const wrapper = mount(Calculator);
        wrapper.vm.updateDisplay('1');
        wrapper.vm.updateDisplay('+');
        wrapper.vm.updateDisplay('2');
        wrapper.vm.updateDisplay('=');
        expect(wrapper.vm.display).toBe(3);
      });

    test('resets display when AC button is clicked', () => {
        const wrapper = mount(Calculator);
        wrapper.vm.updateDisplay('1');
        wrapper.vm.updateDisplay('+');
        wrapper.vm.updateDisplay('2');
        wrapper.vm.updateDisplay('AC');
        expect(wrapper.vm.display).toBe('');
      });

    test('divides display by 100 when % button is clicked', () => {
        const wrapper = mount(Calculator);
        wrapper.vm.updateDisplay('50');
        wrapper.vm.updateDisplay('%');
        expect(wrapper.vm.display).toBe(0.5);
    });
})
