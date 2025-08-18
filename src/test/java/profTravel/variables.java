package profTravel;

public class variables {
	//application url
	public static final String url = "https://phptravels.net/";
	public static final String homeText = "//p[@class='fs-5']";
	public static String appHead = "Let us help you plan your next journey — the one that will leave a lifetime of memories.";
	
	//Finding flights
	public static final String ticketType = "//select[contains(@class,'flight_way')]";
	public static final String seatingClass = "//select[@id='flight_type']";
	public static final String settingPlaceDD = "//input[@name='from']";
	public static final String settingPlace = "(//div[contains(@class,'fadein')])[2]//div[2]";
	public static final String departureDate = "//input[@id='departure']";
	public static final String departPlaceDD = "//input[@name='to']";
	public static final String departPlace = "(//div[contains(@class,'fadein')])[3]//div[3]";
	public static final String travelCountDD = "//a[@data-toggle='dropdown']";
	public static final String travelCountIncre = "(//*[local-name()='svg' and contains(@stroke-linejoin,'round')])[14]";
	public static final String searchFlight = "//button[@id='flights-search']";
	
	//Hotel Booking
	public static final String hotelMenuTab = "//ul[@class='header_menu navbar-nav']//li[2]//a";
	public static final String searchByCity = "//span[@role='combobox']";
	public static final String hotelSelection = "(//div[@class='most--popular-hotels']//div)[1]";
	public static final String checkIn = "//input[@id='checkin']";
	public static final String checkOut = "//input[@id='checkout']";
	//public static final String roomsDD1 = "(//a[contains(@class,'dropdown-toggle')])[5]";
	public static final String roomsDD = "//div[@class='dropdown dropdown-contain']";
	public static final String addRoom = "(//*[local-name()='svg' and contains(@stroke-linejoin,'round')])[13]";
	public static final String nationality = "//select[@id='nationality']";
	public static final String searchHotel = "//button[@type='submit']";
 
	//Tours planning
	public static final String toursMenuTab = "//ul[@class='header_menu navbar-nav']//li[3]//a";
	public static final String searchCityDD = "//span[@class='selection']";
	public static final String selectCity = "(//div[@class='most--popular-tours']//div)[1]";
	public static final String dateOfTour = "//input[@id='date']";
	public static final String tourTravellers = "//div[@class='dropdown dropdown-contain']";
	public static final String addAdults = "(//*[local-name()='svg' and contains(@stroke-linejoin,'round')])[11]";
	public static final String addChilds = "(//*[local-name()='svg' and contains(@stroke-linejoin,'round')])[13]";
	public static final String searchTours = "//button[@type='submit']";
	//filters and artings
	public static final String starRatting = "//input[@id='starRating5']";
	public static final String minSlider = "//span[@class='irs-handle from']";
	public static final String maxSlider = "//span[@class='irs-handle to']";
	public static final String sltPriceRange = "//div[@id='rangeFilter']";
	public static final String priceSortBy = "(//div[contains(@class,'rounded-5')])[2]/input";
	public static final String applyFilterBtn = "(//button[@data-bs-dismiss='offcanvas'])[2]";
	public static final String cancelFilterBtn = "(//button[@data-bs-dismiss='offcanvas'])[1]";
//	public static final String 
	
	//car booking
	public static final String carsMenuTab = "//ul[@class='header_menu navbar-nav']//li[4]//a";
	public static final String selectFromCity = "(//span[@class='selection'])[1]";
	public static final String carPickupCity = "(//div[@class='most--popular-cars-origin']//div)[1]";
	public static final String dropUpCity = "(//span[@class='selection'])[2]";
	public static final String dropUpCityInput1 = "//input[@class='select2-search__field']";
	public static final String nextMonthSwitch = "(//th[@class='next'])[1]";
	public static final String expDay = "15";
	public static final String expDay1 = "20";
	public static final String expMonthYear = "September 2025";
	public static final String pickUpDate = "(//input[@name='date'])[1]";
	public static final String pickUpTimeDD = "//select[@id='cars_from_time']";
	public static final String dropOffDate = "(//input[@name='date'])[2]";
	public static final String dropOffTimeDD = "//select[@id='cars_to_time']";
	public static final String carsTravellersDD = "//a[contains(@class,'travellers')]";
	public static final String addChildTravellerCnt = "(//*[local-name()='svg' and contains(@stroke-linejoin,'round')])[14]";
	public static final String searchCars = "(//button[@type='submit'])[1]";
	
	//visa booking
	public static final String visaMenuTab = "//ul[@class='header_menu navbar-nav']//li[5]//a";
	public static final String visaFromCountryDD = "(//span[@id='select2--container'])[1]";
	public static final String visaFromCountry = "//input[@class='select2-search__field']";
	public static final String visaToCountryDD = "(//span[@id='select2--container'])[2]";
	public static final String visaToCountry = "//input[@class='select2-search__field']";
	public static final String visaDate = "//input[@name='date']"; 
	//public static final String visaMonthYear = "(//th[@class='switch'])[1]";
	public static final String visaMonthYear = "September 2025";
	public static final String visaDay = "28";
	public static final String submitVisa = "//button[@type='submit']";
	
	//PHP travels blogs
	public static final String blogMenuTab = "//ul[@class='header_menu navbar-nav']//li[6]//a";
	public static final String blogLoadMore = "//button[@id='loadMore']";
	public static final String selectBlog = "(//div[@class='author-bio'])[1]";
	public static final String blogTitle = "//h1/strong[text()]";
//	public static final String MenuTab = "";
}
