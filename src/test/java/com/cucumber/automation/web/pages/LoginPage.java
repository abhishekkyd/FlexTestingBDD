package com.cucumber.automation.web.pages;


import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.cucumber.automation.utils.DriverFactory;

import cucumber.api.DataTable;

public class LoginPage extends DriverFactory {
			
	public void verifyLoginPage() {
		waitVar.until(ExpectedConditions.presenceOfElementLocated(By.id("loginBt")));
		
	}
	
	@SuppressWarnings("deprecation")
	public void getText(String message)
	{
		waitVar.until(ExpectedConditions.textToBePresentInElement(By.className("infoPopup_Text"), message));
		assertTrue(driver.findElement(By.className("infoPopup_Text")).getText().equalsIgnoreCase(message));
	}
	
	public void clickRegisterNow(){
		waitVar.until(ExpectedConditions.presenceOfElementLocated(By.name("regButton")));
		driver.findElement(By.name("regButton")).click();
	}
	
	public void verifySignupPage(){
		waitVar.until(ExpectedConditions.presenceOfElementLocated(By.id("registerSignIn")));
	}
	
	public static void register(DataTable userData) {

		try {
			List<List<String>> userDatalist = userData.raw();
			
			waitVar.until(ExpectedConditions.presenceOfElementLocated(By.id("registerSignIn")));
			driver.findElement(By.id("registerUname")).sendKeys(userDatalist.get(0).get(1));
			driver.findElement(By.id("registerPassword")).sendKeys(userDatalist.get(1).get(1));
			driver.findElement(By.id("registerMail")).sendKeys(userDatalist.get(2).get(1));
			new Select(driver.findElement(By.id("gender")))
					.selectByVisibleText(userDatalist.get(3).get(1));
			driver.findElement(By.id("registerCheck")).click();
			driver.findElement(By.id("registerSignIn")).click();
			waitVar.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Ok']")));
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(e);
		}
		
	}
	
	public void verifyConfirm(){
		waitVar.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Ok']")));
		driver.findElement(By.xpath("//input[@value='Ok']")).click();
	}

	public void login(DataTable login) {

		try {
			List<List<String>> loginDetails = login.raw();
			
			driver.findElement(By.id("usernameIn")).sendKeys(loginDetails.get(0).get(1));
			driver.findElement(By.id("password")).sendKeys(loginDetails.get(1).get(1));
			driver.findElement(By.id("loginBt")).click();
			
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(e);
		}
		
	}

