package Automation_Excercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase03_Login_User_Incorrect_Email_Password {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'Login to your account' is visible
    6. Enter incorrect email address and password
    7. Click 'login' button
    8. Verify error 'Your email or password is incorrect!' is visible
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
        driver.close();
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
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();

        //5
        WebElement loginText = driver.findElement(By.xpath("//div[@class='login-form']//h2[1]"));
        if (loginText.isDisplayed()) {
            System.out.println("Log In testi PASSED");
        } else {
            System.out.println("Log In testi FAILED");
        }

        //6
        driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[1]")).sendKeys("aliatabakma1@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("123456");

        //7
        driver.findElement(By.xpath("(//button[@class='btn btn-default'])[1]")).click();

        //8
        WebElement incorrectText = driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']"));
        if (incorrectText.isDisplayed()) {
            System.out.println("Wrong Email or Password testi PASSED");
        } else {
            System.out.println("Wrong Email or Password testi FAILED");
        }

        /*
        Home Page testi PASSED
        Log In testi PASSED
        Wrong Email or Password testi PASSED
         */

    }
}
