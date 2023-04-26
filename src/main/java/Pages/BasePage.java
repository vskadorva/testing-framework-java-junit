package Pages;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BasePage {
    private static final Logger logger = LogManager.getLogger(BasePage.class);

    protected static WebDriver webDriver;
    protected static WebDriverWait wait;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
    }

    protected void clickElement(By locator) {
        logger.info("Clicking element with locator: " + locator);
        findElement(locator).click();
    }

    protected void sendTextToElement(By locator, String text) {
        findElement(locator).sendKeys(text);
    }

    protected boolean elementExists(By locator) {
        try {
            logger.info("Check element with locator exists: " + locator);
            webDriver.findElement(locator);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    protected WebElement findElement(By locator) {
        WebElement element;
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        element = webDriver.findElement(locator);
        return element;
    }

    protected String getCurrentPageURL() {
        return webDriver.getCurrentUrl();
    }

    public void takeScreenshot(String name){
        TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("Screenshots/" + name + ".jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
