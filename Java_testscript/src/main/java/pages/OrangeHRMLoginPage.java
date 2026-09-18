package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;





public class OrangeHRMLoginPage {

	static By OrangeHRM_usernameField = By.xpath("(//div[@class='orangehrm-login-form']//input)[2]");
	static By OrangeHRM_passwordField = By.xpath("(//div[@class='orangehrm-login-form']//input)[3]");
	static By OrangeHRM_Login = By.xpath("//*[@type='submit']");
	static By OrangeHRM_HeaderUserAreaDd = By.xpath("(//div[@class='oxd-topbar-header-userarea']//li)[1]");
	static By OrangeHRM_ClickonLogOutButton = By.xpath("(//div[@class='oxd-topbar-header-userarea']//li)[5]");
//	static WebDriver driver = Repository.driver;

	public static void Login(WebDriver driver) throws InterruptedException {
		 
		Thread.sleep(2000);
		driver.findElement(OrangeHRM_usernameField).sendKeys("Admin");
		Thread.sleep(2000);
		driver.findElement(OrangeHRM_passwordField).sendKeys("admin123");
		Thread.sleep(2000);
		driver.findElement(OrangeHRM_Login).click();
 
	}

	public static void Logout(WebDriver driver) throws Exception {

//		String CurrentMethod = ReportExtract.getCurrentMethodName();
//		System.out.println("Method name: " + CurrentMethod);
//		GenericMethod.getModuleName(CurrentMethod);

		Actions action = new Actions(driver);

		try {
			Thread.sleep(3000);
			driver.findElement(OrangeHRM_HeaderUserAreaDd).click();
			Thread.sleep(3000);
			driver.findElement(OrangeHRM_ClickonLogOutButton).click();
			Thread.sleep(3000);
//			ReportExtract.UpdateTestCaseModuleStatus("Pass", CurrentMethod);
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
//			ReportExtract.UpdateTestCaseModuleStatus("Fail", CurrentMethod);
		}

	}

}
