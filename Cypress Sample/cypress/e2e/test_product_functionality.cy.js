import { LoginFunction } from "../utils/login_page";
import { ValidateProductPrice } from "../utils/products_page";

describe('Validate the product page functionality', () => {

    beforeEach(() => {
        cy.visit('https://www.saucedemo.com/v1/index.html');
        LoginFunction('standard_user', 'secret_sauce');
    })

    it('Validate the product price', () => {

        ValidateProductPrice('Sauce Labs Backpack','$29.99');
        ValidateProductPrice('Sauce Labs Bike Light','$9.99');
        ValidateProductPrice('Sauce Labs Bolt T-Shirt','$15.99');
    })

})