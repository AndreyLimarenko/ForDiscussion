package Pages;

import Base.BasePage;
import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlobalFooterPage extends BasePage {
    public static WebDriver driver;
    public static final By H4_TITLE = By.xpath("//section[@id='block_contact_infos']//h4");
    public static final By MAP_ICON = By.xpath("//section[@id='block_contact_infos']//i[@class='icon-map-marker']");
    public static final By PHONE_ICON = By.xpath("//section[@id='block_contact_infos']//i[@class='icon-phone']']");
    public static final By EMAIL_ICON = By.xpath("//section[@id='block_contact_infos']//i[@class='icon-envelope-alt']");
    public static final By LOCATION_DATA = By.xpath("//section[@id='block_contact_infos']//li[1]");
    public static final By PHONE_DATA = By.xpath("//section[@id='block_contact_infos']//li[2]");
    public static final By EMAIL_DATA = By.xpath("//section[@id='block_contact_infos']//li[3]");

    public GlobalFooterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public static String getH4Title() {
        return BaseTest.getDriver().findElement(H4_TITLE).getText();
    }

    public static String getElementText(By locator) {

        return BaseTest.getDriver().findElement(locator).getText();
    }

    public static Boolean isIconsDisplayed(){
        if (BaseTest.getDriver().findElement(MAP_ICON).isDisplayed())
            return true;
        if (BaseTest.getDriver().findElement(PHONE_ICON).isDisplayed())
            return true;
        if (BaseTest.getDriver().findElement(EMAIL_ICON).isDisplayed())
            return true;
        else return false;
    }
}
