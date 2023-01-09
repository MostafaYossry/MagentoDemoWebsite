package javaFiles;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Elements {

// define used objects
	GetElementFromArray ElementFromArray = new GetElementFromArray();
	Paths path = new Paths();
	
// define driver type
	public WebDriver driver ;

// define array and array size that will contain elements from excel file (locators file)
	int ExcelLocatorElements = path.ExcelLocatorSize ;
	String[] s1 = new String[ExcelLocatorElements];
// define two arrays one for locator names the other for locators (xpaths)
	int ColExcelElements = ExcelLocatorElements/2 ;
	String[] s2 = new String[ColExcelElements];
	String[] s3 = new String[ColExcelElements];

		
// By locator name >> get xpath from excel file, then return this element to other classes
	public String GetElement(String LocatorName) throws IOException {

// get the value from excel file by the locator name
		String Xpathlocator = GetFromExcel(s1,s2,s3,path.ExcelFilePath, ExcelLocatorElements , LocatorName);
		return Xpathlocator ;
		}
	
// By locator name >> get xpath from excel file, then return this element to other classes
	public WebElement ConcatLocater(String Part_1 ,int index , String Part_2 ) throws IOException {

// elements based on index value returned from (get cheapest function)
// xpath differ because value of index
		Part_1 = GetFromExcel(s1,s2,s3,path.ExcelFilePath, ExcelLocatorElements , Part_1);
		Part_2 = GetFromExcel(s1,s2,s3,path.ExcelFilePath, ExcelLocatorElements , Part_2);
		String LocatorName = Part_1 + Integer.toString(index) + Part_2 ;
// get the element itself
		WebElement ElementNeeded= driver.findElement(By.xpath(LocatorName));
		return ElementNeeded ;
		
	}

// By locator name >> get xpath from excel file, then return these list of elements to other classes	
	public List<WebElement> GetElements(String LocatorName) throws IOException {
// get the value from excel file by the locator name
		String Xpathlocator = GetFromExcel(s1,s2,s3,path.ExcelFilePath, ExcelLocatorElements , LocatorName);
// get the list of elements
		List<WebElement> ElementsNeeded = driver.findElements(By.xpath(Xpathlocator));
		return ElementsNeeded ;
		
	}
	


// get from excel file function, divide excel file into two arrays (each col in separate array) then get index of type to get the other value from the second array
	public String GetFromExcel (String[] array , String[] array1, String[] array2, String FilePath, int FileSize, String LocatorName) throws IOException {
		array = ElementFromArray.Read_excel(FilePath , FileSize);
		for (int i=0; i<array1.length; i++) {
			array1[i] = array[2*i] ;
			array2[i] = array[(2*i)+1] ;
	     }  
		String temp = ElementFromArray.Get(array1, array2, LocatorName) ;
		return temp ;
	}

	public WebDriver intializeDriver ( )  {
	System.setProperty("webdriver.chrome.driver", path.Chrome_Driverpath );
	WebDriver driver = new ChromeDriver();
    return driver;
	}

	
}

