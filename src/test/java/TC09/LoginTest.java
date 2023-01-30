package TC09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

	@Test
	public void AddCustomer() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@type]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='#']//p[contains(text(),'Customers')]")).click();
		driver.findElement(By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")).click();
		driver.findElement(By.xpath("//a[@href=\"/Admin/Customer/Create\"]")).click();
		driver.findElement(By.cssSelector("#Email")).sendKeys("charishmalokesh@gmail.com");
		driver.findElement(By.cssSelector("#Password")).sendKeys("Charishma");
		driver.findElement(By.cssSelector("#FirstName")).sendKeys("Charishma");
		driver.findElement(By.cssSelector("#LastName")).sendKeys("Lokesh");
		driver.findElement(By.cssSelector("#Gender_Female")).click();
		driver.findElement(By.xpath("//input[@name=\"DateOfBirth\"]")).sendKeys("3/9/1997");
		driver.findElement(By.xpath("//button[@name=\"save\"]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']"))
				.getText().contains("added successfully"));
		driver.close();
	}
}
