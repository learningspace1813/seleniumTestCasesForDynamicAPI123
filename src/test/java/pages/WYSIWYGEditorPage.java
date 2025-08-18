package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WYSIWYGEditorPage {
    private final WebDriver driver;
    private final By iframe = By.id("mce_0_ifr");
    private final By editorBody = By.id("tinymce");

    public WYSIWYGEditorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setText(String text) {
        driver.switchTo().frame(driver.findElement(iframe));
        driver.findElement(editorBody).clear();
        driver.findElement(editorBody).sendKeys(text);
        driver.switchTo().defaultContent();
    }

    public String getText() {
        driver.switchTo().frame(driver.findElement(iframe));
        String val = driver.findElement(editorBody).getText();
        driver.switchTo().defaultContent();
        return val;
    }
}
