package Standard_User;

import static org.testng.Assert.fail;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ArrayClass {
	WebDriver driver = new ChromeDriver();
	Random rand = new Random();
	String myWebSite = "https://www.saucedemo.com/";
	String userName = "standard_user";
	String passwordInput = "secret_sauce";

	@BeforeTest
	public void MySetup() {
		driver.get(myWebSite);
		driver.manage().window().maximize();
		// driver.manage().window().minimize();
		// driver.manage().window().fullScreen();
	}

	@Test(priority = 1)
	public void Login() {
		// طريقة اخرى ل login
		WebElement UserNameInputField = driver.findElement(By.id("user-name"));
		WebElement PassWordInputField = driver.findElement(By.id("password"));
		WebElement LoginButton = driver.findElement(By.id("login-button"));

		UserNameInputField.sendKeys(userName);
		PassWordInputField.sendKeys(passwordInput);
		LoginButton.click();
	}

	@Test(priority = 2, enabled = false)
	public void AddAllItems() {
		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
		
		for(int i =0 ; i<AddToCartButtons .size() ; i++) {
			AddToCartButtons.get(i).click();

		}
			
		}

	// to add items in Left side only

	@Test(enabled = false)
		public void AddtemsInLeftSide() {
			List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
			
			for(int i =0 ; i<AddToCartButtons .size() ; i=i+2) {
				AddToCartButtons.get(i).click();

			}
	}


	// to add items in right side only

	@Test(enabled = false)
			public void AddtemsInRightSide() {
				List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
				
				for(int i =1 ; i<AddToCartButtons .size() ; i=i+2) {
					AddToCartButtons.get(i).click();

				}
		}

	// اضافة عدد معين من العناصر , توقف عملية test
	@Test()
	public void AddCertainNumberOfItems() {
		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));

		for (int i = 0; i < AddToCartButtons.size(); i++) {
			if (i == 2) {
				break;
			}
			AddToCartButtons.get(i).click();

		}

	}

	// اضافة كل العناصر ما عدا عنصر معين

	@Test()
	public void ExcludeItem() {
		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));

		for (int i = 0; i < AddToCartButtons.size(); i++) {
			if (i == 2) {
				continue;
			}
			AddToCartButtons.get(i).click();

		}

	}

	// اضافة كل العناصر ما عدا اكتر من عنصر باستخدام رمز OR (||)
	@Test(enabled = false)
	public void ExcludeItemsUsingOR() {
		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));

		for (int i = 0; i < AddToCartButtons.size(); i++) {
			if (i == 2 || i == 0) {
				continue;
			}
			AddToCartButtons.get(i).click();

		}

	}

	// اضافة عناصر تبدأ بكلمة معينة
	@Test(enabled = false)
				public void AddItemsThatStartsWithSauce() {
					List<WebElement> ItemNames = driver.findElements(By.className("inventory_item_name "));
					List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
					
					for(int i =0 ; i<ItemNames .size() ; i++) {
						if(ItemNames.get(i).getText().startsWith("Sauce")) {
							continue;
						}
						AddToCartButtons.get(i).click();

					}
	}
						
				//test لاضافة عناصر عشوائة 
	@Test()
	public void AddRandomitem() {
		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
		int randomIndex = rand.nextInt(AddToCartButtons.size());
		System.out.println(randomIndex);
		AddToCartButtons.get(randomIndex).click();

		// another way to add an element randomly
		// double randomIndex = Math.floor(Math.random()*AddToCartButtons.size());
		// System.out.println(Math.random()*AddToCartButtons.size());
		// System.out.println(Math.floor(6.6));
		// System.out.println(Math.ceil(88.5));

	}

	@Test()
	public void CheckoutProcess() {
		WebElement ShoppingCart = driver.findElement(By.className("shopping_cart_link"));
		ShoppingCart.click();
		WebElement Checkoutbutton = driver.findElement(By.id("checkout"));
		Checkoutbutton.click();

		// Array of first name
		String[] firstNames = { "ahmad", "sara", "anas", "rama" };
		int RandomFirstName = rand.nextInt(firstNames.length);

		// Array of Last name
		String[] lastNames = { "ahmad", "karam", "anas", "sami" };
		int RandomLastName = rand.nextInt(lastNames.length);

		// Array of postal code
		String[] postalCodes = { "12345", "34527", "85974", "98048" };
		int RandomPostalCode = rand.nextInt(postalCodes.length);

		WebElement FirstNameInput = driver.findElement(By.id("first-name"));
		WebElement LastNameInput = driver.findElement(By.id("last-name"));
		WebElement PostCodeInput = driver.findElement(By.id("postal-code"));

		FirstNameInput.sendKeys(firstNames[RandomFirstName]);
		LastNameInput.sendKeys(lastNames[RandomLastName]);
		PostCodeInput.sendKeys(postalCodes[RandomPostalCode]);
		
		WebElement ContinueButton =driver .findElement(By.id("continue"));
		ContinueButton.click();
		
		WebElement FinishButton =driver.findElement(By.id("finish"));
		FinishButton.click();

	}

}


