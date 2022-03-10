package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {
	WebDriver driver;

	// Login Data
	ExcelReader excelRead = new ExcelReader("testData\\techfios_TestData.xlsx");
	String userName = excelRead.getCellData("loginInfo", "UserName", 2);
	String password = excelRead.getCellData("loginInfo", "Password", 2);
	String fullName = excelRead.getCellData("AddContactInfo", "FullName", 2);
    String companyName = excelRead.getCellData("AddContactInfo", "CompanyName", 0);
    String email = excelRead.getCellData("AddContactInfo", "Email", 0);
    String phone = excelRead.getCellData("AddContactInfo", "Phone", 0);
    String address = excelRead.getCellData("AddContactInfo", "Address", 0);
    String city = excelRead.getCellData("AddContactInfo", "City", 0);
    String state = excelRead.getCellData("AddContactInfo", "State", 0);
    String zip = excelRead.getCellData("AddContactInfo", "Zip", 0);
    String country = excelRead.getCellData("AddContactInfo", "Country", 0);
	
	
	@Test
	public void validUserShouldBeAbleToCreateCustomer() throws InterruptedException {

		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertuserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSignin();
		
		DashBoardPage dashboardPage = PageFactory.initElements(driver, DashBoardPage.class);
		dashboardPage.varifyDashbardHeader();
		dashboardPage.clickCustomerButton();
		dashboardPage.clickAddCustomerButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.verifyAddContactPage();
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.insertCompany(companyName);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhone(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
		addCustomerPage.insertCountry(country);
		addCustomerPage.clickSubmitButton();
		dashboardPage.clickListCustomerButton();
		
		
	}

}

	