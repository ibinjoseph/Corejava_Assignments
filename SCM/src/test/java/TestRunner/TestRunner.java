package TestRunner;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestRunner {

	public static WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {
		System.setProperty("webdriver.chrome.driver", "src\\resources\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://jira.gfs.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}

}
