package listeners;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.base;

public class TestNGlisteners implements ITestListener  {
	base b = new base();
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		//hey i am done
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		//

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//screenshot
		try {
//System.out.println("Print Result name: "+result.getName());

			b.getscreenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

		try {
			//System.out.println("Print Result name: "+result.getName());

						b.getscreenshot(result.getName());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	
	}

}
