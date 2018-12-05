package Operations;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import Operations.PageOps;

public class BusinessOps {
		
	WebElement elem;
		//Reusable method to validate the landing page
		public void validateUIElement(WebDriver driver, PageOps pops, String uiElement ) throws InterruptedException{
			try {
				elem = driver.findElement(By.xpath(uiElement));
				pops.HighlightElement(driver, elem);
				Assert.assertTrue(elem.isDisplayed());
				}
			catch (NoSuchElementException e) {
				Reporter.log("Unable to access the page or failed to locate element "+pops.landingPageImageXpath()+" ");
				org.testng.Assert.fail("Unable to access UI element.");
			}
		}
		
		// Reusable method To validate webEliment and click
		public void validateNClickUiElement(WebDriver driver, PageOps pops, String uiElement) throws InterruptedException{
				Reporter.log("Validating Web Element with property "+uiElement);
				elem = driver.findElement(By.xpath(uiElement));
			try{
				pops.HighlightElement(driver, elem);
				elem.click();
				Thread.sleep(1000);
				}
			catch (Exception e) {
				Reporter.log("Unable to validate"+uiElement+"UI element");
				driver.switchTo().defaultContent();
				org.testng.Assert.fail("uiElement is not identified or not clickable.");
				}
			}

		// Reusable method To validate webEliment, click and send keys
		public void validateClickSendKeys(WebDriver driver, PageOps pops, String uiElement, String keys) throws InterruptedException{
				Reporter.log("Validating Web Element with property "+uiElement);
				elem = driver.findElement(By.xpath(uiElement));
			try{
				//elem.click();
				elem.sendKeys(keys);
				elem.sendKeys(Keys.TAB);
				pops.HighlightElement(driver, elem);
				Thread.sleep(1000);
				}
			catch (Exception e) {
				Reporter.log("Unable to click/send keys "+uiElement+" UI element");
				driver.switchTo().defaultContent();
				org.testng.Assert.fail("uiElement is not identified or not clickable or not able to send keys.");
				}
			}
		
	}