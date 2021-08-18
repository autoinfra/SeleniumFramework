package listeners.ExtentBasic;


import base.base_redefined;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.RestAssured;
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

              String errormsg = result.getThrowable().toString();
        String methodName= result.getMethod().getMethodName();
        String methodDescription= result.getMethod().getDescription();
        RestAssured.baseURI="https://bhargavkumar65gmail.webhook.office.com/webhookb2/df93b3ce-071f-4e0c-932c-8f148084a9b0@0486e5b4-f3e8-4386-9ab4-cf2657814955/IncomingWebhook/4af0a1b63137487ab9f30625ceb98379/51337ede-bd85-472e-8bf2-4d8ae127399c";
        RestAssured.given().log().all()
                .body("{\n" +
                        "    \"@type\": \"MessageCard\",\n" +
                        "    \"@context\": \"http://schema.org/extensions\",\n" +
                        "    \"themeColor\": \"0076D7\",\n" +
                        "    \"summary\": \"Selenium Test Results\",\n" +
                        "\n" +
                        "    \"sections\": [\n" +
                        "        {\n" +
                        "            \"activityTitle\": \"Selenium Test Results\",\n" +
                        "            \"activitySubtitle\": \"Daily Sanity\",\n" +
                        "            \"activityImage\": \"https://camo.githubusercontent.com/4b95df4d6ca7a01afc25d27159804dc5a7d0df41d8131aaf50c9f84847dfda21/68747470733a2f2f73656c656e69756d2e6465762f696d616765732f73656c656e69756d5f6c6f676f5f7371756172655f677265656e2e706e67\",\n" +
                        "            \"facts\": [\n" +
                        "                {\n" +
                        "                    \"name\": \"Method Name\",\n" +
                        "                   \"value\":\""+ methodName +"\",\n" +
                        "                },\n" +
                        "                {\n" +
                        "                    \"name\": \"Method Description\",\n" +
                        "                   \"value\":\""+ methodDescription +"\",\n" +
                        "                },\n" +
                        "                {\n" +
                        "                    \"name\": \"Error\",\n" +
                        "                    \"value\":\""+ errormsg +"\",\n" +
                        "                }\n" +
                        "            ],\n" +
                        "            \"markdown\": true\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"potentialAction\": [\n" +
                        "\n" +
                        "\n" +
                        "        {\n" +
                        "        \"@type\": \"OpenUri\",\n" +
                        "        \"name\": \" See Test Results\",\n" +
                        "        \"targets\": [{\n" +
                        "            \"os\": \"default\",\n" +
                        "          \"uri\": \"http://localhost:63342/AutoInfra/HtmlReports/Extent/2021-Jul-31_13_59/AutoInfraHTMLReportReport.html?_ijt=kt96k51po71l11qs4s3clkob5p&_ij_reload\"\n" +
                        "        }]\n" +
                        "    }\n" +
                        "          \n" +
                        "        \n" +
                        "    ]\n" +
                        "}")
                .when().post()
                .then().log().all().statusCode(200);

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
