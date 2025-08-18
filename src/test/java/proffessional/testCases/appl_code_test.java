package proffessional.testCases;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class appl_code_test {
	
	public static WebDriver d;
	public static WebDriverWait w;
	
	
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public static void BaseParaBankLogin() {
		WebDriverManager.chromedriver().setup();
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://parabank.parasoft.com/parabank/index.htm");
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		d.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin123");
		d.findElement(By.xpath("//input[@name='password']")).sendKeys("Admin@123");
		d.findElement(By.xpath("//input[@value='Log In']")).click();
		String Test = d.findElement(By.xpath("(//h1)[1]")).getText().trim();
		Assert.assertEquals(Test,"Accounts Overview","Validated successfuly");
	}

	@Test(priority=1)
	public static void accOverview() {
		WebElement accNum = d.findElement(By.xpath("(//table[@id='accountTable']/tbody/tr/td)[1]"));
		String accNumber = accNum.getText();
		System.out.println("Account number is "+accNumber);
		//Assert.assertEquals(accNumber, "16563","Account Number is matching.");
		WebElement bal = d.findElement(By.xpath("(//table[@id='accountTable']/tbody/tr/td)[2]"));
		String balance = bal.getText();
		WebElement availBal = d.findElement(By.xpath("(//table[@id='accountTable']/tbody/tr/td)[3]"));
		String availBalance = availBal.getText();
		System.out.println("Account balance "+balance+" and Available balance "+ availBalance);
	}
	
	@Test(priority=2)
	public static void transferFunds() {
		d.findElement(By.xpath("//a[@href='transfer.htm']")).click();
		d.findElement(By.xpath("//input[@id='amount']")).sendKeys("200000");
		WebElement SenderAccList = d.findElement(By.xpath("//select[@id='fromAccountId']"));
		Select select = new Select(SenderAccList);
		select.selectByIndex(0);
		WebElement receiverAccList = d.findElement(By.xpath("//select[@id='toAccountId']"));
		Select select1 = new Select(receiverAccList);
		select1.selectByIndex(0);
		d.findElement(By.xpath("//input[@value='Transfer']")).click();
	}
	
	@Test(priority=3)
	public static void billPay() {
		d.findElement(By.xpath("//a[@href='billpay.htm']")).click();
		d.findElement(By.xpath("//input[@name='payee.name']")).sendKeys("Robin hood");
		d.findElement(By.xpath("//input[@name='payee.address.street']")).sendKeys("Robinorea palace");
		d.findElement(By.xpath("//input[@name='payee.address.city']")).sendKeys("Robino City");
		d.findElement(By.xpath("//input[@name='payee.address.state']")).sendKeys("Robiniyo");
		d.findElement(By.xpath("//input[@name='payee.address.zipCode']")).sendKeys("454226");
		d.findElement(By.xpath("//input[@name='payee.phoneNumber']")).sendKeys("12345678");
		d.findElement(By.xpath("//input[@name='payee.accountNumber']")).sendKeys("22134");
		d.findElement(By.xpath("//input[@name='verifyAccount']")).sendKeys("22134");
		d.findElement(By.xpath("//input[@name='amount']")).sendKeys("1000");
		WebElement fromAcc = d.findElement(By.xpath("//select[@name='fromAccountId']"));
		Select select = new Select(fromAcc);
		select.selectByIndex(0);
		d.findElement(By.xpath("//input[@value='Send Payment']")).click();
	}
	
//	//@Test(priority=4)
//	public static void findTransactions() {
//		d.findElement(By.xpath("//a[@href='findtrans.htm']")).click();
//		WebElement selectAcc = d.findElement(By.xpath("//select[@id='accountId']"));
//		Select select = new Select(selectAcc);
//		select.selectByIndex(0);
//		
//	}
	
//	@Test(priority=4)
//	public static void requestLoanPBank() {
//		d.findElement(By.xpath("//input[@id='amount']")).sendKeys("1000");
//		d.findElement(By.xpath("//input[@id='downPayment']")).sendKeys("500");
//		WebElement selectAcc = d.findElement(By.xpath("//select[@id='fromAccountId']"));
//		Select selectAccount = new Select(selectAcc);
//		selectAccount.selectByIndex(0);
//		d.findElement(By.xpath("//input[@value='Apply Now']"));
//	}
	
//	@Test(priority=1)
//	public static void paraBankHome() {
//		d.findElement(By.xpath("(//a[@href='index.htm'])[2]")).click();
//		d.findElement(By.xpath("(//a[text()='Read More'][1])[1]")).click();
//		d.findElement(By.xpath("(//a[@href='index.htm'])[2]")).click();
//		d.findElement(By.xpath("(//a[text()='Read More'][1])[2]")).click();
//		d.findElement(By.xpath("(//a[@href='index.htm'])[2]")).click();
//	}
//	
//	@Test(priority=2)
//	public static void paraSoftDemoWebsite() {
//		d.findElement(By.xpath("(//a[@href='about.htm'])[2]")).click();
//	}
//	
//	@Test(priority=3)
//	public static void customerCareHelp() {
//		d.findElement(By.xpath("(//a[@href='contact.htm'])[1]")).click();
//		d.findElement(By.xpath("//input[@name='name']")).sendKeys("Robin");
//		d.findElement(By.xpath("//input[@name='email']")).sendKeys("Robin@123");
//		d.findElement(By.xpath("//input[@name='phone']")).sendKeys("12345678");
//		d.findElement(By.xpath("//input[@name='message']")).sendKeys("Issue with the online demo bank.");
//		d.findElement(By.xpath("//input[@value='Send to Customer Care']")).click();
//	}
}
