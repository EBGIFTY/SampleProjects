import { LoginFunction, ValidateError } from "../utils/login_page";

describe('Validate the application login functionality', () => {

    beforeEach(() => {
        cy.visit('https://www.saucedemo.com/v1/index.html');
    })

    it('Login Success', () => {

        cy.login('standard_user', 'secret_sauce');
        //LoginFunction('standard_user', 'secret_sauce');
        //cy.get('div.product_label').contains('Products');
        cy.get('div.product_label').should("have.text", 'Products');
    })


    it('Login Failiure', () => {

        LoginFunction('standard_user', 'abc1234');
        ValidateError('Epic sadface: Username and password do not match any user in this service');

    })

    it('Login Failiure for locked user', () => {

        LoginFunction('locked_out_user', 'secret_sauce');
        ValidateError('Epic sadface: Sorry, this user has been locked out.');

    })

})



