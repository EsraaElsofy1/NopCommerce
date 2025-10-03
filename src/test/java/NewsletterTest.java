import example.BaseClass;
import example.NewsletterPage;
import example.utils.TestDataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class NewsletterTest extends BaseClass {
    NewsletterPage newsletterPage;

    @Test(dataProvider = "positiveLoginData",dataProviderClass = TestDataProvider.class)
    public void subscribeNewsletterTest(Map<String,String> data){
        newsletterPage = new NewsletterPage(driver);
        newsletterPage.scrollToFooter();
        newsletterPage.subscribeNewsletter(data);
    }
}
