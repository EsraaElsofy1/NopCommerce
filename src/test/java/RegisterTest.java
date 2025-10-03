import example.BaseClass;
import example.RegisterPage;
import example.utils.TestDataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class RegisterTest extends BaseClass {
    RegisterPage registerPage;

    @Test(dataProvider = "getNegativeRegisterData", dataProviderClass = TestDataProvider.class)
    public void negativeRegisterTest(Map<String, String> userData) {
        registerPage = new RegisterPage(driver);
        registerPage.clickRegisterButton();
        registerPage.registerTest(userData);
        registerPage.submitRegistrationButton();
    }

    @Test(dataProvider = "getPositiveRegisterData", dataProviderClass = TestDataProvider.class, dependsOnMethods = {"negativeRegisterTest"})
    public void positiveRegisterTest(Map<String, String> userData) {
        registerPage = new RegisterPage(driver);
        registerPage.clickRegisterButton();
        registerPage.registerTest(userData);
        registerPage.submitRegistrationButton();
        registerPage.clickContinueButton();
        registerPage.clickLogoutButton();
    }
}
