package utilities.Jira;

import org.testng.*;

public class IssueStatusListener implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

 /*       Issue issue = method.getTestMethod()
                .getConstructorOrMethod()
                .getMethod()
                .getAnnotation(Issue.class);


        if (null != issue) {
            if (IssueStatus.READY_TO_TEST.equals(IssueTracker.getStatus(issue.value()))) {
                try {
                    throw new SkipException("Skipping this due to Open Defect - " + issue.value());
                }
                catch (Exception e)
                {
                    System.out.println(e);
                    testResult.setStatus(ITestResult.SKIP);
                }
            }

        }
*/
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        IInvokedMethodListener.super.afterInvocation(method, testResult);

        Issue issue = method.getTestMethod()
                .getConstructorOrMethod()
                .getMethod()
                .getAnnotation(Issue.class);

        if (null != issue) {
            if(IssueStatus.READY_TO_TEST.equals(IssueTracker.getStatus(issue.value()))){
                switch(testResult.getStatus()){
                    case ITestResult.FAILURE:
                        // no need to fail as we might have expected this already.
                        testResult.setStatus(ITestResult.SKIP);
                        break;
                    case ITestResult.SUCCESS:
                        // It is a good news. We should close this issue.
                        IssueTracker.AddScreenshot(issue.value(),"example2.png");
                        break;
                }
            }
        }
    }


    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        IInvokedMethodListener.super.beforeInvocation(method, testResult, context);
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        IInvokedMethodListener.super.afterInvocation(method, testResult, context);
    }
}