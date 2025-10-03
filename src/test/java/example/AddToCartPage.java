package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class AddToCartPage {
    String itemName;
    String itemPrice;
    WebDriver driver;
    private final By itemLocator = By.className("product-item");
    private final By addToCartBtn = By.className("product-box-add-to-cart-button");
    private final By dropDownListLocator = By.id("product_attribute_9");
    private final By colorOfItem = By.xpath("//*[@id=\"color-squares-10\"]/li[2]/label/span/span");
    private final By submitButton = By.id("add-to-cart-button-27");
    private final By itemDescriptionLocator = By.className("product-name");
    private final By itemNameLocator = By.xpath("//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[1]/h1");
    private final By priceLocator = By.className("price-value-27");
    private final By itemPriceCart = By.className("product-unit-price");
    private final By shoppingCartButton = By.className("cart-label");

    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseItem() {
        List<WebElement> items = driver.findElements(itemLocator);

        if (items.isEmpty()) {
            System.out.println("No products found!");
            return;
        }
        WebElement item = items.get(1);

        WebElement addToCartButton = item.findElement(addToCartBtn);
        addToCartButton.click();
    }

    public void chooseSizeOfItem() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            List<WebElement> dropdowns = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(dropDownListLocator));

            if (dropdowns.isEmpty()) {
                System.out.println("No size dropdown found for this product.");
                return;
            }
            WebElement dropdownElement = dropdowns.getFirst();
            Select sizeDropdown = new Select(dropdownElement);
            List<WebElement> options = sizeDropdown.getOptions();

            if (options.size() > 1) {
                Random rand = new Random();
                int randomIndex = rand.nextInt(options.size() - 1) + 1;
                sizeDropdown.selectByIndex(randomIndex);
            } else {
                System.out.println("Dropdown has no selectable options.");
            }

        } catch (Exception e) {
            System.out.println("Error while choosing size: " + e.getMessage());
        }
    }

    public void chooseColorOfItem() {
        try {
            Assert.assertTrue(driver.findElement(colorOfItem).isDisplayed());
            driver.findElement(colorOfItem).click();
        } catch (Exception e) {
            System.out.println("Error while choosing color: " + e.getMessage());
        }

    }

    public void checkCartDetails() {
        driver.findElement(shoppingCartButton).click();
        driver.navigate().refresh();
        try {
            Assert.assertEquals(driver.findElement(itemDescriptionLocator).getText(), itemName);
            Assert.assertEquals(driver.findElement(itemPriceCart).getText(), itemPrice);
        } catch (Exception e) {
            System.out.println("Error while checking cart details!");
        }
    }

    public void submitButton() {
        itemName = driver.findElement(itemNameLocator).getText();
        itemPrice = driver.findElement(priceLocator).getText();
        driver.findElement(submitButton).click();
    }
}
