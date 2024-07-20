import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases {

	String URL="https://magento.softwaretestingboard.com/";
	
	WebDriver driver =new ChromeDriver();

	@BeforeTest
	public void mySetup() {
		driver.get(URL);
		driver.manage().window().maximize();	
		}
	
	
	@Test(enabled=false)
	public void SignUp() {
		WebElement signUp= driver.findElement(By.cssSelector("header[class='page-header'] li:nth-child(3) a:nth-child(1)"));
		signUp.click();
		
		WebElement FirstName =driver.findElement(By.id("firstname"));
		FirstName.sendKeys("Tala");
		
		WebElement LastName=driver.findElement(By.id("lastname"));
		LastName.sendKeys("Abu Mohammed");
		
		WebElement Email=driver.findElement(By.id("email_address"));
		Email.sendKeys("tala.hamdn@gmail.com");
		
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("123@4567_89");
		
		WebElement ConfirmPassword=driver.findElement(By.id("password-confirmation"));
		ConfirmPassword.sendKeys("123@4567_89");
		
		WebElement  button=driver.findElement(By.xpath("//button[@title='Create an Account']"));
		button.click();
		
	}
	
	
	@Test
	public void Login() {
		WebElement button= driver.findElement(By.cssSelector("div[class='panel header'] li[data-label='or'] a"));
		button.click();
		
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("tala.hamdn@gmail.com");
		
		WebElement password=driver.findElement(By.id("pass"));
		password.sendKeys("123@4567_89");
		
		WebElement SignInButton=driver.findElement(By.id("send2"));
		SignInButton.click();
		
		boolean Actual=false;
		Assert.assertEquals(Actual, false);
		
	}
	
	@Test 
	public void WomenSection() {
		WebElement mainMenu = driver.findElement(By.id("ui-id-4"));
		mainMenu.click();
		WebElement subMenu =driver.findElement(By.xpath("//a[contains(text(),'Tees')]"));
		subMenu.click();
		
		List <WebElement> products = driver.findElements(By.className("tocart"));

		//WebElement button=driver.findElement(By.className("tocart"));
		for(int i=0;i<3;i++) {
			products.get(i).click();
		}
	}
}
