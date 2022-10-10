package Automation_Excercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.time.Duration;

public class TestCase01_Register_User {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'New User Signup!' is visible
    6. Enter name and email address
    7. Click 'Signup' button
    8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    9. Fill details: Title, Name, Email, Password, Date of birth
    10. Select checkbox 'Sign up for our newsletter!'
    11. Select checkbox 'Receive special offers from our partners!'
    12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    13. Click 'Create Account button'
    14. Verify that 'ACCOUNT CREATED!' is visible
    15. Click 'Continue' button
    16. Verify that 'Logged in as username' is visible
    17. Click 'Delete Account' button
    18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
     */

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);
        //driver.close();
    }

    @Test
    public void test() throws Exception {
        //2
        driver.get("http://automationexercise.com");

        //3
        WebElement homepage = driver.findElement(By.xpath("//html"));
        if (homepage.isDisplayed()) {
            System.out.println("Home Page testi PASSED");
        } else {
            System.out.println("Home Page testi FAILED");
        }

        //4
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();

        //5
        WebElement signUpText = driver.findElement(By.xpath("//h2"));
        if (signUpText.getText().contains("New User Signup!")) {
            System.out.println("Sign Up testi PASSED");
        } else {
            System.out.println("Sign Up testi FAILED");
        }

        //6
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Ali Ata");

        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("aliatabak1@gmail.com");

        //7
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        //8
        WebElement headerAccount = driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]"));
        if (headerAccount.isDisplayed()) {
            System.out.println("Enter Account testi PASSED");
        } else {
            System.out.println("Enter Account testi FAILED");
        }

        //9
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("12345");
        Thread.sleep(1500);
        driver.findElement(By.xpath("(//select[@class='form-control'])[1]")).sendKeys("5");
        Thread.sleep(1500);
        driver.findElement(By.xpath("(//select[@class='form-control'])[2]")).sendKeys("August");
        Thread.sleep(1500);
        driver.findElement(By.xpath("(//select[@class='form-control'])[3]")).sendKeys("1986");
        Thread.sleep(1500);

        //10
        WebElement newsletterCheck = driver.findElement(By.xpath("//input[@id='newsletter']"));
        if (!newsletterCheck.isSelected()) {
            newsletterCheck.click();
        }

        //11
        WebElement offerCheck = driver.findElement(By.xpath("//input[@id='optin']"));
        if (!offerCheck.isSelected()) {
            offerCheck.click();
        }

        //12
        driver.findElement(By.xpath("//input[@data-qa='first_name']")).sendKeys("Ali Ata");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//input[@data-qa='last_name']")).sendKeys("Bak");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//input[@data-qa='address']")).sendKeys("Ahmet Mah. Aslan Sokak");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//select[@data-qa='country']")).sendKeys("United States");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//input[@data-qa='state']")).sendKeys("Arizona");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//input[@data-qa='city']")).sendKeys("Arizona State");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//input[@data-qa='zipcode']")).sendKeys("75052");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//input[@data-qa='mobile_number']")).sendKeys("+15123445654");
        Thread.sleep(1500);

        //13
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

        //14
        WebElement createText = driver.findElement(By.xpath("//h2[@data-qa='account-created']"));
        if (createText.getText().contains("ACCOUNT CREATED!")) {
            System.out.println("Account Create testi PASSED");
        } else {
            System.out.println("Account Create testi FAILED");
        }

        //15
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        //16
        WebElement logInText = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        if (logInText.getText().contains("Ali Ata")) {
            System.out.println("Login testi PASSED");
        } else {
            System.out.println("Login testi FAILED");
        }

        //17
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

        //18
        //driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
        WebElement deleteAccount = driver.findElement(By.xpath("//*[@href='/delete_account']"));
        deleteAccount.click();

        //19





    }
}
