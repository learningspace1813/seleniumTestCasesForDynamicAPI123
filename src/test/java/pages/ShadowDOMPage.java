package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.testng.Assert;

public class ShadowDOMPage {
    private final WebDriver driver;

    public ShadowDOMPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getShadowSpanText() {
        // The page contains multiple shadow hosts; this tries to find the first shadow root span
        WebElement host = driver.findElement(By.cssSelector("div#shadow-host, div > my-paragraph, .shadow-root"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Object shadowRoot = js.executeScript("return arguments[0].shadowRoot", host);
        if (shadowRoot == null) {
            return "";
        }
        WebElement span = (WebElement) js.executeScript("return arguments[0].shadowRoot.querySelector('span')", host);
        return span == null ? "" : span.getText();
//        
//        System.out.println("Shadow DOM Text: " + shadowRoot);
//
//        // Assert
//        Assert.assertTrue(shadowRoot.contains("shadow"), 
//            "Shadow DOM should include word 'shadow' | Actual: " + shadowRoot);
    }
    
}
