package com.cucumber.automation.bdt.stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.By;

import com.cucumber.automation.utils.DriverFactory;
import com.cucumber.automation.web.pages.LoginPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class adda52MobileWebSteps {
	
	DriverFactory df = new DriverFactory();
	LoginPage lp = new LoginPage();

	
	@Given("^user is on adda52 login Page$")
	public void user_is_on_adda52_login_Page()  {
		lp.verifyLoginPage();
	}

	@When("^user clicks on REGISTER NOW$")
	public void user_clicks_onREGISTER_NOW()  {
		lp.clickRegisterNow();
	}

	@Then("^user is presented the signup form$")
	public void user_is_presented_the_signup_form()  {
		lp.verifySignupPage();
	}

	@When("^user enters following details$")
	public void user_enters_following_details(DataTable userData)  {
		lp.register(userData);
	}
	
	@When("^user is displayed confirmation message$")
	public void confirm()  {
		lp.verifyConfirm();
	}
	
	@Given("^system cuts image from screenshot$")
	public void system_cuts_image_from_screenshot() throws IOException  {
		df.cutRequiredImage();
	}
	
	@Given("^system compares the snapshot with expected image$")
	public void system_compares_the_snapshot_with_expected_image() throws IOException, InterruptedException {
		df.compareImages();
	}
	
	
	@Then("^user resizes the window to (\\d+) x (\\d+)$")
	public void user_resizes_the_window_to_x(int arg1, int arg2) throws InterruptedException  {
		df.resizeWebDriver(arg1, arg2, By.cssSelector("div[data-role='navmenu_banner'] > a[data-role='navmenu_bannerbutton']"));
	}
	
	@Then("^system takes snapshot of homepage$")
	public void system_takes_snapshot_of_homepage() throws IOException  {
	    df.takeScreenshot();
	}
	
	@Then("^following error is displayed \"(.*?)\"$")
	public void user_verifies_the_information_displayed_on_page(String message)  {
	    lp.getText(message);
	}
	
	@When("^user enters follwoing details for login$")
	public void user_enters_follwoing_details_for_login(DataTable arg1) {
		lp.login(arg1);
	}

	@Then("^user is diaplyed home page$")
	public void user_is_diaplyed_home_page() {
		lp.verifyhomePage();
	}

	@When("^user selects to list all Freeroll RING Games$")
	public void user_selects_to_list_all_Freeroll_RING_Games()  {
		lp.freeroll();

	}

	@Then("^user is displayed Freeroll RING Games Details$")
	public void user_is_displayed_all_Freeroll_RING_Games()  {
		lp.tableList();
	}

	@When("^user selects a game to play$")
	public void user_selects_game_to_play() {
		lp.enterGame();
	}

	@Then("^user is displayed Game Dashboard$")
	public void user_is_displayed_Game_Dashboard() {
		lp.verifyGameBoard();
	}
	
	@Then("^user is also displayed all seats info$")
	public void seatinfo() {
		//lp.seatinfo();
		lp.takeSeat("seat_1");
	}
}