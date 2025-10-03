package example;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class CompareProductPage {
    WebDriver driver;
    private final By itemLocator = By.className("product-item");
    private final By listLocator = By.className("inactive");
    private final By compareBtnLocator = By.className("add-to-compare-list-button");
    private final By nestedListLocator = By.className("item-box");


    public CompareProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseCategory() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Random rand = new Random();

        List<WebElement> categories = driver.findElements(listLocator);

        if (categories.isEmpty()) {
            return;
        }

        WebElement randomItem = categories.get(1);
        WebElement link = randomItem.findElement(By.tagName("a"));
        String categoryName = link.getText();

        wait.until(ExpectedConditions.elementToBeClickable(link)).click();

        try {
            List<WebElement> nestedCategories = driver.findElements(nestedListLocator);
            if (!nestedCategories.isEmpty()) {
                int nestedIndex = rand.nextInt(nestedCategories.size());
                WebElement nestedItem = nestedCategories.get(nestedIndex);

                WebElement nestedLink = nestedItem.findElement(By.tagName("a"));

                wait.until(ExpectedConditions.elementToBeClickable(nestedLink)).click();
                chooseItem();
            } else {
                System.out.println("No nested categories found for: " + categoryName);
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("Stale element - retrying...");
            chooseItem();
        }
    }


    public void chooseItem() {
        List<WebElement> items = driver.findElements(itemLocator);
        Random rand = new Random();

        if (items.isEmpty()) {
            System.out.println("No products found!");
            return;
        }
        int randomIndex = rand.nextInt(items.size());
        WebElement randomItem = items.get(randomIndex);

        WebElement compareButton = randomItem.findElement(compareBtnLocator);
        compareButton.click();
    }

}
