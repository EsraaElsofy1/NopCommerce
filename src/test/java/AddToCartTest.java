import example.AddToCartPage;
import example.BaseClass;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseClass {
    AddToCartPage addToCartPage;

    @Test
    public void addToCartTest() {
        addToCartPage = new AddToCartPage(driver);
        addToCartPage.chooseItem();
    }

    @Test(dependsOnMethods = {"addToCartTest"})
    public void selectProductOption() {
        addToCartPage = new AddToCartPage(driver);
        addToCartPage.chooseSizeOfItem();
        addToCartPage.chooseColorOfItem();
    }

    @Test(dependsOnMethods = {"selectProductOption"})
    public void submitOrder() {
        addToCartPage = new AddToCartPage(driver);
        addToCartPage.submitButton();
        addToCartPage.checkCartDetails();
    }


}
