package orderMultipleAmznProducts;

import orderMultipleAmznProducts.STP_01_variablesAmznProducts;
import orderMultipleAmznProducts.STP_02_baseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_02_orderMtplAmznProducts extends STP_02_baseTest {

//	@Test(priority=1, description = "Homepage Verification.")
	
	@Test(priority=1, description = "Searching my product.")
	public void searchProduct() {
		WebElement addProduct = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		addProduct.sendKeys("3D Illusion Iron Man534" + Keys.ENTER);
	}
	

}
