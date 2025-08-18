package profTravel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class travelAppTest {
	public static WebDriver d;
	public static WebDriverWait w;
	public static String priceRange = "By.xpath(variables.sltPriceRange)";
	public static String minLength = "By.xpath(variables.minSlider)";
	public static String maxLength = "By.xpath(variables.maxSlider)";
	public static String appHead = "Let us help you plan your next journey — the one that will leave a lifetime of memories.";
	
	@SuppressWarnings("deprecation")
	@BeforeClass
	public static void setuptest() {
		WebDriverManager.chromedriver().setup();
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://phptravels.net/");
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test(priority=1)
	public static void homepageTest() {
	    WebElement mainPageString = d.findElement(By.xpath(variables.homeText));
	    String actualText = mainPageString.getText().trim();
	    Assert.assertEquals(actualText, appHead, "String not found!");
	}

	
	@Test(priority=2)
	public static void flightSearch() {
		//[Documentation] : select way
		WebElement way = d.findElement(By.xpath(variables.ticketType));
		Select selectway = new Select(way);
		selectway.selectByValue("oneway");											
		
		//[Documentation] : select seating class.
		WebElement sittingClass = d.findElement(By.xpath(variables.seatingClass));
		Select selectClass = new Select(sittingClass);
		selectClass.selectByValue("economy_premium");
		
		//[Documentation] : select setting place.
		WebElement settingCity = d.findElement(By.xpath(variables.settingPlaceDD));
		settingCity.click();
		d.findElement(By.xpath(variables.settingPlace)).click();		//settingCity.sendKeys("NYC");
		
		//[Documentation] : select depart time.
		WebElement departDate = d.findElement(By.xpath(variables.departureDate));
		departDate.clear();
		departDate.sendKeys("21-08-2025");
		
		//[Documentation] : select destination place.
		WebElement destCity = d.findElement(By.xpath(variables.departPlaceDD));
		destCity.click();
		d.findElement(By.xpath(variables.departPlace)).click();		//destCity.sendKeys("DXB");
		
		//[Documentation] : select Traveller's count.
		WebElement travelCount = d.findElement(By.xpath(variables.travelCountDD));
		travelCount.click();
		d.findElement(By.xpath(variables.travelCountIncre)).click();
		travelCount.click();
		//d.findElement(By.xpath(variables.searchFlight)).click();
		
	}
	
	@Test(priority=3)
	public static void HotelBooking() {
		//[Documentation] : Hotel booking script.
		d.findElement(By.xpath(variables.hotelMenuTab)).click();
		d.findElement(By.xpath(variables.searchByCity)).click();
		d.findElement(By.xpath(variables.hotelSelection)).click();
		d.findElement(By.xpath(variables.checkIn)).sendKeys("22-08-2025");
		d.findElement(By.xpath(variables.checkOut)).sendKeys("28-08-2025");
		WebElement roomSelect = d.findElement(By.xpath(variables.roomsDD));
		roomSelect.click();
		d.findElement(By.xpath(variables.addRoom)).click();
		WebElement selectNationality = d.findElement(By.xpath(variables.nationality));
		Select slctNationality = new Select(selectNationality);
		slctNationality.selectByValue("IN");
		roomSelect.click();
		d.findElement(By.xpath(variables.searchHotel)).click();
	}
	
	@Test(priority=4)
	public static void tourBooking() {
		//[Documentation] : Tour booking script.
		d.findElement(By.xpath(variables.toursMenuTab)).click();
		d.findElement(By.xpath(variables.searchCityDD)).click();
		d.findElement(By.xpath(variables.selectCity)).click();
		d.findElement(By.xpath(variables.dateOfTour)).sendKeys("01-09-2025");
		d.findElement(By.xpath(variables.tourTravellers)).click();
		d.findElement(By.xpath(variables.addAdults)).click();
		d.findElement(By.xpath(variables.addChilds)).click();
		d.findElement(By.xpath(variables.searchTours)).click();	
	}
	
//	@Test(priority=5)
//	public static void tourRatingNfilters() {
//		//[Documentation] : Ratings for tours.
//		utils slider = new utils(d);
//		slider.moveSlider(By.xpath(variables.sltPriceRange), By.xpath(variables.minSlider), By.xpath(variables.maxSlider), 0, 10000, 3000, 4000);
//		//d.findElement(By.xpath(variables.starRatting)).click();
//		//d.findElement(By.xpath(variables.priceSortBy)).click();
//		//d.findElement(By.xpath(variables.applyFilterBtn)).click();
//	    // select star rating
//		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));
//	    WebElement star = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.starRatting)));
//	    star.click();
//
//	    WebElement element = d.findElement(By.xpath("//h4[@class='mb-3 mt-3']"));
//	    ((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", element);
//	    
//	    // sort by price
//	    WebElement sort = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.priceSortBy)));
//	    sort.click();
//
//	    JavascriptExecutor js = (JavascriptExecutor) d;
//	    //js.executeScript("window.scrollBy(0, 10000)");
//	    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//
//	    
//	    // apply filter
//	    WebElement apply = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.applyFilterBtn)));
//	    apply.click();
//	}
	
	@Test(priority=5)
	public static void carBooking() throws InterruptedException {
		d.findElement(By.xpath(variables.carsMenuTab)).click();
		d.findElement(By.xpath(variables.selectFromCity)).click();
		d.findElement(By.xpath(variables.carPickupCity)).click();
		d.findElement(By.xpath(variables.dropUpCity)).click();
		
		WebElement dropUpCity = d.findElement(By.xpath(variables.dropUpCityInput1));
		dropUpCity.sendKeys("New Delhi");
		Thread.sleep(3000);
		dropUpCity.sendKeys(Keys.ENTER);

		d.findElement(By.xpath(variables.pickUpTimeDD)).sendKeys("05:00 AM",Keys.ENTER);
		d.findElement(By.xpath(variables.dropOffTimeDD)).sendKeys("08:00 AM",Keys.ENTER);
		d.findElement(By.xpath(variables.carsTravellersDD)).click();
		Thread.sleep(3000);
		
		WebElement addTravellers = d.findElement(By.xpath(variables.addChildTravellerCnt));
		addTravellers.click();
		addTravellers.click();
		
		Thread.sleep(3000);
		//-------------------------------------------------------------------
		// 1. Click input field to open datepicker (replace with your field locator)
	    d.findElement(By.xpath(variables.pickUpDate)).click();
	    
	    while (true) {
	        String monthYear = d.findElement(By.xpath("(//th[@class='switch'])[1]")).getText();
	        
	        if (monthYear.equals(variables.expMonthYear)) {
	            break;
	        } else {
	            d.findElement(By.xpath("(//th[@class='next'])[1]")).click();  // go forward
	            // or use //th[@class='prev'] for backwards
	        }
	    }
	    String dayXpath = String.format("//td[@class='day ' and text()='%s']", variables.expDay);
	    d.findElement(By.xpath(dayXpath)).click();
	    //-------------------------------------------------------------------
		// 1. Click input field to open datepicker (replace with your field locator)
	    d.findElement(By.xpath(variables.dropOffDate)).click();

	    while (true) {
	        String monthYear = d.findElement(By.xpath("(//th[@class='switch'])[4]")).getText();
	        
	        if (monthYear.equals(variables.expMonthYear)) {
	            break;
	        } else {
	            d.findElement(By.xpath("(//th[@class='next'])[4]")).click();  // go forward
	            // or use //th[@class='prev'] for backwards
	        }
	    }

	    String dayXpath1 = String.format("(//td[@class='day ' and text()='%s'])[2]", variables.expDay1);
	    d.findElement(By.xpath(dayXpath1)).click();
	    //-------------------------------------------------------------------

		d.findElement(By.xpath(variables.searchCars)).click();
	}
	
	
	
	@Test(priority=6)
	public static void finalingVisa() {
		d.findElement(By.xpath(variables.visaMenuTab)).click();
		d.findElement(By.xpath(variables.visaFromCountryDD)).click();
		d.findElement(By.xpath(variables.visaFromCountry)).sendKeys("India", Keys.ENTER);
		d.findElement(By.xpath(variables.visaToCountryDD)).click();
		d.findElement(By.xpath(variables.visaToCountry)).sendKeys("Finland", Keys.ENTER);
		d.findElement(By.xpath(variables.visaDate)).click();
		while(true) {
			String monthYear = d.findElement(By.xpath("(//th[@class='switch'])[1]")).getText();
			
			if(monthYear.equals(variables.visaMonthYear)) {
				break;
			} else {
				d.findElement(By.xpath("(//th[@class='next'])[1]")).click();
			}
		}
		
	    String dayXpath1 = String.format("//td[@class='day ' and text()='20']", variables.visaDay);
	    d.findElement(By.xpath(dayXpath1)).click();
	    
	    d.findElement(By.xpath(variables.submitVisa)).click();
	}
	
	@Test(priority=7)
	public static void blogs() {
		d.findElement(By.xpath(variables.blogMenuTab)).click();
		d.findElement(By.xpath(variables.selectBlog)).click();
	}
}
