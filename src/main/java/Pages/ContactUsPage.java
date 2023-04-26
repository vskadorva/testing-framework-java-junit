package Pages;
import Consts.ContactUsPageConsts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends BasePage {
    public static final By CONTACT_US_HEADER = By.xpath(ContactUsPageConsts.CONTACT_US_HEADER);

    public ContactUsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isPageTitleVisible(){
        return elementExists(CONTACT_US_HEADER);
    }
}
