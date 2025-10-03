package example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class CheckOutPage {
    WebDriver driver;
    private final By checkAgreement = By.id("termsofservice");
    private final By checkOutButton = By.id("checkout");
    private final By CompanyLocator = By.id("BillingNewAddress_Company");
    private final By stateLocator = By.id("BillingNewAddress_StateProvinceId");
    private final By cityLocator = By.id("BillingNewAddress_City");
    private final By address1Locator = By.id("BillingNewAddress_Address1");
    private final By address2Locator = By.id("BillingNewAddress_Address2");
    private final By zipPostalCodeLocator = By.id("BillingNewAddress_ZipPostalCode");
    private final By phoneNumberLocator = By.id("BillingNewAddress_PhoneNumber");
    private final By faxNumberLocator = By.id("BillingNewAddress_FaxNumber");
    private final By continueButton = By.className("new-address-next-step-button");
    private final By shippingButton = By.className("shipping-method-next-step-button");
    private final By paymentMethodButton = By.className("payment-method-next-step-button");
    private final By paymentInfoButton = By.className("payment-info-next-step-button");
    private final By confirmOrderButton = By.className("confirm-order-next-step-button");
    private final By completeOrderButton = By.className("order-completed-continue-button");

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void CheckAgreement() {
        driver.findElement(checkAgreement).click();
    }

    public void CheckOutButton() {
        driver.findElement(checkOutButton).click();
    }

    public void checkOutCredential(Map<String, String> checkOutData) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(CompanyLocator)).sendKeys(checkOutData.get("company"));
            Select stateDropdown = new Select(driver.findElement(stateLocator));
            stateDropdown.selectByVisibleText(checkOutData.get("state"));
            driver.findElement(cityLocator).sendKeys(checkOutData.get("city"));
            driver.findElement(address1Locator).sendKeys(checkOutData.get("address1"));
            driver.findElement(address2Locator).sendKeys(checkOutData.get("address2"));
            driver.findElement(zipPostalCodeLocator).sendKeys(checkOutData.get("zipPostalCode"));
            driver.findElement(phoneNumberLocator).sendKeys(checkOutData.get("phoneNumber"));
            driver.findElement(faxNumberLocator).sendKeys(checkOutData.get("fax"));
        } catch (Exception e) {
            System.out.println("Data already saved ");
        }
    }

    public void submitCheckOut() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<By> checkoutButtons = Arrays.asList(
                continueButton,
                shippingButton,
                paymentMethodButton,
                paymentInfoButton,
                confirmOrderButton,
                completeOrderButton
        );
        try {
            for (By buttonLocator : checkoutButtons) {
                WebElement button = wait.until(ExpectedConditions.elementToBeClickable(buttonLocator));
                button.click();
            }
        } catch (Exception e) {
            System.out.println("An error occurred during checkout: " + e.getMessage());
        }
    }
}