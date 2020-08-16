package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReporterCls {
    static ExtentReports extent;

    public static ExtentReports ReportGenerator()
    {
        Date d = new Date();
        SimpleDateFormat SDF = new SimpleDateFormat("MMMM-dd-yyyy");
        String ReportFolderName = SDF.format(d);
        String path = System.getProperty("user.dir")+"\\HtmlReports\\Extent\\"+ReportFolderName+"\\"+System.getProperty("user.name")+"TestReport.html";
        ExtentSparkReporter ESR = new ExtentSparkReporter(path);
        ESR.config().setReportName("Automation Results");
        ESR.config().setDocumentTitle("Test Results");
        extent = new ExtentReports();
        extent.attachReporter(ESR);
        extent.setSystemInfo("Tester",System.getProperty("user.name"));
        extent.setSystemInfo("OS",System.getProperty("user.os"));
        return extent;

    }
}
