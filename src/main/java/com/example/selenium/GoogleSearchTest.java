package com.example.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchTest {
    public static void main(String[] args) {
        // Optional: set path to chromedriver manually if not in PATH
        // System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");

        // WebDriver driver = new ChromeDriver();
        // driver.get("https://owasp.org/www-project-juice-shop/");
        // driver.manage().window().maximize();

        // System.out.println("Page title is: " + driver.getTitle());

        // WebElement hover = driver.findElement(By.xpath("(//a[text()=\"PROJECTS\"])[1]"));

        // Actions actions = new Actions(driver);
        // actions.moveToElement(hover).perform();

        // WebElement brsProjects = driver.findElement(By.xpath("//ul[@class=\"dropdown-menu\"]//a[text()=\"Browse All Projects...\"]"));
        // brsProjects.click();

        // Initialize driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open URL
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Create a single WebDriverWait with a reasonable timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for username field to be visible, then send keys
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        username.sendKeys("Admin");

        // Wait for password field to be visible, then send keys
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
        password.sendKeys("admin123");

        // Wait for login button to be clickable, then click
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        login.click();

        //About Manda user
        WebElement mandaUser = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='manda user']")));
        mandaUser.click();

        WebElement About = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='About']")));
        About.click();

        // WebElement dropdown = driver.findElement(By.xpath("//li[@class='oxd-userdropdown']"));
        // Select select = new Select(dropdown);
        // select.selectByVisibleText("About");
        

        //hover and scroll content
        // WebElement hoverToContent = driver.findElement(By.xpath("//div[contains(@class, '--scroll-visible')]"));
        //  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hoverToContent);

        try {
            Thread.sleep(3000); // wait 3 seconds so you see the result
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("New page title is: " + driver.getTitle());
        driver.quit();
    }
}