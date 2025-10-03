package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WishListPage {
    WebDriver driver;
    private final By wishListBtnLocator = By.className("add-to-wishlist-button");
    private final By wishListQty = By.className("wishlist-qty");

    public WishListPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToWishList() {
        driver.findElement(wishListBtnLocator).click();
        driver.navigate().refresh();
        Assert.assertNotEquals(driver.findElement(wishListQty).getText(),"0");
    }
}
