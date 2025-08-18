package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StatusCodesPage {
    private final WebDriver driver;

    public StatusCodesPage(WebDriver driver) {
        this.driver = driver;
    }

    public String clickAndGetMessage(String code) {
        driver.findElement(By.linkText(code)).click();
        return driver.findElement(By.cssSelector(".example p")).getText();
    }
}
