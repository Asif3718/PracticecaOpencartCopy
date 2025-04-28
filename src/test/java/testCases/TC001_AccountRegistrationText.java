package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;


public class TC001_AccountRegistrationText extends BaseClass {
	
	
	@Test(groups={"Regression", "Master"})
	void verify_account_registration()
	{
		try {
		//logger.info("***** Starting TC001_AccountRegistrationTest *****");
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		//logger.info("***** Clicked on MyAccount Link *****");
		
		hp.clickRegister();
		//logger.info("***** Clicked on Register Link *****");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		//logger.info("***** Providing Customer Details *****");
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumber());
		
		String pass=randomAlphaNumberic();
		regpage.setPassword(pass);
		regpage.setConfirmPassword(pass);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		//logger.info("***** Validating expected message *****");
		String confmsg=regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			//logger.error("Test Failed..");
			//logger.debug("Debug logs...");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
	catch(Exception e)
	{		
		Assert.fail();
	}
		
		//logger.info("***** Finished TC001_AccountRegistrationTest *****");
	}
	

}
