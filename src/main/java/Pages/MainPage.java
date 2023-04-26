package Pages;

import Consts.MainPageConsts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{
    private static final By LOGO_IMG = By.xpath(MainPageConsts.LOGO_IMG);
    private static final By CONTACT_US_OPTION = By.xpath(MainPageConsts.CONTACT_US_OPTION);

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void navigateToMainPage(){
        webDriver.get(MainPageConsts.MAIN_URL);
    }

    public boolean isLogoVisible(){
        return elementExists(LOGO_IMG);
    }

    public ContactUsPage openContactUsTab(){
        clickElement(CONTACT_US_OPTION);
        return new ContactUsPage(webDriver);
    }
}
