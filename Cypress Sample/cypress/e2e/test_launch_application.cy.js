describe('Validate the application is launching sucessfully', () => {
  it('passes', () => {
    cy.visit('https://www.facebook.com/r.php?locale=en_GB&display=page')
    cy.contains('Return home').click()
  })
})