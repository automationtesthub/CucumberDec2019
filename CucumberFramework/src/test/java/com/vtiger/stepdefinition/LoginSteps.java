package com.vtiger.stepdefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	public WebDriver driver;
	
	@Given("^user should on login page$")
	public void user_should_on_login_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "E:/Selenium/Selenium_Software/chromedriver.exe");	
		driver = new ChromeDriver();	
		driver.get("http://localhost:100");
		driver.manage().window().maximize();
	}

	@When("^user enters valid userid and password$")
	public void user_enters_valid_userid_and_password(DataTable data) throws Throwable {
		List<List<String>> lst = data.raw();
		driver.findElement(By.name("user_name")).sendKeys(lst.get(0).get(0));
		driver.findElement(By.name("user_password")).sendKeys(lst.get(0).get(1));	
	}

	@And("^clicks on login button$")
	public void clicks_on_login_button() throws Throwable {
		driver.findElement(By.name("Login")).click();
	}

	@Then("^user should be landing on home page$")
	public void user_should_be_landing_on_home_page() throws Throwable {
	    
	}

	@Then("^verify logout link$")
	public void verify_logout_link() throws Throwable {
	    driver.findElement(By.linkText("Logout")).click();
	}

	@When("^user enters invalid userid is \"([^\"]*)\" and password is \"([^\"]*)\"$")
	public void user_enters_invalid_userid_is_and_password_is(String arg1, String arg2) throws Throwable {
		driver.findElement(By.name("user_name")).sendKeys(arg1);
		driver.findElement(By.name("user_password")).sendKeys(arg2);	
	}

	@Then("^user should be get error message on login page$")
	public void user_should_be_get_error_message_on_login_page() throws Throwable {
      boolean val = driver.findElement(By.xpath("//*[contains(text(),'You must specify a valid username and password.')]")).isDisplayed();
      System.out.println(val);
	}

}
