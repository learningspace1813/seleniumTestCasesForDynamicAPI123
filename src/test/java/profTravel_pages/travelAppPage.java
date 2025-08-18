package profTravel_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class travelAppPage {
	protected WebDriver driver;
	
	public void travel_app_test(WebDriver driver) {
		this.driver = driver;
	}
	
	public String homepageTest() {
		return driver.findElement(By.xpath("(//h4//strong)[1]")).getText().trim();
	}
}
