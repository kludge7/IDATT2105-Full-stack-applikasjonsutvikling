// cypress/integration/contactForm.spec.js
describe('Contact Form', () => {
    beforeEach(() => {
        cy.visit('http://localhost:5173/form');
    });

    it('Possible to submit with everything filled in, but impossible with email being blank', () => {
        cy.get('#name').type('Ola Nordmann');
        cy.get('#email').type('ola-normann@gmail.com');
        cy.get('#message').type('Fredager er for TACO!');
        cy.get('.submit-button').should('not.be.disabled');

        cy.get('#email').clear();
        cy.get('.submit-button').should('be.disabled');
    });

    it('Form is submitted sucessfully with valid data', () => {
        cy.get('#name').type('Ola Nordmann');
        cy.get('#email').type('ola-normann@gmail.com');
        cy.get('#message').type('Fredager er for TACO!');
        cy.get('.submit-button').click();
        // eslint-disable-next-line cypress/no-unnecessary-waiting
        cy.wait(1000);
        cy.contains('.success', 'Submission successful');
    });
});
