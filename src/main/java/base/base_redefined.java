package base;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static listeners.ExtentBasic.ExtentReporterCls.ReportFolderName;


public class base_redefined {

    protected WebDriver driver;

    //@BeforeClass
    public WebDriver SetupDriver() {

              WebDriverManager.chromedriver().setup();
              driver = new ChromeDriver();
              return driver;
    }

    public String getscreenshot(String TestCaseName,WebDriver driver) throws IOException {
        Date d = new Date();
        SimpleDateFormat SDF = new SimpleDateFormat("HH_mm_ss");
        String random = SDF.format(d);
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String Image = System.getProperty("user.dir")+"/HtmlReports/Extent/"+ ReportFolderName+"/"+TestCaseName+random+".png";
       System.out.println("Screenshot path:" +Image);
        File file = new File(Image);
        FileUtils.copyFile(source,file);

        //Returing the Absolute path of Image as string
        return Image;

    }


    @AfterTest
    public void TearDown()
    {
        driver.quit();
    }
}
