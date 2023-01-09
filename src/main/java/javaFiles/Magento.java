package javaFiles;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Magento {
	
	Paths path = new Paths();
	Elements element = new Elements();
	String elementNeeded ;
	public WebDriver driver ;

	
	public void startDriver () throws IOException  {
		driver = element.intializeDriver() ;
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}


	public void OpenURL (String path ) {
		driver.get(path);
	}

	// make sure the landing page title is correct
	public void assert_label (String LocatorName , String Actual_label) throws IOException {
		//get element by xpath in excel sheet
		elementNeeded = element.GetElement(LocatorName);
		WebElement ElementNeeded= driver.findElement(By.xpath(elementNeeded));
	
		//compare texts (expected from previous class and actual from UI)		
		Assert.assertTrue(ElementNeeded.getText().contains(Actual_label));
	}
	
	
	// click on button
	public void Button(String LocatorName) throws IOException, InterruptedException {
		//get element by xpath in excel sheet
		elementNeeded = element.GetElement(LocatorName);
		WebElement ElementNeeded= driver.findElement(By.xpath(elementNeeded));
		ElementNeeded.click();
	}

	// add text 
	public void AddText(String LocatorName, String Text) throws IOException {
		//get element by xpath in excel sheet
		elementNeeded = element.GetElement(LocatorName);
		WebElement ElementNeeded= driver.findElement(By.xpath(elementNeeded));
		// write the wanted text
		ElementNeeded.sendKeys(Text);
	}	

	public String GetFromExcel (String Path, int size , String locator) throws IOException {
		String[] s1 = new String[size];
		String[] s2 = new String[size/2];
		String[] s3 = new String[size/2];

		String value = element.GetFromExcel(s1, s2, s3, Path, size, locator) ;
		return value ;
	}

	public void HoverByMouse(String LocatorName) throws IOException {
		
		elementNeeded = element.GetElement(LocatorName);

		Actions action = new Actions(driver);
		WebElement hover = driver.findElement(By.xpath(elementNeeded));
		action.moveToElement(hover).perform();
		action.moveToElement(hover).click().build().perform();
	
	}
	
	public void CheckProductList (String LocatorName) throws IOException {
		elementNeeded = element.GetElement(LocatorName);
		List<WebElement> ElementNeededs  ;
		ElementNeededs =	driver.findElements(By.xpath(elementNeeded));
		Assert.assertFalse(ElementNeededs.isEmpty(), "No Product available");
		
	}
	
	public void Close() {
		driver.quit();
	}
}
