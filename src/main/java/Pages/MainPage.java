package Pages;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    public WebDriver driver;
    public static final String SUBPAGE_LOCATOR = "//div[@id='block_top_menu']/ul/li/a[.='%s']";


    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public BasePage openSubPage(String subPage) {
        switch (subPage) {
//            case "Women": {
//                click(getLocator(SUBPAGE_LOCATOR, subPage));
//                return new Womanpage(driver);
//            }
            case "Dresses": {
                click(getLocator(SUBPAGE_LOCATOR, subPage));
                return new DressesPage(driver);
            }
            case "T-shirts": {
                click(getLocator(SUBPAGE_LOCATOR, subPage));
                return new TShirtPage(driver);
            }
            default:
                throw new IllegalStateException("No links are found for this subpage: " + subPage);
        }
    }

}

