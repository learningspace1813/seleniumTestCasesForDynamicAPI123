package proffessional.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class app_code_page {
	protected final WebDriver driver;
	
	public app_code_page(WebDriver driver) {
		this.driver = driver;
	}
	
	public String homeScreenMsg() {
		return driver.findElement(By.xpath("")).getText().trim();
	}
}

