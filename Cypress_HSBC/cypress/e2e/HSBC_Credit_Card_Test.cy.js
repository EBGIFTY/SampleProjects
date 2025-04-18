
describe("HSBC Credit Card Scenario",()=>{
    
    it("Credit Card Test",()=>{
    cy.visit("https://www.hsbc.co.in/");
    cy.get("ul.row > :nth-child(1)").trigger('mouseover').click();
     cy.xpath("//div/ul/li[1]/div[2]//div/div[1]/div/div[1]/a/h2").click({force: true});
     
     cy.get("h1").contains("Credit cards").screenshot("Credit Card Header");
    
     cy.get("#chp_main_link_2>a>[class='link text']").contains("HSBC Cashback Credit Card");
     cy.get("#chp_main_link_2>a>[class='link text']").click();
     
     cy.get("#pp_intro_button_1>span").should('be.visible');
     cy.url().should('contain',"credit-cards/products/visa-cashback/");
     cy.get("#pp_intro_image_3").should('be.visible');
     cy.get("#pp_tools_richtext_2>p>span[class='A-TYP22L-RW-ALL']").should('be.visible');
     cy.get("#pp_tools_richtext_3>p>span[class='A-TYP22L-RW-ALL']").should('be.visible');
     cy.get("img.LPMimage").should('be.visible');
     cy.get("div.header-logo>a>[alt='HSBC India Bank']").click();
     cy.title().should("eq","HSBC India - Credit Cards, NRI Services, Saving and Deposit");
     cy.screenshot("Credit Card");
     

})
})