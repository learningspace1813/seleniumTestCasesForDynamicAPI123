package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SlowResourcesPage {
    private final WebDriver driver;
    private final By content = By.cssSelector(".example");

    public SlowResourcesPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isContentPresent() {
        return driver.findElements(content).size() > 0;
    }
}
