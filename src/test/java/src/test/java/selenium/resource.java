package src.test.java.selenium;

public class resource {
	//OrangeHRM Admin section
	//public static final String verticalMnu = "(//button[contains(@class,'oxd-icon-button')])[1]";
	//public static final String admin = "(//ul//li[@class='oxd-main-menu-item-wrapper'])[1]]";
	//public static final String admin = "(//ul//li[@class='oxd-main-menu-item-wrapper'])[1]";
	public static final String admin = "//span[text()='Admin']/ancestor::a";
	public static final String userMngmntDD = "(//li[contains(@class,'oxd-topbar-body-nav-tab')])[1]";
	public static final String UMoptionDD = "//a[text()='Users']";
	public static final String moreMenu = "//span[text()='More ']";
	public static final String moreMNconfig = "//li//a[text()='Configuration ']";
	public static final String mreConfigDD = "//a[text()='Configuration '//li";
	public static final String mreConfigOptionDD = "//a[text()='Configuration ']/ancestor::li//ul/li";
}
