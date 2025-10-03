package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Map;

public class RegisterPage {
    WebDriver driver;
    private final By registerButton = By.className("ico-register");
    private final By firstName = By.id("FirstName");
    private final By lastName = By.id("LastName");
    private final By email = By.id("Email");
    private final By password = By.id("Password");
    private final By confirmPassword = By.id("ConfirmPassword");
    private final By submitButton = By.id("register-button");
    private final By logoutButton = By.className("ico-logout");
    private final By continueButton = By.className("register-continue-button");
    private final By itemName = By.id("itemName");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public void registerTest(Map<String, String> userData) {
        driver.findElement(firstName).sendKeys(userData.get("firstName"));
        driver.findElement(lastName).sendKeys(userData.get("lastName"));
        driver.findElement(email).sendKeys(userData.get("email"));
        driver.findElement(password).sendKeys(userData.get("password"));
        driver.findElement(confirmPassword).sendKeys(userData.get("confirmPassword"));
    }

    public void submitRegistrationButton() {
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

    public void clickContinueButton() {
        try {
            Assert.assertTrue(driver.findElement(continueButton).isDisplayed());
            driver.findElement(continueButton).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
