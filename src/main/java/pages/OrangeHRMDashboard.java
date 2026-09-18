package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class OrangeHRMDashboard {

	static By OrangeHRM_Admin = By
			.xpath("//div[@class='oxd-sidepanel-body']//li[1]//a[@href='/web/index.php/admin/viewAdminModule']");
	static By OrangeHRM_AdminGrid_UserDetailsEditButton = By
			.xpath("(//div[@class='oxd-table-body']//div[@class='oxd-table-card'])[1]//button[2]");
	static By OrangeHRM_AdminGrid_EditUserStatusDropDown = By.xpath("(//div[@class='oxd-select-text--after'])[2]");
	static By OrangeHRM_AdminGrid_StatusDisableOption = By.xpath("(//div[@role='listbox'])//div[3]");
	static By OrangeHRM_AdminGrid_StatusEnableOption = By.xpath("(//div[@role='listbox'])//div[2]");
	static By OrangeHRM_AdminGrid_EditUserSaveButton = By.xpath("(//div[@class='oxd-form-actions']//button)[2]");
	static By OrangeHRM_TimeSheet = By
			.xpath("(//li[@class='oxd-main-menu-item-wrapper'])[4]//a[@href='/web/index.php/time/viewTimeModule']");
	static By OrangeHRM_EmployeeNameinTimeSheet = By.xpath("//div[@class='oxd-autocomplete-wrapper']//input");
	static By OrangeHRM_TimeSheetViewButton = By.xpath("//div[@class='oxd-form-actions']//button");
	static By OrangeHRM_TimesheetSubmitButton = By.xpath("//div[@class='orangehrm-timesheet-footer']//button[2]");
	static By OrangeHRM_CreateTimeSheetButton = By.xpath("//div[@class='orangehrm-timesheet-footer']//button");

	static By OrangeHRM_TimeSheetEditButton = By.xpath("//div[@class='orangehrm-timesheet-footer']//button[1]");

	static By OrangeHRM_EnterProjectDetails = By.xpath("//div[@class='oxd-autocomplete-wrapper']//input");
	static By OrangeHRM_ActivityDropDownArrow = By.xpath("(//div[@class='oxd-select-text--after'])[1]");
	static By OrangeHRM_TimesheetSaveButton = By.xpath("//div[@class='orangehrm-timesheet-footer']//button[3]");

	static By OrangeHRM_TimeSheetSubmittedStatus = By.xpath("(//p[text()='Status: Submitted']/following::button)[1]");
	//static WebDriver driver = Repository.driver;

	public static void dashboard(String Value,WebDriver driver) throws Exception {

//		String CurrentMethod = ReportExtract.getCurrentMethodName();
//		System.out.println("Method name: " + CurrentMethod);
//		GenericMethod.getModuleName(CurrentMethod);

		try {
			if (Value.equalsIgnoreCase("admin")) {
				Thread.sleep(3000);

				driver.findElement(OrangeHRM_Admin).click();
			} else if (Value.equalsIgnoreCase("timesheet")) {
				Thread.sleep(3000);
				driver.findElement(OrangeHRM_TimeSheet).click();
			}
//			ReportExtract.UpdateTestCaseModuleStatus("Pass", CurrentMethod);
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
//			ReportExtract.UpdateTestCaseModuleStatus("Fail", CurrentMethod);
		}

	}

	public static void ClickonAdmin(WebDriver driver) throws Exception {
//		String CurrentMethod = ReportExtract.getCurrentMethodName();
//		System.out.println("Method name: " + CurrentMethod);
//		GenericMethod.getModuleName(CurrentMethod);
		try {

			Thread.sleep(3000);
			scrollby(20, 450,driver);
			Thread.sleep(3000);

			driver.findElement(OrangeHRM_AdminGrid_UserDetailsEditButton).click();
			Thread.sleep(3000);

			//ReportExtract.UpdateTestCaseModuleStatus("Pass", CurrentMethod);
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			//ReportExtract.UpdateTestCaseModuleStatus("Fail", CurrentMethod);
		}

	}

	public static void EditUserPage(WebDriver driver) throws Exception {
//		String CurrentMethod = ReportExtract.getCurrentMethodName();
//		System.out.println("Method name: " + CurrentMethod);
//		GenericMethod.getModuleName(CurrentMethod);
		try {
			driver.findElement(OrangeHRM_AdminGrid_EditUserStatusDropDown).click();
			Thread.sleep(3000);
			driver.findElement(OrangeHRM_AdminGrid_StatusDisableOption).click();
			Thread.sleep(3000);
			driver.findElement(OrangeHRM_AdminGrid_EditUserStatusDropDown).click();
			Thread.sleep(3000);
			driver.findElement(OrangeHRM_AdminGrid_StatusEnableOption).click();
			Thread.sleep(3000);
			driver.findElement(OrangeHRM_AdminGrid_EditUserSaveButton).click();
			Thread.sleep(3000);

			//ReportExtract.UpdateTestCaseModuleStatus("Pass", CurrentMethod);
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			//ReportExtract.UpdateTestCaseModuleStatus("Fail", CurrentMethod);

		}

	}

	public static void ClickonTimeSheet(WebDriver driver) throws Exception {
//		String CurrentMethod = ReportExtract.getCurrentMethodName();
//		System.out.println("Method name: " + CurrentMethod);
//		GenericMethod.getModuleName(CurrentMethod);
		Actions action = new Actions(driver);
		try {

			Thread.sleep(3000);
			driver.findElement(OrangeHRM_EmployeeNameinTimeSheet).click();
			Thread.sleep(3000);
			driver.findElement(OrangeHRM_EmployeeNameinTimeSheet).sendKeys("O");
			Thread.sleep(3000);

			for (int i = 0; i < 2; i++) {

				action.sendKeys(Keys.DOWN);
				action.build().perform();
				Thread.sleep(3000);
			}
			Thread.sleep(3000);
			action.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(3000);
			driver.findElement(OrangeHRM_TimeSheetViewButton).click();
			Thread.sleep(3000);
			try {
				Thread.sleep(5000);
				WebElement g = driver.findElement(OrangeHRM_TimeSheetSubmittedStatus);
				String s = g.getText();
				System.out.println(s);
				// OrangeHRMLoginPage.Logout();
				Thread.sleep(2000);
			} catch (Exception e) {
				// System.out.println(e.getMessage().toString());

			}
			try {
				Thread.sleep(5000);
				WebElement g = driver.findElement(OrangeHRM_TimesheetSubmitButton);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", g);
				Thread.sleep(5000);
				// OrangeHRMLoginPage.Logout();
				Thread.sleep(5000);
			}

			catch (Exception e) {

				try {
					WebElement CreateTimeSheetButton = driver.findElement(OrangeHRM_CreateTimeSheetButton);
					Thread.sleep(5000);
					javascriptexecutor(CreateTimeSheetButton, "javascriptExecutorClick",driver);

				} catch (Exception e1) {
					WebElement CreateTimeSheetButton1 = driver.findElement(OrangeHRM_TimeSheetEditButton);
					Thread.sleep(5000);
					javascriptexecutor(CreateTimeSheetButton1, "javascriptExecutorClick",driver);
				}

				driver.findElement(OrangeHRM_TimeSheetEditButton).click();
				Thread.sleep(5000);
				driver.findElement(OrangeHRM_EnterProjectDetails).click();
				Thread.sleep(5000);
				driver.findElement(OrangeHRM_EnterProjectDetails).sendKeys("a");
				Thread.sleep(5000);
				for (int i = 0; i < 2; i++) {

					action.sendKeys(Keys.DOWN);
					action.build().perform();
					Thread.sleep(3000);
				}
				Thread.sleep(3000);
				action.sendKeys(Keys.ENTER).build().perform();
				driver.findElement(OrangeHRM_ActivityDropDownArrow).click();
				Thread.sleep(3000);
				for (int i = 0; i < 2; i++) {

					action.sendKeys(Keys.DOWN);
					action.build().perform();
					Thread.sleep(3000);
				}
				Thread.sleep(3000);
				action.sendKeys(Keys.ENTER).build().perform();
				Thread.sleep(3000);
				for (int i = 0; i < 2; i++) {
					WebElement hours = driver.findElement(By.xpath(
							"(//div[@class='oxd-input-group oxd-input-field-bottom-space'])[" + (i + 3) + "]//input"));
					hours.sendKeys("8");
					Thread.sleep(6000);
				}
				driver.findElement(OrangeHRM_TimesheetSaveButton).click();
				Thread.sleep(3000);

			}

			//ReportExtract.UpdateTestCaseModuleStatus("Pass", CurrentMethod);
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			//ReportExtract.UpdateTestCaseModuleStatus("Fail", CurrentMethod);
		}
	}
	
	public static void javascriptexecutor(WebElement element, String type, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		if (type.equalsIgnoreCase("scrollintoview")) {
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		}

		else if (type.equalsIgnoreCase("javascriptExecutorClick")) {
			js.executeScript("arguments[0].click();", element);
		}

	}
	
	public static void scrollby(int Xaxis, int Yaxis,WebDriver driver) {
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("window.scrollBy(" + Xaxis + "," + Yaxis + ")", "");
		// js.executeScript("arguments[0].scrollIntoView(true);", ViewCartButton);
	}

}
