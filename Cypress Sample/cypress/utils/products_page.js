

export function ValidateProductPrice(ProductName,ProductPrice) {

    cy.xpath(`//div[text()="${ProductName}"]/following::div[@class="inventory_item_price"][1]`).should('have.text',ProductPrice)

}