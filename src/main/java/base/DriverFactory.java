package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class DriverFactory {
    private static final Map<String, Supplier<WebDriver>> driverMap = new HashMap<>();

    private static final Supplier<WebDriver> chromeDriverSupplier = () -> {

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        WebDriverManager.chromedriver().setup();
        WebDriver ChromeDriver = new ChromeDriver(options);
        ChromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ChromeDriver.manage().window().setSize(new Dimension(1200, 800));
        return ChromeDriver;
    };

    private static final Supplier<WebDriver> chromeDriverHeadless = () -> {

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.setExperimentalOption("prefs", prefs);
        WebDriverManager.chromedriver().setup();
        WebDriver ChromeDriver = new ChromeDriver(options);
        ChromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ChromeDriver.manage().window().setSize(new Dimension(1200, 800));
        return ChromeDriver;
    };

    private static final Supplier<WebDriver> firefoxDriverSupplier = () -> {
        WebDriver FirefoxDriver = new FirefoxDriver();
        FirefoxDriver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
        FirefoxDriver.manage().window().setSize(new Dimension(1200,800));
        return FirefoxDriver;
    };

    static{
        driverMap.put("CHROME", chromeDriverSupplier);
        driverMap.put("FIREFOX", firefoxDriverSupplier);
        driverMap.put("CHROME_HEADLESS",chromeDriverHeadless);
    }

    public static final WebDriver getDriver(String type){
        return driverMap.get(type).get();
    }


    public static final WebDriverWait getExplicitWat(WebDriver driver){return new WebDriverWait(driver,30);}

}
