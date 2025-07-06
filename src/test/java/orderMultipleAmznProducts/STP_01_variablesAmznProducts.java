package orderMultipleAmznProducts;

import org.openqa.selenium.By;

public class STP_01_variablesAmznProducts {
	//Home page verification
	public static final String url = "https://www.amazon.in/";
	public static final By homepageHeaderXpath = By.xpath("//a[@aria-label=\"Amazon.in\"]");
	public static final By NonShopingPageXpath = By.xpath("//h4['Click the button below to continue shopping']");
	
	//TC_01_orderSingleProduct
	public static final By continueShoppingXpath = By.xpath("//button[@type='submit']");
	public static final By productSelectionXpath = By.xpath("//h2[contains(@aria-label,'Iron Man 3D Night Light, XXMANX Baby Night Light with 7 Colors 16 Colors')]");
	
//Amazon function XPATHs :

	
	//Order PeacockFeather Wall Lamp
	public static final String PeacockFeatherWL = "Lamp master 3-in-1 LED Peacock Feather Wall Light | Creative Acrylic Decorative Wall Lamp";
	public static final By PeacockFeatherWLXpath = By.xpath("//.[contains(text(),'Lamp master 3-in-1 LED Peacock Feather Wall Light | Creative Acrylic Decorative Wall Lamp')]");
}