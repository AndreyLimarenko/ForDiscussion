package Pages;

import Base.BasePage;
import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartSummaryPage extends BasePage {
    public static WebDriver driver;



    public static final By H1CARDTITLE = By.xpath("//h1");
    public static final By PRODUCT_COUNT_LOCATOR = By.xpath("//span[@id='summary_products_quantity']");


    public ShoppingCartSummaryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public static String getH1Title() {
        return BaseTest.getDriver().findElement(H1CARDTITLE).getText();
    }

    public static String checkProductCountInCard() {
        String value = BaseTest.getDriver().findElement(PRODUCT_COUNT_LOCATOR).getText();
        System.out.println(value);
        value = value.split("([  ])")[0];
        System.out.println(value);
        return value;
    }
}
