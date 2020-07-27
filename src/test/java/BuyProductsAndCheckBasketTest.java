import Base.BasePage;
import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Test
public class BuyProductsAndCheckBasketTest extends BaseTest {

    private final String URL = "http://automationpractice.com/";
    private final String SUBPAGE_NAME1 = "T-shirts";
    private final String T_SHIRT_PRODUCT_NAME = "Faded Short Sleeve T-shirts";
    private final String T_SHIRT_EXPECTED_H1_PAGE = "T-SHIRTS ";
    private final String DRESSES_EXPECTED_H1_PAGE = "DRESSES ";
    private final String EVENING_DRESS = "Printed Dress";
    private final String SUBPAGE_NAME2 = "Dresses";

    public void BuyProductAndCheckBasket() {
        MainPage mainPage = new MainPage(getDriver());
        BasePage basePage = new BasePage();
        basePage.openUrl(URL);
        mainPage.openSubPage(SUBPAGE_NAME1);
        assertEquals(TShirtPage.getH1Title(), T_SHIRT_EXPECTED_H1_PAGE);
        ProductPage.openProductPage(T_SHIRT_PRODUCT_NAME);
        assertEquals(ProductPage.getH1Title(), "Faded Short Sleeve T-shirts");
        ProductPage.addToCardAndContinueShopping();
        assertEquals(ProductPage.getAddedProductCount(), "1");
        mainPage.openSubPage(SUBPAGE_NAME2);
        assertEquals(DressesPage.getH1Title(),DRESSES_EXPECTED_H1_PAGE);
        DressesPage.openDressesSubPage("Evening Dresses");
        assertEquals(EveningDressesPage.getH1Title(), "EVENING DRESSES ");
        ProductPage.openProductPage(EVENING_DRESS);
        assertEquals(ProductPage.getH1Title(), "Printed Dress");
        ProductPage.addToCardAndProceedToCheckout();
        assertEquals(ShoppingCartSummaryPage.checkProductCountInCard(), "2");
    }
}

