package base;


import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.ExtentBasic.ExtentReporterCls;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Properties;


public class base_redefined {

    protected WebDriver driver;

    //@BeforeClass
    public WebDriver SetupDriver() {

              WebDriverManager.chromedriver().setup();
              driver = new ChromeDriver();
              return driver;
    }

    public String getscreenshot(String TestCaseName,WebDriver driver) throws IOException {
/*        Date d = new Date();
        SimpleDateFormat SDF = new SimpleDateFormat("MMMM-dd-yyyy");
        String ReportFolderName = SDF.format(d);*/
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir")+"/HtmlReports/Extent/"+ ExtentReporterCls.ReportFolderName +TestCaseName+".png";
        System.out.println("Screenshot path:" +destination);
        File file = new File(destination);
        FileUtils.copyFile(source,file);
        return destination;

    }


    @AfterTest
    public void TearDown()
    {
        driver.quit();
    }
}
