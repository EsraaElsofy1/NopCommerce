import example.BaseClass;
import example.CompareProductPage;
import org.testng.annotations.Test;

public class CompareProductTest extends BaseClass {
    CompareProductPage compareProductPage ;
    @Test
    public void compareProductTest(){
        compareProductPage = new CompareProductPage(driver);
        compareProductPage.chooseCategory();
    }

}
