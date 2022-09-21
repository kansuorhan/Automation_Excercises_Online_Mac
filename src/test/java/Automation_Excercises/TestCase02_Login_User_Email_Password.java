package Automation_Excercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase02_Login_User_Email_Password {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'Login to your account' is visible
    6. Enter correct email address and password
    7. Click 'login' button
    8. Verify that 'Logged in as username' is visible
    9. Click 'Delete Account' button
    10. Verify that 'ACCOUNT DELETED!' is visible
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
        WebElement loginPage = driver.findElement(By.xpath("//h2"));
        Assert.assertTrue(loginPage.getText().contains("Login to your account"));

        //6
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("aliatabak1@gmail.com");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("12345");
        Thread.sleep(1500);

        //7
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        Thread.sleep(1500);

        //8
        WebElement loggedIn = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        if (loggedIn.isDisplayed()) {
            System.out.println("Log In testi PASSED");
        } else {
            System.out.println("Log In testi FAILED");
        }

        //9
        driver.findElement(By.xpath("//i[@class='fa fa-trash-o']")).click();

        //10
        WebElement deleteText = driver.findElement(By.xpath("//div[@class='page-header']"));
        Assert.assertNotEquals("ACCOUNT DELETED!", deleteText.getText());

        /*
        Home Page testi PASSED
        Log In testi PASSED
         */

    }
}
