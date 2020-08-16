package listeners;

import java.time.LocalDateTime;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ElasticListener implements ITestListener {

    //private Elastic_Json_TestStatus testStatus;
    private Elastic_Json_TestStatus Elastic_Json_TestStatus;

    @Override
    public void onTestStart(ITestResult iTestResult) {
        //this.testStatus = new TestStatus();
        this.Elastic_Json_TestStatus = new Elastic_Json_TestStatus();
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        this.sendStatus(iTestResult,"PASS");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        this.sendStatus(iTestResult,"FAIL");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        this.sendStatus(iTestResult,"SKIPPED");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        //skip
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        //skip
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        //skip
    }

    private void sendStatus(ITestResult iTestResult, String status){
        this.Elastic_Json_TestStatus.setTestClass(iTestResult.getTestClass().getName());
        this.Elastic_Json_TestStatus.setDescription(iTestResult.getMethod().getDescription());
        this.Elastic_Json_TestStatus.setStatus(status);
        this.Elastic_Json_TestStatus.setExecutionDate(LocalDateTime.now().toString());
        ElasticResultSender.send(this.Elastic_Json_TestStatus);
    }



}