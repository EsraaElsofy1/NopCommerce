import example.BaseClass;
import example.CheckOutPage;
import example.utils.TestDataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class CheckOutTest extends BaseClass {
    CheckOutPage checkOutPage;

    @Test(dataProvider = "checkOutData", dataProviderClass = TestDataProvider.class)
    public void checkoutTest(Map<String, String> checkoutData) {
        checkOutPage = new CheckOutPage(driver);
        checkOutPage.CheckAgreement();
        checkOutPage.CheckOutButton();
        checkOutPage.checkOutCredential(checkoutData);
        checkOutPage.submitCheckOut();
    }


}
