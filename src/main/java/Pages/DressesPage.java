package Pages;

import Base.BasePage;
import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DressesPage extends BasePage {
    public static WebDriver driver;
    public static final By H1_TITLE = By.xpath("//h1/span[1]");
    public static String DRESS_SUBPAGE_LOCATOR = "//div[@class='subcategory-image']/a[@title='Evening Dresses']";


    public DressesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public static String getH1Title(){
        return BaseTest.getDriver().findElement(H1_TITLE).getText();
    }

    public static BasePage openDressesSubPage(String subPage) {
        switch (subPage) {
            case "Casual Dresses": {
                click(getLocator(DRESS_SUBPAGE_LOCATOR, subPage));
                return new DressesPage(driver);
            }
            case "Evening Dresses": {
                click(getLocator(DRESS_SUBPAGE_LOCATOR, subPage));
                return new EveningDressesPage(driver);
            }
//            case "Summer Dresses": {
//                click(getLocator(DRESS_SUBPAGE_LOCATOR, subPage));
//                return new SummerDresses(driver);
//            }
            default:
                throw new IllegalStateException("No links are found for this subpage: " + subPage);
        }
    }
}
