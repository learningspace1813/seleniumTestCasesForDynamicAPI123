package sampleAllTexts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class sampleClassForAllTestcases {
	@Test
	public static void main() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("http://demoqa.com/registration/");

		//checkbox selection
		driver.get("http://demoqa.com/registration/");
		List<WebElement> w =
			driver.findElements(By.xpath("//input[@type='checkbox']"));
			for(WebElement x:w){
				if(x.getAttribute("value").equals("dance")||x.getAttribute("value").equals("cricket")){
				x.click();
				}
			}
		//multiple checkbox selection
		driver.get("http://demoqa.com/registration/");
		List<WebElement> w1 =
			driver.findElements(By.xpath("//input[@type='checkbox']"));
			for(int i=0;i<w.size();i++){
				w.get(i).click();
			}
		
		//for loop to select two checkbox
		driver.get("http://demoqa.com/registration/");
		List<WebElement> w2 =
		driver.findElements(By.xpath("//input[@type='checkbox']"));
		for(int i=0;i<w.size();i++){
			if(w.get(i).getAttribute("value").equals("dance")||w.get(i).getAttribute("value").equals("cricket ")){
			w.get(i).click();
			}
		}
		
		//To print the selected value
		driver.get("http://demoqa.com/registration/");
		List<WebElement> w3 = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (int i = 0; i < w.size(); i++) {
			if (w.get(i).getAttribute("value").equals("dance")|| w.get(i).getAttribute("value").equals("cricket")) {
				w.get(i).click();
			}
			if (w.get(i).isSelected()) {
				System.out.println(w.get(i).getAttribute("value"));
			}
		}

		//To select the unselected value
		driver.get("http://demoqa.com/registration/");
		List<WebElement> w4 = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (int i = 0; i < w.size(); i++) {
			if (w.get(i).getAttribute("value").equals("dance")|| w.get(i).getAttribute("value").equals("cricket")) {
				w.get(i).click();
			}
			if (!w.get(i).isSelected()) {
				w.get(i).click();
			}
		}
		
		//Handling auto-suggestions
		//	 We can handle auto suggestions by using findElements().
		//	Example:WAS for the following scenario.
		//	 Navigate to google
		//	 Search for qspiders
		//	 Count and print all the auto-suggestions
		//	 Click on last suggestion
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("selenium");
		Thread.sleep(2000);
		// To get address of all the suggestions
		String xp = "//span[contains(text(),'selenium')]";
		List<WebElement> allSuggestions = driver.findElements(By.xpath(xp));
		// To count number of suggetions
		int count = allSuggestions.size();
		System.out.println(count);
		// To print all the suggestions
		for (int i = 0; i < count; i++) {
			WebElement suggestion = allSuggestions.get(i);
			String text = suggestion.getText();
			System.out.println(text);
		}
		// To click on last suggestion
		allSuggestions.get(count - 1).click();
		
		//Dropdowns :
		//	1 selectByIndex(int)				...Select the options
		//	2 selectByValue(String) 
		//	3 selectByVisibleText(String)
		//	4 deselectByIndex(int)				...Deselect the options 
		//  5 deselectByValue(String)
		//	6 deselectByVisibleText(String)
		//	7 deselectAll()
		//	8 getAllSelectedOptions() 			...To get all the selected options
		//	9 getFirstSelectedOption() 			...To get first selected options
		//	10 getOptions() 					...To get all the options
		//	11 isMultiple() 					...To check whether list box is single or multi select
		//  Here,
		//		 getAttribute() to print particular tag(value) value
		//		 getText() to print all text

		
		//to print all values
		driver.get("http://ironspider.ca/forms/dropdowns.htm");
		WebElement w5 = driver.findElement(By.name("coffee"));
		Select s=new Select(w5);
		List<WebElement> o = s.getOptions();
		for (WebElement x:o) {
			System.out.println(x.getAttribute("value"));
		}

		//to print all texts
		driver.get("http://ironspider.ca/forms/dropdowns.htm");
		WebElement w6 = driver.findElement(By.name("coffee"));
		Select s1=new Select(w6);
		List<WebElement> o1 = s1.getOptions();
		for (WebElement x:o1) {
			System.out.println(x.getText());
		}

		//using normal for loop
		driver.get("http://ironspider.ca/forms/dropdowns.htm");
		WebElement w7 = driver.findElement(By.name("coffee"));
		Select s2=new Select(w7);
		List<WebElement> o2 = s2.getOptions();
		for (int i=0;i<=o2.size();i++) {
			System.out.println(o.get(i).getAttribute("value"));
		}

		//selectByIndex, selectByValue, selectByVisibleText
		driver.get("http://ironspider.ca/forms/dropdowns.htm");
		WebElement w8 = driver.findElement(By.name("coffee"));
		Select s3=new Select(w8);
		s3.selectByIndex(3);
		s3.selectByValue("regular");
		s.selectByVisibleText("With cream & sugar");
		
		//getAllSelectedOptions()
		driver.get("http://ironspider.ca/forms/dropdowns.htm");
		WebElement w9 = driver.findElement(By.name("coffee"));
		Select s4=new Select(w9);
		List<WebElement> web = s4.getAllSelectedOptions();
		for(WebElement x:web){
		System.out.println(x.getText());
		} 
		
		//isMultiple():
		//		 It is a method, used to check we can able to select multiple values or not
		driver.get("http://ironspider.ca/forms/dropdowns.htm");
		WebElement w10 = driver.findElement(By.name("coffee2"));
		Select s5=new Select(w10);
		boolean b = s5.isMultiple();
		System.out.println(b);
		
		//selectByIndex......(to get multiple options)
		//Note:
		//		 In multi-select list box, if the specified option is duplicate then it will select all the
		//		matching options.
		//		 We can handle duplicates by using index.
		//		driver.get("http://ironspider.ca/forms/dropdowns.htm");
		WebElement w11 = driver.findElement(By.name("coffee2"));
		Select s6=new Select(w11);
		List<WebElement> web1 = s6.getOptions();
		for(int i=0;i<web1.size();i++){
		s6.selectByIndex(i);
		}
		
		//deselectByIndex
		driver.get("http://ironspider.ca/forms/dropdowns.htm");
		WebElement w12 = driver.findElement(By.name("coffee2"));
		Select s7=new Select(w12);
		List<WebElement> web2 = s.getOptions();
		for(int i=0;i<web2.size();i++){
			s7.selectByIndex(i);
			Thread.sleep(3000);
			s7.deselectByIndex(i);
		}
		
		

	}
}