package testBase;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjects.EnterInsurantDataPageObjects;
import pageObjects.EnterProductDataPageObjects;
import pageObjects.EnterVehicleDataPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.SelectPriceOptionPageObjects;
import reusableComponents.CommonMethods;

public class ObjectRepo {
	public static WebDriver driver;
	public static ExtentReports extent; 
	public static ExtentTest test;
	public static HomePageObjects homePage;
	public static EnterVehicleDataPageObjects vehData;
	public static EnterInsurantDataPageObjects insData;
	public static EnterProductDataPageObjects prodData;
	public static SelectPriceOptionPageObjects priceOptions;
	
	public CommonMethods cm = new CommonMethods();
}
