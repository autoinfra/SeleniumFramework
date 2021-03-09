package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import listeners.LoggingUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import rp.com.google.common.io.Files;
import rp.com.google.common.io.Resources;

public class base {
	public static WebDriver driver;
	public Properties prop;
	private static final Logger LOGGER =LogManager.getLogger(base.class);
	public WebDriver initializeDriver() throws IOException
	{
		System.out.println("User dir is: "+System.getProperty("user.dir"));
		System.out.println("User OS is: "+System.getProperty("os.name"));
		  prop = new Properties(); FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/data.properties");
		  prop.load(fis);

		 String OS = System.getProperty("os.name");
/*		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("123"))));*/
  String browser = prop.getProperty("browser");
	if(browser.equals("remote-chrome"))
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
		dc.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		String Testname= prop.getProperty("testname");
		dc.setCapability("name", Testname);
	   
		driver = new RemoteWebDriver(new URL("http://DVCIL2634502:4444/wd/hub"),dc);
		System.out.println("remote chrome");
	}
	
	else if(browser.equals("selenoid-chrome"))
	{
		System.out.println("slenoind chrome");
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setVersion("79.0");
		dc.setCapability("enableVNC", true);
		dc.setCapability("enableVideo", true);
		dc.setAcceptInsecureCerts(true);
		dc.setCapability(CapabilityType.PROXY, "YOUR_PROXY");


		driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(),dc);
	}
	
	/*executes in Zalenium Firefox*/
	else if(browser.equals("remote-firefox"))
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
		dc.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
	   
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),dc);
		
	}
	/*executes in Local Machine chrome*/
	else if(browser.equals("chrome"))
	{
		if(OS.equals("Linux"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/drivers/linux/chromedriver");
//			DesiredCapabilities dc = new DesiredCapabilities();
//			dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
//			dc.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
//			driver = new RemoteWebDriver(new URL("http://selenium__standalone-chrome:4444/wd/hub/"),dc);
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");
			chromeOptions.addArguments("--no-sandbox");
			driver = new ChromeDriver(chromeOptions);

		}
		else {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		//System.out.println("chrome");
		
	}

	/*executes in local machine firefox*/
	else if (browser.equals("FIREFOX_STANDALONE"))
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/resources/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		
	}
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	return driver;
	
	}

	
	public void getscreenshot(String result) throws IOException,NullPointerException
	{
		//System.out.println("Base Result name: "+result);

		try {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"//src//main//resources//files//test_screenshots//"+result+"screenshot.png"));
		//LOGGER.info("screenshot generated");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        File file = File.createTempFile("ctac-test", ".png");
        Resources.asByteSource(Resources.getResource("test_screenshots/"+result+"screenshot.png")).copyTo(Files.asByteSink(file));
        LoggingUtils.log(file, "Attached Failed Test Screenshot");
		}
		catch (Exception e)
		{
		LOGGER.info(e);
		}
		
	}
	
}
 