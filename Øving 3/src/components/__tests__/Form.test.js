import { mount } from '@vue/test-utils';
import Form from '../Form.vue';
import { describe, expect, test } from 'vitest'


describe('Form.vue', () => {
  test('renders the form with correct structure', () => {
    const wrapper = mount(Form);
    expect(wrapper.find('form.contact-form').exists()).toBe(true);
    expect(wrapper.find('label[for="name"]').exists()).toBe(true);
    expect(wrapper.find('input#name').exists()).toBe(true);
  });

  test('initializes with empty name, email, and message', () => {
    const wrapper = mount(Form);
    expect(wrapper.vm.name).toBe('');
    expect(wrapper.vm.email).toBe('');
    expect(wrapper.vm.message).toBe('');
  });

  test('disables submit button when form is incomplete', () => {
    const wrapper = mount(Form);
    expect(wrapper.vm.isSubmitDisabled).toBe(true);
  });

  test('enables submit button when form is complete', async () => {
    const wrapper = mount(Form);
    await wrapper.setData({ name: 'John', email: 'john@example.com', message: 'Test message' });
    expect(wrapper.vm.isSubmitDisabled).toBe(false);
  });

  test('emits a "click" event when submit button is clicked', async () => {
    const wrapper = mount(Form);
    await wrapper.trigger('click');
    expect(wrapper.emitted('click')).toBeTruthy();
  });
});
