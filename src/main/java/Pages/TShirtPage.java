package Pages;

import Base.BasePage;
import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class TShirtPage extends BasePage {
    public static final By H1_TITLE = By.xpath("//h1/span[1]");
    public static WebDriver driver;

    public TShirtPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public static String getH1Title(){
        return BaseTest.getDriver().findElement(H1_TITLE).getText();
    }
}
