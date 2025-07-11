package testingDemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class demoQATesting{
	protected WebDriver driver;
	protected WebDriverWait wait;
	String url = "https://demoqa.com/";
	
	@Test
	public void textbox() {
		WebElement addProduct = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		addProduct.sendKeys("3D Illusion Iron Man534" + Keys.ENTER);
	}
}