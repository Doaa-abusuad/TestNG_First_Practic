package testngFirstPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestngFirstPractice {

	public WebDriver driver1;
	public WebDriver driver2;
	public WebDriver driver3;

	@BeforeTest
	public void login() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
//		WebDriverManager.firefoxdriver().setup();
//		WebDriverManager.edgedriver().setup();
		
		driver1 = new ChromeDriver();
//		driver2 = new FirefoxDriver();
//	driver3 = new EdgeDriver();
		
		driver1.get("https://github.com/");
		
		driver1.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div/div/div[2]/a")).click();
		Thread.sleep(3000);
		driver1.findElement(By.cssSelector("#login_field")).sendKeys("doaa.abusuad@hotmail.com");
		driver1.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("DoaaAhmad99320422737");
		driver1.findElement(By.xpath("//*[@id=\"login\"]/div[4]/form/div/input[11]")).click();
	}
	
@Test()
	
	public void test_Title() {
		String actualTitle = driver1.getTitle();
		String expectedTitle = "GitHub";
		Assert.assertEquals(actualTitle, expectedTitle);
 }
	
	
	
	
	
}
