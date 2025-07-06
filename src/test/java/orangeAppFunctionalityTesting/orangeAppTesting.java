	package orangeAppFunctionalityTesting;

	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.*;

	public class orangeAppTesting {

	    private WebDriver driver;
	    private WebDriverWait wait;

	    @BeforeClass
	    public void setUp() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	    @Test(priority = 1, description = "Login with valid credentials")
	    public void testLogin() {
	        WebElement usernameField = waitUntilVisible(By.name("username"));
	        usernameField.sendKeys("Admin");

	        WebElement passwordField = waitUntilVisible(By.name("password"));
	        passwordField.sendKeys("admin123");

	        WebElement loginButton = waitUntilClickable(By.xpath("//button[@type='submit']"));
	        loginButton.click();

	        // Validate dashboard is displayed (by checking for an element visible only after login)
	        WebElement dashboardHeader = waitUntilVisible(By.xpath("//h6[text()='Dashboard']"));
	        Assert.assertTrue(dashboardHeader.isDisplayed(), "Dashboard header should be visible after login.");
	    }

	    @Test(priority = 2, description = "Open About page from user dropdown", dependsOnMethods = "testLogin")
	    public void testOpenAboutFromUserDropdown() {
	        WebElement userDropdown = waitUntilClickable(By.xpath("//p[contains(@class,'oxd-userdropdown-name')]"));
	        userDropdown.click();

	        WebElement aboutLink = waitUntilClickable(By.xpath("//a[text()='About']"));
	        aboutLink.click();

	        // Validate About modal/dialog is displayed
	        WebElement aboutTitle = waitUntilVisible(By.xpath("//h6[text()='About']"));
	        Assert.assertTrue(aboutTitle.isDisplayed(), "'About' dialog should be visible after clicking About link.");
	    }

	    private WebElement waitUntilVisible(By locator) {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }

	    private WebElement waitUntilClickable(By locator) {
	        return wait.until(ExpectedConditions.elementToBeClickable(locator));
	    }

	    @AfterClass(alwaysRun = true)
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}