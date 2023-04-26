package Utils;

import Pages.BasePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class UseCaseBase {
    protected static WebDriver webDriver;
    protected static BasePage page;

    @BeforeAll
    public static void setupMain() {
        webDriver = SharedDriver.getWebDriver(SharedDriver.Browser.CHROME);
        page = new BasePage(webDriver);
    }


    @AfterAll
    public static void tearDownMain() {
        SharedDriver.closeDriver();
        webDriver = null;
    }
}
