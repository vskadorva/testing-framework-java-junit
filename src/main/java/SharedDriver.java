import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SharedDriver {
    private static WebDriver webdriver;

    public static WebDriver getWebdriver() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        if(webdriver == null){
            WebDriverManager.chromedriver().setup();
            webdriver = new ChromeDriver();
        }
        return webdriver;
    }

    public static void closeDriver() {
        if(webdriver!=null){
            webdriver.close();
        }
    }
}
