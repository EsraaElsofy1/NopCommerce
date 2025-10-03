import example.BaseClass;
import example.LoginPage;
import example.utils.TestDataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginTest extends BaseClass {
    LoginPage loginPage;

    @Test(dataProvider = "NegativeLoginData", dataProviderClass = TestDataProvider.class)
    public void checkNegativeLoginTest(Map<String, String> loginData) {
        loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        loginPage.loginTest(loginData);
    }

    @Test(dataProvider = "positiveLoginData", dataProviderClass = TestDataProvider.class, dependsOnMethods = {"checkNegativeLoginTest"})
    public void checkPositiveLoginTest(Map<String, String> loginData) {
        loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        loginPage.loginTest(loginData);
    }
}
