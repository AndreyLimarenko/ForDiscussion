import Base.BasePage;
import Base.BaseTest;
import Pages.GlobalFooterPage;
import Pages.MainPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test
public class CheckFooterInformationTest extends BaseTest {

    private final String URL = "http://automationpractice.com/";
    private final String H4_EXPECTED_TITLE = "Store information";
    private final String EXPECTED_LOCATION = "Selenium Framework, Research Triangle Park, North Carolina, USA";
    private final String EXPECTED_PHONE = "Call us now: (347) 466-7432";
    private final String EXPECTED_EMAIL = "Email: support@seleniumframework.com";


    public void checkGlobalFooter(){
        MainPage mainPage = new MainPage(getDriver());
        BasePage basePage = new BasePage();
        basePage.openUrl(URL);

        assertEquals(GlobalFooterPage.getH4Title(), H4_EXPECTED_TITLE);
        assertTrue(GlobalFooterPage.isIconsDisplayed(),"Icon is absent");
        assertEquals(GlobalFooterPage.getElementText(GlobalFooterPage.PHONE_DATA), EXPECTED_PHONE);
        assertEquals(GlobalFooterPage.getElementText(GlobalFooterPage.LOCATION_DATA), EXPECTED_LOCATION);
        assertEquals(GlobalFooterPage.getElementText(GlobalFooterPage.EMAIL_DATA), EXPECTED_EMAIL);
    }
}

