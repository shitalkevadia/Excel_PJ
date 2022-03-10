package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	WebDriver driver;
	
	ExcelReader excelRead = new ExcelReader("testData\\techfios_TestData.xlsx");
	String userName = excelRead.getCellData("loginInfo", "UserName", 2);
	String password = excelRead.getCellData("loginInfo", "Password", 2);

	
	@Test
	public void validUserShoulBeAbleToLogin() {
		driver = BrowserFactory.init();
		
		//LoginPage loginPage1 = new LoginPage(driver);
		
		LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
		loginPage.insertuserName("userName");
		loginPage.insertPassword("password");
		loginPage.clickSignin();
		
		DashBoardPage dashboardPage = PageFactory.initElements(driver, DashBoardPage.class);
		dashboardPage.varifyDashbardHeader();
		BrowserFactory.tearDown();
	}

}
