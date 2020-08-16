package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


public class base_redefined {

    protected WebDriver driver;
    @BeforeTest
    public void SetupDriver(ITestContext ITC) throws IOException {
        Properties ListenerProp = new Properties();
        final String OS = System.getProperty("os.name");
        /*FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/Listeners.properties");
        ListenerProp.load(fis);
        Properties ReportPortalProp = new Properties();
        FileInputStream RPfis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/reportportal.properties");
        ReportPortalProp.load(RPfis);
        ReportPortalProp.put("rp.attributes","OS:"+OS);
        ReportPortalProp.setProperty("rp.attributes","OS:"+OS);
        String ProxyIP= ListenerProp.getProperty("PROXY_IP");*/
        System.out.println("User dir is: "+System.getProperty("user.dir"));
        System.out.println("User OS is: "+OS);
        String TestName = ITC.getName();
        String HUB_URL;
        DesiredCapabilities dc = new DesiredCapabilities();
//        Proxy proxy =new Proxy();
//        proxy.setHttpProxy("10.19.50.20:8080");
//        proxy.setSslProxy("10.19.50.20:8080");
        dc.setCapability(CapabilityType.PROXY,"genproxy.amdocs.com:8080");
        dc.setCapability("enableVNC", true);
        dc.setCapability("enableVideo", false);
        dc.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
        dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
        //System.setProperty("webdriver.chrome.silentOutput","true");
        if (System.getProperty("HOST_HUB")!=null)
      {
           HUB_URL = "http://"+System.getProperty("HOST_HUB")+":4444/wd/hub";
      }
      else
      {
          HUB_URL ="http://localhost:4444/wd/hub";
      }
        //System.out.println("HUB URL IS: "+HUB_URL);
      switch (System.getProperty("GRID_TYPE")) {

          case "ZALENIUM":
          case "SELENIUM":

      if (System.getProperty("BROWSER").equalsIgnoreCase("CHROME"))
      {
          dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
          dc.setCapability("name",TestName);
          this.driver = new RemoteWebDriver(URI.create(HUB_URL).toURL(),dc);
          break;
      }
      if (System.getProperty("BROWSER").equalsIgnoreCase("FIREFOX"))
      {
      dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
      dc.setCapability("name",TestName);
      this.driver = new RemoteWebDriver(URI.create(HUB_URL).toURL(),dc);
      break;
      }
      break;
      case "SELENOID":

      if (System.getProperty("BROWSER").equalsIgnoreCase("CHROME"))
      {
       dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
       dc.setCapability(CapabilityType.BROWSER_VERSION, "79.0");
       this.driver = new RemoteWebDriver(URI.create(HUB_URL).toURL(),dc);
       break;
      }
      if (System.getProperty("BROWSER").equalsIgnoreCase("FIREFOX"))
      {
      dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
      dc.setCapability(CapabilityType.BROWSER_VERSION, "74.0");
      this.driver = new RemoteWebDriver(URI.create(HUB_URL).toURL(),dc);
      break;
      }
              if (System.getProperty("BROWSER").equalsIgnoreCase("OPERA"))
              {
                  dc.setCapability(CapabilityType.BROWSER_NAME,"Opera");
                  dc.setCapability(CapabilityType.BROWSER_VERSION, "67.0");
                  this.driver = new RemoteWebDriver(URI.create(HUB_URL).toURL(),dc);
              break;
              }
              break;
          case "NO_GRID":
          //case System.getProperty("GRID_TYPE").is:
                  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");
                  this.driver = new ChromeDriver();
                  break;
          default:System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/geckodriver.exe");
              this.driver = new FirefoxDriver();
              break;
      }


    }
    public String getscreenshotpath(String TestCaseName, WebDriver driver) throws IOException {
        Date d = new Date();
        SimpleDateFormat SDF = new SimpleDateFormat("MMMM-dd-yyyy");
        String ReportFolderName = SDF.format(d);
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir")+"\\HtmlReports\\Extent\\"+ReportFolderName+"\\"+TestCaseName+".png";
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
