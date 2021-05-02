package listeners.PowerBI;

import com.google.inject.Injector;
import com.google.inject.Module;
import org.testng.*;
import org.testng.xml.XmlTest;

import java.util.*;

public class PowerBI_Listener implements ITestListener,ITestContext {

    private  PowerBI_ResultSender PowerBI_ResultSender;
    private String TSTNAME;
    private ITestContext ITC;
    @Override
    public void onTestStart(ITestResult result) {
        this.PowerBI_ResultSender = new PowerBI_ResultSender();

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        this.sendStatus(result,"PASS");
    }

    @Override
    public void onTestFailure(ITestResult result) { this.sendStatus(result,"FAIL");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        this.sendStatus(result,"SKIPPED");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        //SKIP
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {this.sendStatus(result,"Time Out");}

    @Override
    public void onStart(ITestContext context) {
        //SKIP
    }

    @Override
    public void onFinish(ITestContext context) {
        //SKIP
    }

    public void sendStatus(ITestResult ITR, String status){

        //String Suitename = ITR.getTestName();
        String Suitename = TSTNAME;
        String Classname = ITR.getTestClass().getName();
        String Methodname = ITR.getMethod().getMethodName();
        String MethodDescription = ITR.getMethod().getDescription();
        String Host = ITR.getHost();
        String Result = status;
        long Duration = ITR.getEndMillis() - ITR.getStartMillis();

        PowerBI_Pojo p = PowerBI_Pojo.builder()
                .Suitename(Suitename)
                .Classname(Classname)
                .Methodname(Methodname)
                .MethodDescription(MethodDescription)
                .Host(Host)
                .Result(Result)
                .Duration(Duration)
                .build();

        List<PowerBI_Pojo> List = new ArrayList<PowerBI_Pojo>();
        List.add(p);
        PowerBI_Pojo_Base PB = new PowerBI_Pojo_Base();
        PB.setRows(List);
        PowerBI_ResultSender.PushData(PB);
    }


    @Override
    public String getName() {
        this.TSTNAME = ITC.getName();
        return TSTNAME;
    }

    @Override
    public Date getStartDate() {
        return null;
    }

    @Override
    public Date getEndDate() {
        return null;
    }

    @Override
    public IResultMap getPassedTests() {
        return null;
    }

    @Override
    public IResultMap getSkippedTests() {
        return null;
    }

    @Override
    public IResultMap getFailedButWithinSuccessPercentageTests() {
        return null;
    }

    @Override
    public IResultMap getFailedTests() {
        return null;
    }

    @Override
    public String[] getIncludedGroups() {
        return new String[0];
    }

    @Override
    public String[] getExcludedGroups() {
        return new String[0];
    }

    @Override
    public String getOutputDirectory() {
        return null;
    }

    @Override
    public ISuite getSuite() {
        return null;
    }

    @Override
    public ITestNGMethod[] getAllTestMethods() {
        return new ITestNGMethod[0];
    }

    @Override
    public String getHost() {
        return null;
    }

    @Override
    public Collection<ITestNGMethod> getExcludedMethods() {
        return null;
    }

    @Override
    public IResultMap getPassedConfigurations() {
        return null;
    }

    @Override
    public IResultMap getSkippedConfigurations() {
        return null;
    }

    @Override
    public IResultMap getFailedConfigurations() {
        return null;
    }

    @Override
    public XmlTest getCurrentXmlTest() {
        return null;
    }

    @Override
    public List<Module> getGuiceModules(Class<? extends Module> cls) {
        return null;
    }

    @Override
    public Injector getInjector(List<Module> moduleInstances) {
        return null;
    }

    @Override
    public Injector getInjector(IClass iClass) {
        return null;
    }

    @Override
    public void addInjector(List<Module> moduleInstances, Injector injector) {

    }

    @Override
    public Object getAttribute(String name) {
        return null;
    }

    @Override
    public void setAttribute(String name, Object value) {

    }

    @Override
    public Set<String> getAttributeNames() {
        return null;
    }

    @Override
    public Object removeAttribute(String name) {
        return null;
    }
}
