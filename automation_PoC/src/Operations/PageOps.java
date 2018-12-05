package Operations;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

/**
 * @author s.parvezbasha@gmail.com for PoC automation
 */

public class PageOps {

	FileReader reader;
	Properties prop;
	static String projectLocation = System.getProperty("user.dir");
	static String driverPath = projectLocation+"\\resources\\";
	
	public PageOps() {
		// Reads the properties file and makes it ready for usage
		try {
			reader = new FileReader(projectLocation+"\\resources\\ui.properties");
			prop = new Properties();
			prop.load(reader);
			}
		catch (FileNotFoundException e1) {
			Reporter.log("ui.Properties File Not Found");
			e1.printStackTrace();
			}
		catch (IOException e) {
			Reporter.log("Error while loading Property file");
			e.printStackTrace();
		}
	}
	//setup Chrome Browser for automation
	public void setupChrome() {
		Reporter.log("*************************************");
		Reporter.log("launching chrome browser............");
        System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
        System.out.print(driverPath);
        Reporter.log("in SetupChrome");
	}
	

	
	// Highlighting Element during Execution
	public void HighlightElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		try 
		{ 
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
			Thread.sleep(1000);
			js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);
			Reporter.log("Element highlight "+element+" is success!");
		} 
		catch (InterruptedException e) {
			Reporter.log(e.getMessage());
		} 
	}
	
	public String getBrowser() {
		return prop.getProperty("browser");
	}
	public String getSource(){
		return prop.getProperty("source");
	}
	public String getDestination(){
		return prop.getProperty("destination");
	}
	public String getwebsite(){
		return prop.getProperty("targetWebsite");
	}
	public String landingPageImageXpath(){
		return prop.getProperty("landingPage");
	}
	public String departureDropdownXpath(){
		return prop.getProperty("departureDropdown");
	}
	public String arrivalDropdownXpath(){
		return prop.getProperty("arrivalDropdown");
	}
	public String continueButtonXpath(){
		return prop.getProperty("continueButton");
	}
	public String onewayCheckBoxXpath(){
		return prop.getProperty("onewayCheckBox");
	}
	public String dateToTravelXpath(){
		return prop.getProperty("dateToTravel");
	}
	public String SearchFlightsbuttonXpath(){
		return prop.getProperty("SearchFlightsbutton");
	}
	public String searchResultsPageXpath(){
		return prop.getProperty("searchResultsPage");
	}
	public String lowestPriceLableXpath(){
		return prop.getProperty("lowestPriceLable");
	}
	
	
}
