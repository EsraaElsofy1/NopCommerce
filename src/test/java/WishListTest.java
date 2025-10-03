import example.BaseClass;
import example.SearchPage;
import example.WishListPage;
import example.utils.TestDataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class WishListTest extends BaseClass {
    WishListPage wishListPage;
    SearchPage searchPage;

    @Test(dataProvider = "wishListSearch", dataProviderClass = TestDataProvider.class)
    public void addWishListTest(Map<String, String> userData)
    {
        wishListPage = new WishListPage(driver);
        searchPage=new SearchPage( driver);
        searchPage.setSearchBoxText(userData);
        wishListPage.clickAddToWishList();
    }

}
