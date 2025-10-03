package example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
    protected static WebDriver driver;
    protected RegisterPage registerPage;

    @BeforeSuite
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        registerPage = new RegisterPage(driver);
    }

}
