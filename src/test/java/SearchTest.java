import example.BaseClass;
import example.SearchPage;
import example.utils.TestDataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class SearchTest extends BaseClass {
    SearchPage searchPage;

    @Test(dataProvider = "searchData", dataProviderClass = TestDataProvider.class)
    public void searchTest(Map<String, String> userData) {
        searchPage = new SearchPage(driver);
        searchPage.setSearchBoxText(userData);
    }
}
