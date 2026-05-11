package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private final By signupLoginButton = By.xpath("//a[contains(normalize-space(),'Signup / Login')]");
    private final By homeSlider = By.id("slider-carousel");

    public void open(String url) {
        driver.get(url);
    }

    public void clickSignupLogin() {
        click(signupLoginButton);
    }

    public boolean isHomePageVisible() {
        return driver.getTitle().contains("Automation Exercise") || waitForVisible(homeSlider).isDisplayed();
    }
}
