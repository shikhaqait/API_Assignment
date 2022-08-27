package test;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import httpclient.RestLogs;

public class BaseTest {
	
	protected SoftAssert softassert; 

	@BeforeSuite
	public void globalSetting() throws FileNotFoundException {
		RestLogs.setLog();
	}
	
	@BeforeClass
	public void startTestSet() {
		Reporter.log("****Test set started "+this.getClass().getSimpleName());
	}
	
	@BeforeMethod
	public void startTest(Method method) {
		softassert = new SoftAssert();
		Reporter.log("***Test started "+method.getName(),true);
	}
	
	@AfterMethod
	public void endTest(Method method) {
		Reporter.log("****Test ended "+method.getName(),true);
	}
	
	@AfterClass
	public void EndTestSet() {
		Reporter.log("****Test set ended "+this.getClass().getSimpleName());
	}

}
