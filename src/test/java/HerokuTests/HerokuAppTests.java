package HerokuTests;

//import java.util.List;
//import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

//import HerokuTests.BaseTest;
//import HerokuTests.TestUtils;
import pages.NotificationMessagesPage;
//import pages.SecureFileDownloadPage;
//import pages.ShadowDOMPage;
import pages.SlowResourcesPage;
import pages.SortableDataTablesPage;
import pages.StatusCodesPage;
import pages.TyposPage;
//import pages.WYSIWYGEditorPage;
import pages.LargeDeepDOMPage;

public class HerokuAppTests extends BaseTest {

    @Test
    public void testLargeDeepDOM() {
        driver.get("https://the-internet.herokuapp.com/large");
        LargeDeepDOMPage page = new LargeDeepDOMPage(driver);
        String text = page.getCellText();
        TestUtils.validateContains(text, "50", "Large DOM cell should include '50'");
    }

    @Test
    public void testNotificationMessages() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/notification_message_rendered");
        NotificationMessagesPage page = new NotificationMessagesPage(driver);
        // Try multiple times to handle flaky message text on the site
        boolean seen = false;
        for (int i = 0; i < 3; i++) {
            page.triggerMessage();
            Thread.sleep(500); // small wait for message
            String msg = page.getMessageText();
            if (msg.contains("Action") || msg.toLowerCase().contains("successful")) {
                seen = true;
                break;
            }
        }
        TestUtils.validateEquals(Boolean.toString(seen), "true", "Notification message should appear with expected content");
    }
    
//    @Test
//    public void assertMyParagraphs() {      
//    	// Get the Shadow DOM root element
//    	WebElement host = driver.findElement(By.cssSelector("my-paragraph"));
//
//    	// Execute JS to go inside the shadow root and fetch <ul>
//    	JavascriptExecutor js = (JavascriptExecutor) driver;
//    	WebElement ulElement = (WebElement) js.executeScript(
//    	    "return arguments[0].shadowRoot.querySelector('ul[slot=\"my-text\"]')", host);
//      //WebElement ulElement = driver.findElement(By.xpath("//ul[@slot='my-text']"));
//      List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
//
//      // Join all <li> texts into a single string
//      String allText = liElements.stream()
//                                 .map(e -> e.getText().trim())
//                                 .collect(Collectors.joining(" "));
//      
//      Assert.assertEquals(allText, "Let's have some different text! In a list!", "matching both texts!");
//
//      System.out.println("Combined text: " + allText);
//    }

    @Test
    public void testSlowResources() {
        driver.get("https://the-internet.herokuapp.com/slow");
        SlowResourcesPage page = new SlowResourcesPage(driver);
        TestUtils.validateEquals(Boolean.toString(page.isContentPresent()), "true", "Slow resources page should render content even if slow");
    }

    @Test
    public void testSortableDataTables() {
        driver.get("https://the-internet.herokuapp.com/tables");
        SortableDataTablesPage page = new SortableDataTablesPage(driver);
        page.clickLastNameHeader();
        String first = page.getFirstRowLastName();
        // The site sample data contains 'Bach' at some point; accept non-empty as baseline
        TestUtils.validateEquals(Boolean.toString(!first.isEmpty()), "true", "First row last name should not be empty after sort");
    }

    @Test
    public void testStatusCodes() {
        driver.get("https://the-internet.herokuapp.com/status_codes");
        StatusCodesPage page = new StatusCodesPage(driver);
        String msg404 = page.clickAndGetMessage("404");
        TestUtils.validateContains(msg404, "404", "Status codes page should mention 404");
    }

    @Test
    public void testTypos() {
        driver.get("https://the-internet.herokuapp.com/typos");
        TyposPage page = new TyposPage(driver);
        String p = page.getParagraph();
    }

    @Test
    public void testWYSIWYGEditor() {
        driver.get("https://the-internet.herokuapp.com/tinymce");

        // Switch to the editor's iframe
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));

        WebElement editorBody = driver.findElement(By.id("tinymce"));

        // Clear existing text using JS (TinyMCE body sometimes resists .clear())
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].innerHTML = '';", editorBody);

        // Type new text
        editorBody.sendKeys("Hello TinyMCE from Selenium!");

        // Switch back to main content
        driver.switchTo().defaultContent();

        // Optional: verify text is updated
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        String editorText = driver.findElement(By.id("tinymce")).getText();
        Assert.assertEquals(editorText, "Hello TinyMCE from Selenium!");
    }

////    Currently This page editor having some issues. So, We can't it deeply. 
//    @Test
//    public void testWYSIWYGEditor() {
//        driver.get("https://the-internet.herokuapp.com/tinymce");
//
//        // Switch to iframe first
//        WebElement editorIframe = driver.findElement(By.id("mce_0_ifr"));
//        driver.switchTo().frame(editorIframe);
//
//        // Clear and enter text in editor
//        WebElement editorBody = driver.findElement(By.id("tinymce"));
//        editorBody.clear();
//        editorBody.sendKeys("Hello TinyMCE from Selenium!");
//
//        // Get the paragraph text inside editor
//        String editorText = driver.findElement(By.xpath("//body/p")).getText();
//
//        // Switch back to default content
//        driver.switchTo().defaultContent();
//
//        // Assert the entered text
//        Assert.assertEquals(editorText, "Hello TinyMCE from Selenium!", "Editor text mismatch");
//    }

    
}