		public void verifyhomePage(){
			waitVar.until(ExpectedConditions.presenceOfElementLocated(By.id("logout_Button")));
			
		}
		
		
	public void freeroll() {

		try {
			waitVar.until(ExpectedConditions.elementToBeClickable(By.id("menuBtn")));
			driver.findElement(By.id("menuBtn")).click();
			Thread.sleep(2500);
			waitVar.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='FREEROLL']")));
			driver.findElement(By.xpath("//span[text()='FREEROLL']")).click();
			waitVar.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='RING']")));
			driver.findElement(By.xpath("//span[text()='RING']")).click();
			waitVar.until(ExpectedConditions.elementToBeClickable(By.id("logout_Button")));

		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(e);
		}
		
	}

	public void tableList() {

		try {
			
			waitVar.until(ExpectedConditions.presenceOfElementLocated(By.id("labbyTableList")));
			WebElement labbyTable = driver.findElement(By.id("labbyTableList"));
			List<WebElement> labbyTableHeaders=labbyTable.findElements(By.xpath("id('labbyTableList')/thead/tr"));
			List<WebElement> labbyTableRows=labbyTable.findElements(By.xpath("id('labbyTableList')/tbody/tr"));

			System.out.println("NUMBER OF HEADERS IN THIS TABLE = "+ labbyTableHeaders.size());
	        System.out.println("NUMBER OF ROWS IN THIS TABLE = "+ labbyTableRows.size());
	        System.out.println("================================================================");
	        for(WebElement thElement : labbyTableHeaders)
	        {
	            System.out.println(thElement.getText());
	        }
	        System.out.println("================================================================");
	        for(WebElement trElement : labbyTableRows)
	        {
	            System.out.println(trElement.getText());
		        System.out.println("-------------------------------------------------------");
		        
	        }
	        System.out.println("================================================================");

		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(e);
		}
		
	}

	public void enterGame() {

		try {
			//System.out.println("Name: " + driver.findElement(By.xpath("//tr[descendant::td/a[contains(text(),'"+tableName+"')]]//td[1]/a")).getText());
			//System.out.println("Blinds: " + driver.findElement(By.xpath("//tr[descendant::td/a[contains(text(),'"+tableName+"')]]//td[2]/a")).getText());
			//System.out.println("Buyin: " + driver.findElement(By.xpath("//tr[descendant::td/a[contains(text(),'"+tableName+"')]]//td[3]/a")).getText());
			//System.out.println("Users: " + driver.findElement(By.xpath("//tr[descendant::td/a[contains(text(),'"+tableName+"')]]//td[4]")).getText());
			waitVar.until(ExpectedConditions.elementToBeClickable(By.xpath("id('labbyTableList')/tbody/tr[5]/td[5]")));
			driver.findElement(By.xpath("id('labbyTableList')/tbody/tr[5]/td[5]/a")).click();

		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(e);
		}
		
	}

	public void verifyGameBoard(){
		waitVar.until(ExpectedConditions.presenceOfElementLocated(By.className("gamearea_Header_Nav")));
		waitVar.until(ExpectedConditions.presenceOfElementLocated(By.className("play_Section")));
	}
	
	public void seatinfo(){
		try{
			waitVar.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[starts-with(@id,'seat_')]/div/a")));
			List<WebElement> seats = driver.findElements(By.xpath("//div[contains(@id,'seat_')]/div/a"));
			for(WebElement seat: seats){
				
				System.out.println(seat.getText());
				if(seat.getText().equalsIgnoreCase("SIT HERE")){
					seat.click();
					waitVar.until(ExpectedConditions.elementToBeClickable(By.className("button done buyInFormOk")));
					driver.findElement(By.className("button done buyInFormOk")).click();
					driver.findElement(By.xpath("//*[text()='OK']")).click();
					break;
				}
			}
		}
		catch (Exception e){
			System.out.println("inside exception");
			/*waitVar.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[starts-with(@id,'seat_')]/div/a")));
			List<WebElement> seats = driver.findElements(By.xpath("//div[starts-with(@id,'seat_')]/div/a"));
			for(WebElement seat: seats){
				
				System.out.println(seat.getText());
				if(seat.getText().equalsIgnoreCase("SIT HERE")){
					seat.click();
					waitVar.until(ExpectedConditions.elementToBeClickable(By.className("button done buyInFormOk")));
					driver.findElement(By.className("button done buyInFormOk")).click();
					driver.findElement(By.xpath("//*[text()='OK']")).click();
				}
			}*/
		}
		
		
	}
	
	
	public void takeSeat(String seat) {

		try {
			Thread.sleep(2500);
			waitVar.until(ExpectedConditions.elementToBeClickable(By.id(seat)));
			System.out.println(driver.findElement(By.xpath("//*[@id="+ "'"+seat+"'"+"]/div/a")).getText());
			driver.findElement(By.xpath("//*[@id="+ "'"+seat+"'"+"]/div/a")).click();
			//driver.findElement(By.xpath("//*[@id="+ "'"+seat+"'"+"]/div/a")).click();
			waitVar.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h4[contains(text(),'Buy-in Form')]")));

			//driver.findElement(By.xpath("//input[contains(@class,'carryAmount')]")).sendKeys(carryAmt);
			driver.findElement(By.xpath("//input[contains(@class,'buyInFormOk')]")).click();
			driver.findElement(By.xpath("//input[contains(@class,'closeInfoBtn')]")).click();
			
			

		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(e);
		}
		
	}

	public void leaveRoom(){
		driver.findElement(By.className("homeMenuBtn")).click();
		waitVar.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='homeMenuItems insideMenu']/li[6]/a")));
		driver.findElement(By.xpath("//*[@class='homeMenuItems insideMenu']/li[6]/a")).click();
		waitVar.until(ExpectedConditions.elementToBeClickable(By.id("yes")));
		driver.findElement(By.id("yes")).click();
		waitVar.until(ExpectedConditions.elementToBeClickable(By.id("logout_Button")));
		driver.findElement(By.id("logout_Button")).click();
	}
	public void logout() {
		
		try {
			driver.findElement(By.id("loginBt")).click();
			/*(new WebDriverWait(driver, 60))
					.until(new ExpectedCondition<WebElement>() {
						@Override
						public WebElement apply(WebDriver d) {
							return d.findElement(By.id("logout_Button"));
						}
					});*/
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(e);
		}
	}
	
}



