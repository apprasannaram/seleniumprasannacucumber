package pages;

import org.openqa.selenium.By;

public class SignupLoginPage extends BasePage {
    private final By newUserSignupText = By.xpath("//h2[contains(normalize-space(),'New User Signup!')]");
    private final By signupNameField = By.xpath("//input[@data-qa='signup-name']");
    private final By signupEmailField = By.xpath("//input[@data-qa='signup-email']");
    private final By signupButton = By.xpath("//button[@data-qa='signup-button']");
    private final By accountInformationHeader = By.xpath("//*[contains(normalize-space(),'Enter Account Information')]");
    private final By loginEmailField = By.xpath("//input[@data-qa='login-email']");
    private final By loginPasswordField = By.xpath("//input[@data-qa='login-password']");
    private final By loginButton = By.xpath("//button[@data-qa='login-button']");
    private final By loginError = By.xpath("//*[contains(text(),'Your email or password is incorrect!')]");

    public boolean isNewUserSignupVisible() {
        return waitForVisible(newUserSignupText).isDisplayed();
    }

    public void enterNameAndEmail(String name, String email) {
        type(signupNameField, name);
        type(signupEmailField, email);
    }

    public void clickSignup() {
        click(signupButton);
    }

    public boolean isAccountInformationPageVisible() {
        return waitForVisible(accountInformationHeader).isDisplayed();
    }

    public void enterLoginDetails(String email, String password) {
        type(loginEmailField, email);
        type(loginPasswordField, password);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public boolean isLoginErrorVisible() {
        return waitForVisible(loginError).isDisplayed();
    }
}
