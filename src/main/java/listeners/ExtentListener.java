package listeners;

import base.base_redefined;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class ExtentListener extends base_redefined implements ITestListener {
    ExtentReports extent = ExtentReporterCls.ReportGenerator();
    ExtentTest test;
    ITestContext ITC;
    //creating thread for 'test' object for parallel execution
   private static final ThreadLocal<ExtentTest> LocalThread = new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        LocalThread.set(test);
        /*System.out.println("============================"+ITC.getName());
        System.out.println("ImHere"+result.getClass().getName());*/

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LocalThread.get().log(Status.PASS,"PASSED");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = null;
        Object TestObject = result.getInstance();
        Class clasname = result.getClass();
        try {
            driver = (WebDriver)clasname.getDeclaredField("driver").get(TestObject);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e1) {
            e1.printStackTrace();
        }
        LocalThread.get().fail(result.getThrowable());
        try {
            LocalThread.get().addScreenCaptureFromPath(getscreenshotpath(result.getMethod().getMethodName(),driver),result.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
extent.flush();
    }
}
