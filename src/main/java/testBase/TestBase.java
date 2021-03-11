package testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.EnterInsurantDataPageObjects;
import pageObjects.EnterProductDataPageObjects;
import pageObjects.EnterVehicleDataPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.SelectPriceOptionPageObjects;
import reusableComponents.PropertiesOperations;

public class TestBase extends ObjectRepo{
	
	public void LaunchBrowserAndNavigate() throws Exception {
		//read prop file and get browser and url
		String browser = PropertiesOperations.getPropertyValueByKey("browser");
		String url = PropertiesOperations.getPropertyValueByKey("url");
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		} else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		} else if(browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			 driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get(url);
	}
	
	@BeforeMethod
	public void setUpMethod() throws Exception {
		LaunchBrowserAndNavigate();
		homePage = new HomePageObjects();
		vehData  = new EnterVehicleDataPageObjects();
		insData  = new EnterInsurantDataPageObjects();
		prodData = new EnterProductDataPageObjects();
		priceOptions = new SelectPriceOptionPageObjects();
	}
	
	@AfterMethod
	public void cleanUp() {
		driver.quit();
	}


}
