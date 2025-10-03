package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class SearchPage {
    WebDriver driver;
    private final By searchBox = By.className("search-box-text");
    private final By searchButton = By.className("search-box-button");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setSearchBoxText(Map<String, String> userData) {
        driver.findElement(searchBox).sendKeys(userData.get("product"));
        driver.findElement(searchButton).click();
    }
}
