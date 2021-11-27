package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class RegistrationTwo {
        static WebDriver driver;
        public static void main(String []args){

            System.setProperty("webdriver.chrome.driver","src/test/Driver/chromedriver.exe");
            //object for driver
            driver = new ChromeDriver();//Open the browser
            //open browser in Full screen
            driver.manage().window().maximize();
            //waits to screen available before executing next steps
            driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
            // type the URL
            driver.get("https://demo.nopcommerce.com/");
            //click on Register button
            driver.findElement(By.xpath("//a[@class='ico-register']")).click();
            //type first name
            driver.findElement(By.id("FirstName")).sendKeys("Shital");
            //type second name
            driver.findElement(By.id("LastName")).sendKeys("Mehta");
            //type email
            driver.findElement(By.id("Email")).sendKeys("shital@gmail.com");
            //type Password
            driver.findElement(By.id("Password")).sendKeys("shital123");
            //type confirm password
            driver.findElement(By.id("ConfirmPassword")).sendKeys("shital123");
            //click on register button
            driver.findElement(By.id("register-button")).click();
            String actualText = driver.findElement(By.xpath("//div[@class='page-body']/div[1]")).getText();
            System.out.println(actualText);
            //close browser
            driver.close();
        }
    }

