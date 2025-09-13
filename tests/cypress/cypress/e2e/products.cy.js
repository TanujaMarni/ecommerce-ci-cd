// cypress/e2e/products.cy.js
describe('Products Page Tests', () => {
    // Base URL is set in cypress.config.js
    beforeEach(() => {
        cy.request('GET', '/products'); // relative path; baseUrl is prepended automatically
    });

    it('should display all product cards', () => {
        cy.get('.product-card')
          .should('exist')
          .its('length')
          .should('be.gt', 0); // ensure there is at least one product
    });

    it('should display product names, prices, and images', () => {
        cy.get('.product-card').each(($card) => {
            // Check image exists and loads successfully
            cy.wrap($card).find('img')
              .should('have.attr', 'src')
              .and('not.be.empty')
              .then(($img) => {
                  cy.request($img.prop('src')); // verifies image returns 200 OK
              });

            // Check name exists
            cy.wrap($card).find('h3')
              .should('exist')
              .and('not.be.empty');

            // Check price exists
            cy.wrap($card).find('p span')
              .should('exist')
              .and('not.be.empty');
        });
    });

    it('should have "Add to Cart" buttons', () => {
        cy.get('.product-card button')
          .should('contain.text', 'Add to Cart')
          .and('be.visible');
    });
});
