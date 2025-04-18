
describe("HSBC Login Scenario",()=>{
    
    it("Login Test",()=>{
        cy.visit("https://www.hsbc.co.in/");
        cy.get("h1").should('be.visible');
        cy.title().should('eq',"HSBC India - Credit Cards, NRI Services, Saving and Deposit");
        
        cy.get("li[class='header-user-wrapper']>div>a[class='selected-item login-button only-one-link']").click({force: true});
        cy.get(".crh-chevron-link__text").click();
        cy.get("div>h2>span").should('be.visible');

        cy.get("#username_submit_btn").should('be.visible');
        cy.get("button#username_submit_btn").should('be.disabled');
        cy.get("input#username").type("Srikanthkurella@gmail.com");
        cy.get("button#username_submit_btn").should('be.enabled');
        cy.get("#username_help_link>span>span[aria-hidden='true']").should('be.visible');
        cy.get("#username_help_link>span>span[aria-hidden='true']").click();
        cy.get("#help_content_1>h3>span").contains("Username");
        cy.get("a.close-btn>span>span[aria-hidden='true']").should('be.visible');
        cy.get("a.close-btn>span>span[aria-hidden='true']").click();
        cy.screenshot();

    })
})