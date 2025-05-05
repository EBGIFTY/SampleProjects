


// =============== Locators =========================

const uname_elm = '#user-name'
const pwd_elm = '#password'
const loginbtn_elm = '#login-button'
const error_elm = 'h3'


// ============== Functions =======================

export function LoginFunction(Username,Password){

    cy.get(uname_elm).type(Username);
    cy.get(pwd_elm).type(Password);
    cy.get(loginbtn_elm).click();

}

export function ValidateError(Message){
    cy.get(error_elm).contains(Message);
}
