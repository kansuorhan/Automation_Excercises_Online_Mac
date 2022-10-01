package Automation_Excercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestCaseBeforeAfterClass;

import java.io.FileInputStream;

public class TestCase06_Contact_Us_Form extends TestCaseBeforeAfterClass {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Contact Us' button
    5. Verify 'GET IN TOUCH' is visible
    6. Enter name, email, subject and message
    7. Upload file
    8. Click 'Submit' button
    9. Click OK button
    10. Verify success message 'Success! Your details have been submitted successfully.' is visible
    11. Click 'Home' button and verify that landed to home page successfully
     */

    @Test
    public void test() throws Exception {

        //2
        driver.get("http://automationexercise.com");

        //3
        WebElement category = driver.findElement(By.xpath("//h2[text()='Category']"));
        Assert.assertTrue(category.isDisplayed());

        //4
        driver.findElement(By.xpath("//*[@class='fa fa-envelope']")).click();

        //5
        WebElement centerText = driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]"));
        Assert.assertEquals(centerText.getText(),"GET IN TOUCH");

        //6
        driver.findElement(By.xpath("//input[@data-qa='name']")).sendKeys("Ali Ata");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@data-qa='email']")).sendKeys("aliatabak1@gmail.com");
        Thread.sleep(1500);

        driver.findElement(By.xpath("//input[@data-qa='subject']")).sendKeys("Thanksgiving");
        Thread.sleep(1500);

        driver.findElement(By.xpath("//*[@data-qa='message']")).sendKeys("Thanks for your website");
        Thread.sleep(1500);

        //7
        String filePath ="/Users/orhan/Downloads/testData.xlsx";

        FileInputStream fis = new FileInputStream(filePath);

        WebElement uploadFile = driver.findElement(By.xpath("//input[@name='upload_file']"));

        uploadFile.sendKeys(filePath);
        Thread.sleep(1500);

        //8
        driver.findElement(By.xpath("//input[@data-qa='submit-button']")).click();
        Thread.sleep(1500);

        //9
        driver.switchTo().alert().accept();
        Thread.sleep(1500);

        //10
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='status alert alert-success']"));
        Assert.assertEquals(successMessage.getText(),"Success! Your details have been submitted successfully.");

        //11
        driver.findElement(By.xpath("//span/i")).click();
        Thread.sleep(3000);

        WebElement mainPage = driver.findElement(By.xpath("//*[text()='Features Items']"));
        Assert.assertTrue(mainPage.isDisplayed());


    }
}
