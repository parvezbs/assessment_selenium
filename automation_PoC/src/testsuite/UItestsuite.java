package testsuite;


import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Operations.BusinessOps;
import Operations.PageOps;

public class UItestsuite {


    /**
     * @author parvezbs End to End Automation of DSS UI portal
     **/


    //public class UItestMain {

        PageOps pops;
        BusinessOps bops = new BusinessOps();
        WebDriver driver;
        String brwsr;
        WebElement elem;
        WebDriverWait wait;

@BeforeTest
        public void setup() throws InterruptedException {
            pops = new PageOps();
            brwsr = pops.getBrowser();
            if (brwsr.equalsIgnoreCase("chrome")) {
                pops.setupChrome();
            }
            openBrowser();
        }

//Open or launch browser with chrome driver
public void openBrowser() throws InterruptedException {
    Reporter.log("In Openbrowser");
    String brwsr="chrome";
    if (brwsr.equalsIgnoreCase("chrome")) {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
		driver.get(pops.getwebsite());
        System.out.println("Browser launch successful for test execution.");
    	}
	}

@Test(priority=1)
/*
 * This test case is to launch browser and validate the target website is being loaded and accessible
 * */
		public void TC1_Launch_Emirates_Travel_Website() throws InterruptedException {
			try {
				bops.validateUIElement(driver, pops, pops.landingPageImageXpath());
				Reporter.log("Validation of Emirates homepage is successful");
				} 
			catch (NoSuchElementException e) {
				Reporter.log("Unable to locate the Emirates logo, hence validation of the landing page is failed");
				e.printStackTrace();
				}
	}

@Test(priority=1)
/*
 * This test case to check available flights
 * */
		public void TC2_Check_Available_Tickets() throws InterruptedException{
			try{
				bops.validateNClickUiElement(driver, pops, pops.departureDropdownXpath());
				bops.validateClickSendKeys(driver, pops, pops.departureDropdownXpath(), pops.getSource());
				bops.validateNClickUiElement(driver, pops, pops.arrivalDropdownXpath());
				bops.validateClickSendKeys(driver, pops, pops.arrivalDropdownXpath(), pops.getDestination());
				Reporter.log("Able to locate the Departure and Arrival dropdowns");
			}
			catch(NoSuchElementException e){
				Reporter.log("Unable to locate the Arrival anr/or Destination dropdowns");
			}
			try{
				bops.validateNClickUiElement(driver, pops, pops.onewayCheckBoxXpath());
				Reporter.log("clicked one way check box to make sure we are travelling one way on a specific date");
				bops.validateNClickUiElement(driver, pops, pops.dateToTravelXpath());
				Reporter.log("Date has been selected successful 18/12/2018. This value can be changed in the proprties file");
				if(driver.findElement(By.xpath(pops.continueButtonXpath())).isDisplayed()){
					bops.validateNClickUiElement(driver, pops, pops.continueButtonXpath());
					Reporter.log("Clicked continue button to move to search..");}
				else{
				bops.validateNClickUiElement(driver, pops, pops.SearchFlightsbuttonXpath());
				Reporter.log("Clicked search button");}
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				Reporter.log("We can implment fluent wait for better handling search results but for now, I have kept explicit wait of 20 sec");
				bops.validateUIElement(driver, pops, pops.searchResultsPageXpath());
				Reporter.log("Search results page has been displayed");
				bops.validateUIElement(driver, pops, pops.lowestPriceLableXpath());
				WebElement TxtBoxContent = driver.findElement(By.xpath("//span[@class='abper-82-price']"));
				System.out.println("Printing " + TxtBoxContent.getAttribute("value"));
			}	
			catch(NoSuchElementException e){
				Reporter.log("Unable to progress to search results page");
			}
			
			}

//@AfterSuite
//public void quitDriver() throws Exception {
//	driver.quit();
//}
    }

//}
