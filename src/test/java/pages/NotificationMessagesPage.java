package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NotificationMessagesPage {
    private final WebDriver driver;
    private final By clickHere = By.linkText("Click here");
    private final By flash = By.id("flash");

    public NotificationMessagesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void triggerMessage() {
        driver.findElement(clickHere).click();
    }

    public String getMessageText() {
        return driver.findElement(flash).getText().trim();
    }

}
