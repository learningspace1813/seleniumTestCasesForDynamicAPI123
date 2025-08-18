package profTravel;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class utils {
	WebDriver driver;
	
	public utils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void moveSlider(By sliderLocator, By minimumSlider, By maximumSlider, int sliderMin, int sliderMax, int targetMin, int targetMax) {
		WebElement slider = driver.findElement(sliderLocator);
		WebElement minSlider = driver.findElement(minimumSlider);
		WebElement maxSlider = driver.findElement(maximumSlider);
		
		int sliderWidth = slider.getSize().width;
		
		//int xOffset = (target-min) * sliderWidth / (max-min);
	    // Calculate offset for min handle
	    int xOffsetMin = (targetMin - sliderMin) * sliderWidth / (sliderMax - sliderMin);
	    // Calculate offset for max handle
	    int xOffsetMax = (sliderMax - sliderMin) * sliderWidth / (sliderMax - sliderMin);
	    
		Actions action = new Actions(driver);
		
//		action.clickAndHold(slider).moveByOffset(xOffset, 0).release().perform();
//		action.clickAndHold(minSlider).moveByOffset(3000, 0).release().perform();
//		action.clickAndHold(maxSlider).moveByOffset(7000, 0).release().perform();
		//new Actions(driver).clickAndHold(minSlider).moveByOffset(xOffset, 0).release().perform();
	    action.clickAndHold(maxSlider).moveByOffset(xOffsetMin, 0).release().perform();
		action.clickAndHold(maxSlider).moveByOffset(xOffsetMax - xOffsetMin, 0).release().perform();
		//System.out.println("Move slider to:" + target);				
	}
	
	public boolean isInRange(int value, int min, int max) {
		return value >=min && value <= max;
	}

}
