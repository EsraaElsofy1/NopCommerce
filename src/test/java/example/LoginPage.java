package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Map;

public class LoginPage {
    WebDriver driver;
    private final By loginButton = By.className("ico-login");
    private final By emailField = By.className("email");
    private final By passwordField = By.className("password");
    private final By submitButton = By.className("login-button");
    private final By logoutButton = By.className("ico-logout");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void loginTest(Map<String, String> loginData) {
        driver.findElement(emailField).sendKeys(loginData.get("email"));
        driver.findElement(passwordField).sendKeys(loginData.get("password"));
        driver.findElement(submitButton).click();
    }

    public void clickLogoutButton() {
        try {
            Assert.assertTrue(driver.findElement(logoutButton).isDisplayed());
            driver.findElement(logoutButton).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
