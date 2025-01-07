package Standard_User;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainTestCases {
	WebDriver driver = new ChromeDriver();
	
	String myWebSite = "https://www.saucedemo.com/";
	String userName = "standard_user";
	String passwordInput = "secret_sauce";
		
	
	@BeforeTest
	public void MySetup() {
		driver.get(myWebSite);
		driver.manage().window().maximize();
		//driver.manage().window().minimize();
		//driver.manage().window().fullScreen();
	}
	
	@Test(priority = 1)
	public void Login() {
		driver.findElement(By.id("user-name")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(passwordInput);
		driver.findElement(By.id("login-button")).click();
	}

	@Test(priority = 2)
	public void AddToCartItem() throws InterruptedException {
		Thread.sleep(2000);
		//driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		//driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
	//wrong code
	//driver.findElements(By.className("btn")).get(0).click();
	//driver.findElements(By.className("btn")).get(1).click();
	//driver.findElements(By.className("btn")).get(2).click();
	//driver.findElements(By.className("btn")).get(3).click();
	//driver.findElements(By.className("btn")).get(4).click();
	//driver.findElements(By.className("btn")).get(5).click();
	
		//correct code
		List<WebElement> AddToCardButtons = driver.findElements(By.className("btn"));
		
		for(int i=0;i<AddToCardButtons.size();i++) {
			AddToCardButtons.get(i).click();
		}
		

	}
	
	@Test(priority = 3 , enabled = false)
	public void RemoveItemFromThecart() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("remove-sauce-labs-backpack")).click();
	}
	
	@AfterTest
	public void PostTesting() { 
		
	}

}
