package testngFirstPractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTML {

	public WebDriver driver;
	
	@BeforeTest()
	public void login() {
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
	    driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
	    driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
	    driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	}
	
	//groups = "sorting"
	@Test(priority = 1)
	public void sort_items_low_to_high(){
		driver.manage().timeouts().getImplicitWaitTimeout();
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select")).click();
		
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]")).click();
		
		List <WebElement> thePriceList = driver.findElements(By.className("inventory_item_price"));
		List <Double> newEditedList = new ArrayList<>();
		
		for(int i = 0; i < thePriceList.size() ; i++) {
			 String price = thePriceList.get(i).getText();
			 System.out.println(price);
			 String editedPrice = price.replace("$", " ");
			 System.out.println(editedPrice);
			 double value = Double.parseDouble(editedPrice.trim());
			 System.out.println(value);
			 newEditedList.add(value);
			 System.out.println(newEditedList);
			 
		}
		
		for(int k= 0; k < newEditedList.size(); k++) {
			boolean checkProcess = newEditedList.get(0) < newEditedList.get(newEditedList.size()-1);
			Assert.assertEquals(checkProcess, true);
		}
		
		
		//** list types**//
		// 1-Array list
		// 2-Static list
		// 3-Array list like dynamic
	}
	
	@Test(priority = 2)
	public void check_high_to_low() {
		System.out.println("we have done");
	}
	
	@Test(priority = 3)
	public void check_add_to_cart_process() {
		System.out.println("ad to cart");
	}
	
	
}
