package pages;

public class LoginPage extends SignupLoginPage {
    public void login(String email, String password) {
        enterLoginDetails(email, password);
        clickLogin();
    }
}
