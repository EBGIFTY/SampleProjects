
describe('Handle the dropdowns on webpage', () => {

    //added comment
    it('Change the dropdown value', () => {

        cy.visit('https://www.bstackdemo.com/');
        cy.get('select').select("Highest to lowest")
       
    })

    it('validate the already selected value in dropdown', () => {

        cy.visit('https://www.bstackdemo.com/');
        cy.get('select').invoke("val").should("eq", "")
    })


})
