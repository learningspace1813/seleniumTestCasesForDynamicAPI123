package orderMultipleAmznProducts;

import orderMultipleAmznProducts.STP_01_variablesAmznProducts;
import orderMultipleAmznProducts.STP_02_baseTest;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class TC_01_orderSingleProduct extends STP_02_baseTest{
	
//	@Test(priority=1, description="Homepage Verification.")

	
	@Test(priority=1, description="Searching baby night light.")
	public void browserProduct() throws InterruptedException {
		WebElement addProduct = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		addProduct.sendKeys("Iron Man 3D Night Light, XXMANX Baby Night Light with 7 Colors 16 Colors" + Keys.ENTER);		
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		Thread.sleep(10000);
	}
	
	@Test(priority=2, description = "ordering baby night light.")
	public void selectProduct() {
		WebElement slctProduct = driver.findElement(STP_01_variablesAmznProducts.productSelectionXpath);
		slctProduct.click();
	}
	
}