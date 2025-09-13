describe('API Tests for Products', () => {
    const baseUrl = 'http://localhost:8080/api/products';

    it('GET all products', () => {
        cy.request('GET', baseUrl).then((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).to.be.an('array');
        });
    });

    it('POST new product', () => {
        cy.request('POST', baseUrl, {
            name: 'Smartwatch',
            price: 200.0,
            imageUrl: '/images/product4.jpg'
        }).then((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).to.have.property('id');
            expect(response.body.name).to.eq('Smartwatch');
        });
    });

    it('GET product by ID', () => {
        cy.request('GET', `${baseUrl}/1`).then((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).to.have.property('id', 1);
        });
    });
});
