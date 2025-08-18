package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SortableDataTablesPage {
    private final WebDriver driver;
    private final By lastNameHeader = By.xpath("//table[1]//th[1]");
    private final By firstRowLastName = By.xpath("//table[1]//tbody/tr[1]/td[1]");

    public SortableDataTablesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLastNameHeader() {
        driver.findElement(lastNameHeader).click();
    }

    public String getFirstRowLastName() {
        return driver.findElement(firstRowLastName).getText();
    }
}
