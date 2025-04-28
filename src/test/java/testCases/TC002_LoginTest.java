package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	@Test(groups={"Sanity", "Master"})
	public void verify_login()
	{
		logger.info("***** Starting TC002 LoginTest *****");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		Thread.sleep(2000);
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("pass"));
		lp.clickLogin();
		
		MyAccountPage map=new MyAccountPage(driver);
		boolean targetPage=map.isMyAccountExist();
		//Assert.assertEquals(targetPage, true,"login failed");
		Assert.assertTrue(targetPage);
		}
		catch(Exception e)
		{
			Assert.fail();
			System.out.println(e.getMessage());
		}
		
		logger.info("***** Finish TC002 LoginTest *****");
		
		
		
		
		
		
	}

}
