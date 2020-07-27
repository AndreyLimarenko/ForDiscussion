package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static final Logger LOG = LoggerFactory.getLogger(BasePage.class);
    private static WebDriver driver;
        private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();


    @BeforeTest
    public void setUpDriver() {
        LOG.info("Starting WebDriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
            DRIVER.set(driver);
    }


    @AfterTest
    public void CloseDriver() {
//        LOG.info("Closing WebDriver");
//        driver.quit();
    }

    public static WebDriver getDriver() {
        return DRIVER.get();
    }
}

