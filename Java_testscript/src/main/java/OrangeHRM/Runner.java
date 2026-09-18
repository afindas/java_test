package OrangeHRM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.OrangeHRMDashboard;
import pages.OrangeHRMLoginPage;

public class Runner {

	public static void main(String[] args) {
		WebDriver driver = null;

		try {

			
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

			

			OrangeHRMLoginPage.Login(driver);
			iceaccessibility.Analyse();
			
			OrangeHRMDashboard.dashboard("admin", driver);

			OrangeHRMDashboard.ClickonAdmin(driver);
			OrangeHRMDashboard.EditUserPage(driver);

			OrangeHRMLoginPage.Logout(driver);

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (driver != null) {
				driver.quit();
			}
		}
	}
}