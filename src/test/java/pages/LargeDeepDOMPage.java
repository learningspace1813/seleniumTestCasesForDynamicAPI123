package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LargeDeepDOMPage {
    WebDriver driver;
    private final By targetCell = By.xpath("//table[@id='large-table']//tr[50]/td[5]");

    public LargeDeepDOMPage(WebDriver driver) {							// X- Return type for the method is missing
        this.driver = driver;
    }

    public String getCellText() {
        return driver.findElement(targetCell).getText();
    }
}
