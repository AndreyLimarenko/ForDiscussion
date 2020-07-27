package Pages;

import Base.BasePage;
import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class ProductPage extends BasePage {
    public static WebDriver driver;

    public static final By H1_TITLE = By.xpath("//h1");
    public static final By ADD_TO_CARD_BOTTON = By.xpath("//span[.='Add to cart']");
    public static final By CONTINUE_SHOPPING_BOTTON = By.xpath("//span[@title='Continue shopping']");
    public static final By PROCEED_TO_CHECKOUT_BOTTON = By.xpath("//a[@title='Proceed to checkout']");
    public static final String PRODUCT_IMG = "//a[@title='%s']/img";
    public static final By PRODUCT_COUNTER = By.xpath("//a[@title='View my shopping cart']/span[@class='ajax_cart_quantity unvisible']");

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public static String getH1Title(){
return BaseTest.getDriver().findElement(H1_TITLE).getText();
    }

    public static String getAddedProductCount(){
        return BaseTest.getDriver().findElement(PRODUCT_COUNTER).getText();
    }

    public static ProductPage openProductPage(String title){
        click(getLocator(PRODUCT_IMG, title));
        return new ProductPage(driver);
    }

    public static ProductPage addToCardAndContinueShopping(){
        click(ADD_TO_CARD_BOTTON);
        isElementPresented(CONTINUE_SHOPPING_BOTTON);
        click(CONTINUE_SHOPPING_BOTTON);
        return new ProductPage(driver);
    }

    public static ShoppingCartSummaryPage addToCardAndProceedToCheckout(){
        click(ADD_TO_CARD_BOTTON);
        isElementPresented(PROCEED_TO_CHECKOUT_BOTTON);
        click(PROCEED_TO_CHECKOUT_BOTTON);
        return new ShoppingCartSummaryPage(driver);
    }
}
