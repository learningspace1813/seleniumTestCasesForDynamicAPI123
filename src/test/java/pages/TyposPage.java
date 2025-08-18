package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TyposPage {
    private final WebDriver driver;
    private final By para = By.cssSelector(".example p");

    public TyposPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getParagraph() {
        return driver.findElement(para).getText();
    }
}
