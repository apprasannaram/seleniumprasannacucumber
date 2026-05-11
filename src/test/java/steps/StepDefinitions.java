package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.SignupLoginPage;

public class StepDefinitions {
    private final HomePage homePage = new HomePage();
    private final SignupLoginPage signupLoginPage = new SignupLoginPage();

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        String baseUrl = System.getProperty("baseUrl", "https://automationexercise.com");
        homePage.open(baseUrl);
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");
    }

    @When("I navigate to the Signup\\/Login page")
    public void iNavigateToTheSignupLoginPage() {
        homePage.clickSignupLogin();
    }

    @And("I enter name {string} and unique email")
    public void iEnterNameAndUniqueEmail(String name) {
        String uniqueEmail = "test" + System.currentTimeMillis() + "@example.com";
        signupLoginPage.enterNameAndEmail(name, uniqueEmail);
    }

    @And("I click Signup")
    public void iClickSignup() {
        signupLoginPage.clickSignup();
    }

    @Then("I should see the {string} page")
    public void iShouldSeeThePage(String expectedText) {
        Assert.assertTrue(signupLoginPage.isAccountInformationPageVisible(), expectedText + " page is not visible");
    }

    @And("I enter invalid email and password")
    public void iEnterInvalidEmailAndPassword() {
        signupLoginPage.enterLoginDetails("invalid" + System.currentTimeMillis() + "@example.com", "wrongPassword");
    }

    @And("I click Login")
    public void iClickLogin() {
        signupLoginPage.clickLogin();
    }

    @Then("I should see the invalid login error message")
    public void iShouldSeeInvalidLoginErrorMessage() {
        Assert.assertTrue(signupLoginPage.isLoginErrorVisible(), "Invalid login error message is not visible");
    }
}
