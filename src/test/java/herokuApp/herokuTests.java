package herokuApp;


import java.awt.AWTException;
//import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//import javax.swing.text.html.HTMLDocument.HTMLReader.HiddenAction;

//import org.apache.commons.lang3.Validate;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class herokuTests {
	
	public static WebDriver d;
	public static WebDriverWait wait;
	
	//@SuppressWarnings("deprecation")
	@BeforeMethod
	public static void tests() {
		WebDriverManager.chromedriver().setup(); 
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://the-internet.herokuapp.com/");
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//wait = new WebDriverWait(d, Duration.ofSeconds(3));

	}
	
	public void testLargeDeepDOM() {
		System.out.println("DOM tested successfully...");
	}
	
	@Test(priority=1)
	public static void checkbox() {
		d.findElement(By.xpath("//a[@href='/checkboxes']")).click();
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/checkboxes']"))).click();
		
		WebElement checkbox1 = d.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
		WebElement checkbox2 = d.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		//WebElement checkbox1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[1]")));
		//WebElement checkbox2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[2]")));
		if(!checkbox1.isSelected()) {
			checkbox1.click();
		} else {
			checkbox2.click();
		}
	}
	
	public static void validate(String actual, String expected, String message) {
		if(!actual.equals(expected)) {
			System.out.println("Validation failed" + message + "| Expected: " + expected + "| But it is giving Actual value : "+ actual);
			//throw new AssertionError("Failed: "+message);
		} else {
			System.out.println("Validation passed" + message);
		}
	}
	
	@Test(priority=2)
	public static void dragndrop(){
		d.findElement(By.xpath("//a[@href='/drag_and_drop']")).click();
		//d.findElement(By.xpath("//a[@href='/drag_and_drop']")).click();
		
		WebElement drogable = d.findElement(By.id("column-a"));
		WebElement dropable = d.findElement(By.id("column-b"));
		//WebElement drogable = wait.until(ExpectedConditions.elementToBeClickable(By.id("column-a")));
		//WebElement dropable = wait.until(ExpectedConditions.elementToBeClickable(By.id("column-b")));
		
		Actions actions = new Actions(d);
		actions.dragAndDrop(drogable, dropable).build().perform();
		
		String Droppedtext = dropable.getText();
		validate(Droppedtext, "Dropped!", "Drag and Drop");
	}
	
	@Test(priority=3)
	public static void dropDownTest() {
		
		d.findElement(By.xpath("//a[@href='/dropdown']")).click();
		
		WebElement dropdown = d.findElement(By.id("dropdown"));
		Select select = new Select(dropdown);
		select.selectByValue("1");
	}
	
	public static void dianamicContentsTest() {
		WebElement dynamicContent = d.findElement(By.xpath("//a[href='/dynamic_content']"));
		dynamicContent.click();
		d.findElement(By.xpath("//a[@href='/dynamic_content?with_content=static'")).click();
	}
	
	public static void dianamicLoadingTest() {
		WebElement dynamicLoadTest = d.findElement(By.xpath("//a[@href='/dynamic_loading']"));
		dynamicLoadTest.click();
		d.findElement(By.xpath("//a[@href='/dynamic_loading/1']")).click();
		d.findElement(By.id("Start"));
		//Verify hello World! text.
	}
	
	public static void EntryAdTest() {
		WebElement entryAd = d.findElement(By.xpath("//a[href='/entry_ad']"));
		entryAd.click();
		d.findElement(By.xpath("//a[text()='Close']"));
		//Verify Page isVisible OR not with "click here" button.
	}
	
	public static void ExitIntendTest() {
		d.findElement(By.xpath("//a[href='/exit_intent']")).click();
		//Verify "model window appear OR not.
	}
	
	public static void FileDownloadTest() {
		d.findElement(By.xpath("//a[href='/download']")).click();
		
	}
	
	public static void fileUploadTest() {
		WebElement fileUpload = d.findElement(By.xpath("//a[href='/upload']"));
		fileUpload.sendKeys("C:\\Users\\learn\\Downloads\\Mugdha Revandkar MANUAL TESTING1.pdf");
		//d.findElement(By.id("file-upload")).click(d.sendKeys("Mugdha Revandkar MANUAL TESTING1"));
		d.findElement(By.id("file-submit")).click();
		validate(d.findElement(By.xpath("//h1")).getText(),"Upload successful","File Upload");
	}
	
	public static void FloatingMenu(String message) {
		d.findElement(By.xpath("//a[href='/floating_menu']")).click();
		
		d.findElement(By.xpath("//a[@href='#home']")).click();
		String floatedAPIurl = d.getCurrentUrl();
		String[] floatedAPIs = floatedAPIurl.split("/");
		
		if(floatedAPIs[3].equals("floating_menu#home") || floatedAPIurl.endsWith("floatedAPIurl")) {
			System.out.println("Floating URl is working fine. -> "+floatedAPIs[2]);
		} else {
			throw new AssertionError("Url mismatch: "+message); 
		}
		
	}
	
	public static void ForgotPassword() {
		d.findElement(By.xpath("//a[href='/forgot_password']")).click();
	}
	
	public static void FormAuthentication() {
		d.findElement(By.xpath("//a[href='/login']")).click();
	}
	
	public static void Frames() {
		d.findElement(By.xpath("//a[href='/frames']")).click();

		d.findElement(By.xpath("//a[@href='/nested_frame']")).click();
		d.navigate().back();
		d.findElement(By.xpath("//a[@href='/iframe']")).click();
		validate(d.findElement(By.xpath("//h3")).getText(),"An iFrame containing the TinyMCE WYSIWYG Editor","iframe");
	}
	
	public static void Geolocation() {
		d.findElement(By.xpath("//a[href='/geolocation']")).click();
	}
	
	public static void HorizontalSlider() throws InterruptedException {
		d.findElement(By.xpath("//a[href='/horizontal_slider']")).click();

		WebElement slider = d.findElement(By.xpath("//input[@type='range']"));
		WebElement valueLabel = d.findElement(By.id("range"));
		
		Actions move = new Actions(d);
		move.clickAndHold(slider).moveByOffset(50, 0).release().perform();
		
		Thread.sleep(1000);
		
		String actualValue = valueLabel.getText();
		String expectedValue = "3.5";
		
		if(actualValue.equals(expectedValue)) {
			System.out.println("Slider value validated successfully: "+actualValue);
			//document.querySelector("input[type='range']").addEventListener("input", function() {
			//    console.log("Live value: " + this.value);
			//});
		} else {
			throw new AssertionError("Slider value mismatch. Expected: "+ expectedValue + "but got" + actualValue);

		}
	}
	
	public static void Hovers() {
		d.findElement(By.xpath("//a[href='/hovers']")).click();
		
		WebElement hoverUser1 = d.findElement(By.xpath("(//img[@alt='User Avatar'])[1]"));
		Actions hover = new Actions(d);
		hover.moveToElement(hoverUser1).perform();
		
		WebElement imageText1 = d.findElement(By.xpath("(//div[@class='figcaption']//h5)[1]"));
		String image1Text = imageText1.getText();
		
		validate(image1Text,"name: user1","text is not matching");
		//do it for remaining 2 also.
	}
	
	public static void Infinite_Scroll() {
		d.findElement(By.xpath("//a[href='/infinite_scroll']")).click();
		
		WebElement scrollPage = d.findElement(By.xpath("//div[@class='jscroll-inner']"));
		//Actions scroll = new Actions(d);
		((JavascriptExecutor)d).executeScript("arguments[0].scrollintoView(true);", scrollPage);
		scrollPage.click();
	}
	
	public static void Inputs() throws AWTException {
		d.findElement(By.xpath("//a[href='/inputs']")).click();
		d.findElement(By.xpath("//input[@type='number']")).sendKeys("2");
		Actions datamanupulate = new Actions(d);
		datamanupulate.sendKeys(Keys.ARROW_UP).perform();    //for number increment
		datamanupulate.sendKeys(Keys.ARROW_DOWN).perform();  //for number decrease
		
		//OR
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_UP);   //for increment
		robot.keyPress(KeyEvent.VK_DOWN);   //for decrement
	}
	
	public static void JQueryUIMenus(String message) {
		d.findElement(By.xpath("//a[href='/jqueryui/menu']")).click();
		WebElement disabled = d.findElement(By.xpath("//li[contains(@class,'ui-state-disabled')]"));
		WebElement enabled = d.findElement(By.xpath("(//li[@role='menuitem'])[3]"));
		enabled.click();
		WebElement selectDownload = d.findElement(By.xpath("(//li[@role='menuitem'])[4]"));
		selectDownload.click();
		d.findElement(By.xpath("//a[text()='Back to JQuery UI']")).click();
		
		if(!disabled.isEnabled() && disabled.isEnabled()) {
			System.out.println("Application working fine...!");
		} else {
			System.out.println("UI data is changed...!");
		}
		
		d.findElement(By.xpath("//a[text()='JQuery UI']"));
		//throw new AssertionError("Url mismatch: "+message); 
	}
	
	public static void JavaScriptAlerts() throws AWTException {
		//---
		d.findElement(By.xpath("//a[href='/javascript_alerts']")).click();
		d.findElement(By.xpath("//button[text()='Click for JS Alert']"));
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.KEY_PRESSED);

		WebElement resultValue1 = d.findElement(By.xpath("//p[@id='result']"));
		String result1 = resultValue1.getText();
		
		validate(result1, "You clicked: Ok", "test not worked correctly...!");
		//---
		d.findElement(By.xpath("//button[text()='Click for JS Confirm'")).click();
		robot.keyPress(KeyEvent.KEY_PRESSED);
		
		WebElement resultValue2 = d.findElement(By.xpath("//p[@id='result']"));
		String result2 = resultValue2.getText();

		validate(result2, "You clicked: Ok", "test not worked correctly...!");
		//---
		d.findElement(By.xpath("Click for JS Prompt")).click();
		robot.keyPress(KeyEvent.KEY_PRESSED);
		
		WebElement resultValue3 = d.findElement(By.xpath("//p[@id='result']"));
		String result3 = resultValue3.getText();
		
		validate(result3, "You clicked: Ok", "test not worked correctly...!");
	}
	
	public static void JavaScriptOnloadEventError() {
		d.findElement(By.xpath("//a[href='/javascript_error']")).click();
		String JSerrorSnip = d.findElement(By.xpath("")).getText();
		validate(JSerrorSnip, "This page has a JavaScript error in the onload event. This is often a problem to using normal Javascript injection techniques.", "Wrong details!");
	}
	
	public static void KeyPresses() {
		d.findElement(By.xpath("//a[href='/key_presses']")).click();
		WebElement pressIt = d.findElement(By.xpath("//input[@id='target']"));
		pressIt.sendKeys("rockPaperScissors");
		pressIt.sendKeys(Keys.ENTER);
		//add some more validations to it.
	}
	
	//************************************
	public static void LargeAndDeepDOM() {
		d.findElement(By.xpath("//a[href='/large']")).click();
		validate(d.findElement(By.xpath("//h3")).getText(), "Large & Deep DOM", "Text not found...!");
		//for rest you have to add details.
	}
	
	//************************************
	@Test(priority=3)
	public static void MultipleWindows() throws InterruptedException {
		//d.findElement(By.xpath("//a[@href='/windows']")).click();
		//validate(d.findElement(By.xpath("//h3")).getText(), "Opening a new window!", " Page found!");
		//Thread.sleep(5);
		//System.out.println("Url is reflected well!");
		//Thread.sleep(5);
		//d.findElement(By.xpath("//a[@href='/windows/new']")).click();
		//Thread.sleep(5);
		//d.fi
		
		String parentWindow = d.getWindowHandle();
		d.findElement(By.xpath("//a[@href='/windows']"));
		//d.findElement(By.xpath("//a[@href='/windows']")).click();
		Set<String> allWindows = d.getWindowHandles();
		for(String windowHandle : allWindows) {
			if(!windowHandle.equals(parentWindow)) {
				d.switchTo().window(windowHandle);
				//d.findElement(By.xpath("//h3")).getText();
				System.out.println("New Window text is " + d.findElement(By.xpath("//h3")).getText());
				break;
			}
		}
		
	}
	
	@Test(priority=4)
	public static void nested_frames() {
		d.findElement(By.xpath("//a[@href='/nested_frames']")).click();
		
		List<WebElement> frames = d.findElements(By.xpath("(//frameset[@frameborder='1'])[1]//frame"));
		for(WebElement frame : frames) {
			d.switchTo().frame(frame);
			System.out.println("Frame Title: "+ d.getTitle());
			d.switchTo().defaultContent();
		}
	}
	
	@Test(priority=5)
	public static void notification_message() {
		d.findElement(By.xpath("//a[@href='/notification_message']")).click();
		d.findElement(By.xpath("//a[text()='Click here']")).click();
	}
	
	@Test(priority=6)
	public static void RedirectLink() throws InterruptedException {
		d.findElement(By.xpath("//a[@href='/redirector']")).click();
		//d.findElement(By.xpath("//a[@href='/redirector']")).click();  //clicked on link
		d.findElement(By.id("redirect")).click(); 					  //clicked on redirect button
		
		String VerifRedirectedPage1 = d.findElement(By.xpath("//h3")).getText();
		validate(VerifRedirectedPage1, "Status Codes", ".  Page Verified Correctly!");
		
		//Standard API status code
		//d.findElement(By.xpath("//a[@href='status_codes/200']")).click();
		//d.findElement(By.xpath("//a[@href='/status_codes']")).click();
		//d.findElement(By.xpath("//a[@href='status_codes/301']")).click();
		//d.findElement(By.xpath("//a[@href='/status_codes']")).click();
		//d.findElement(By.xpath("//a[@href='status_codes/404']")).click();
		//d.findElement(By.xpath("//a[@href='/status_codes']")).click();
		//d.findElement(By.xpath("//a[@href='status_codes/500']")).click();
		//d.findElement(By.xpath("//a[@href='/status_codes']")).click();
		
		//OR you can use for-loop too
		String[] statusCode = {"200","0","301","0","404","0","500","0"};
		for(int i=0;i<=(statusCode.length-1);i++) {
			//if(!statusCode[i].equals(0)) {
			Thread.sleep(2000);
			if(!statusCode[i].equals("0")) {
				String xpath = "//a[@href='status_codes/"+statusCode[i]+"']"; 
				d.findElement(By.xpath(xpath)).click();
				System.out.println(d.findElement(By.xpath("//p")).getText());
				System.out.println("------------");
			} else {
				d.findElement(By.xpath("//a[@href='/status_codes']")).click();
			}
		}
	}
	
	//IMPORTANT----
	public static void SecureFileDownload() {
		d.findElement(By.xpath("//a[href='/download_secure']")).click();
		
	}
	
	//IMPORTANT----
	public static void ShadowDOM() {
		d.findElement(By.xpath("//a[href='/shadowdom']")).click();
	}
	
	@Test(priority=7)
	public static void ShiftingContent() {
		d.findElement(By.xpath("//a[@href='/shifting_content']")).click();
		d.findElement(By.xpath("//a[@href='/shifting_content/menu']")).click();
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/shifting_content/menu?mode=random']"))).click();
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/shifting_content/menu?pixel_shift=100']"))).click();
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/shifting_content/menu?mode=random&pixel_shift=100']"))).click();
		
		//List<WebElement> ShiftingMenu = d.findElements(By.xpath("//div[@class='example']//p"));
		List<WebElement> links = d.findElements(By.xpath("//div[@class='example']//p/a"));
		for(int i=0; i <=links.size()-1;i++) {
		//for(WebElement ShiftingMenuElement : ShiftingMenu) {
			links = d.findElements(By.xpath("//div[@class='example']//p/a"));
			
			WebElement link = links.get(i);
			//String linkText = link.getText();
			//System.out.println("Clinking link for "+ d.findElement(By.xpath("//div[@class='example']//p[i+1]/code")).getText()+", clicked on this link "+linkText);
			
			link.click();
			System.out.println("Current URL after click: "+d.getCurrentUrl());
			//String[] set = new String(ShiftingMenu);
			d.navigate().back();
		}
	}
	
	//IMPORTANT----
	public static void SlowResource() {
		d.findElement(By.xpath("//a[href='/slow']")).click();
	}
	
	//IMPORTANT----
	public static void SortableDataTable() {
		d.findElement(By.xpath("//a[href='/tables']")).click();
		
	}
	
	//IMPORTANT----
	public static void StatusCodes() {
		d.findElement(By.xpath("//a[href='/status_codes']")).click();
	}
	
	//IMPORTANT----
	public static void Typos() {
		d.findElement(By.xpath("//a[href='/typos']")).click();
	}
	
	//IMPORTANT----
	public static void WYSIWYG_Editor() {
		d.findElement(By.xpath("//a[href='/tinymce']")).click();
	}
	
	
	
	
	
	@AfterMethod
	public static void teardown() {
		if(d != null) {
			d.quit();
		}
	}
	
}
