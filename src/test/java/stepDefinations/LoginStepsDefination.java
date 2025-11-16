package stepDefinations;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepsDefination {
	    static WebDriver driver;
	
	    String username;
	    String password;

	    @Given("User reads credentials from Excel file")
	    public void user_reads_credentials_from_excel_file() throws IOException {
//	        // Make sure Excel is CLOSED before running
//	        FileInputStream fis = new FileInputStream("src/test/resources/users.xlsx");
//	        Workbook workbook = new XSSFWorkbook(fis);
//	        Sheet sheet = workbook.getSheetAt(0);
//
//	        Row row = sheet.getRow(1);  // 1 = second row (after header)
//	        username = row.getCell(0).getStringCellValue();
//	        password = row.getCell(1).getStringCellValue();
//
//	        System.out.println("Username from Excel: " + username);
//	        System.out.println("Password from Excel: " + password);
//
//	        workbook.close();
//	        fis.close(); // new        
	        
	    	  WebDriverManager.chromedriver().setup();
	          driver = new ChromeDriver();
	          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	          driver.manage().window().maximize();
	         
	    }
	    @When("User Open URL {string} and navigate to Login page")
	    public void user_open_url_and_navigate_to_login_page(String url) {
	        System.out.println("Opening URL: " + url);
	        driver.get(url);
	        String expectedTitle = "Swag Labs";   // Example: Title for saucedemo.com
	        String actualTitle = driver.getTitle();
	        System.out.println("Page Title: " + actualTitle);
	        if (actualTitle.contains(expectedTitle)) {
	            System.out.println("✅ Successfully navigated to Login page.");
	        } else {
	            System.out.println("❌ Navigation failed.");
	        }
	    }


	    @And("User enters username as {string} and password as {string}")
	    public void user_enters_username_as_and_password_as(String username, String password) {
	    	 System.out.println("Entering email and password...");
	        driver.findElement(By.id("user-name")).sendKeys(username);

	       
	        driver.findElement(By.id("password")).sendKeys(password);
	 
//	        driver.findElement(By.id("user-name")).sendKeys(username);
//	        driver.findElement(By.id("password")).sendKeys(password);
	    	
	    	 
	    }

	    @And("Clicks on Login button")
	    public void clicks_on_login_button() throws InterruptedException {
	    
	        driver.findElement(By.id("login-button")).click();
	       
	    } 

	    @Then("User should be logged in successfully")
	    public void user_should_be_logged_in_successfully() {
	        try {
	            String title = driver.findElement(By.xpath("//span[text()='Products']")).getText();
	            if (title.equals("Products")) {
	                System.out.println("✅ Login Successful for user: " + username);
	            }
	        } catch (Exception e) {
	            String errorMsg = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
	            System.out.println("❌ Login Failed for user: " + username + " → " + errorMsg);
	            
	        }}
	        
	        @When("User adds product to the cart")
	        public void user_adds_product_to_cart() throws InterruptedException {
	        	Thread.sleep(4000); 
	        	driver.findElement(By.xpath("//button[contains(@data-test, 'add-to-cart-sauce-labs-backpack')]")).click();
	            	           
	        }

	        @And("User should see in the cart")
	        public void user_should_see_product_in_cart() throws InterruptedException {
	            driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
	            Thread.sleep(2000); // Wait for 2 seconds to ensure the cart page is loaded
	            
	        }
	    	

	    }
