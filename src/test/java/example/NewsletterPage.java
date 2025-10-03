package example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class NewsletterPage {
    WebDriver driver;
    private final By newsLetterEmailLocator = By.id("newsletter-email");
    private final By newsLetterBtnLocator = By.id("newsletter-subscribe-button");

    public NewsletterPage(WebDriver driver){
        this.driver = driver;
        By homePageLocator = By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img");
        driver.findElement(homePageLocator).click();
    }

    public void scrollToFooter()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public  void subscribeNewsletter(Map<String,String> map){
        driver.findElement(newsLetterEmailLocator).sendKeys(map.get("email"));
        driver.findElement(newsLetterBtnLocator).click();
    }

}
