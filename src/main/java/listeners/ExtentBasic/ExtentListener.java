package listeners.ExtentBasic;


import base.base_redefined;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.RestAssured;
import listeners.MicrosoftTeams.Builder;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import rp.com.google.common.io.BaseEncoding;
import rp.com.google.common.io.Resources;

import java.io.IOException;

public class ExtentListener extends base_redefined implements ITestListener, ISuiteListener {
    ITestContext ITC;
    ExtentReports extent = ExtentReporterCls.ReportGenerator("AutoInfraHTMLReport");
    ExtentTest test;
    ExtentTest node;

    //creating thread for 'test' object for parallel execution
   private static final ThreadLocal<ExtentTest> LocalThread = new ThreadLocal<ExtentTest>();

   public void logInfo(String message)
   {
        LocalThread.get().info(message);
   }

    public void logJsoninfo(String json)
    {
        LocalThread.get().info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
    }


    @Override
    public void onTestStart(ITestResult result) {
        node = test.createNode(result.getMethod().getMethodName());
        LocalThread.set(node);

    }

    @SneakyThrows
    @Override
    public void onTestSuccess(ITestResult result) {
        LocalThread.get().log(Status.PASS,"------------TEST CASE PASSED------------");
        WebDriver driver = null;
        Object TestObject = result.getInstance();
        Class CurrentClass = result.getTestClass().getRealClass();
        driver = (WebDriver)CurrentClass.getDeclaredField("driver").get(TestObject);
        LocalThread.get().addScreenCaptureFromPath(getscreenshot(ITC.getName(),driver),ITC.getName());



    }

    @SneakyThrows
    @Override
    public void onTestFailure(ITestResult result) {

        LocalThread.get().fail(result.getThrowable());
        WebDriver driver = null;
        Object TestObject = result.getInstance();
        Class clasname = result.getTestClass().getRealClass();
              driver = (WebDriver)clasname.getDeclaredField("driver").get(TestObject);
              LocalThread.get().addScreenCaptureFromPath(getscreenshot(ITC.getName(),driver),ITC.getName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
       LocalThread.get().skip(result.getThrowable());

    }

    @SneakyThrows
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
       /* System.out.println("TEST MESSAGE");
        LocalThread.get().fail(result.getThrowable());*/
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
       test= extent.createTest(context.getName());
       this.ITC=context;
    }

    @Override
    public void onFinish(ITestContext context) {
extent.flush();
    }
}

//C program to check grade of 5 different students

