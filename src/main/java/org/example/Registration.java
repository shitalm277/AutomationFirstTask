package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Registration {
    static WebDriver driver;
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","src/test/Driver/chromedriver.exe");
        driver = new ChromeDriver(); //open the browser
        driver.manage().window().maximize(); //screen opens in full screen size
        //type the URL
        driver.get("https://demo.nopcommerce.com/"); // this URL will be opened dirctly.
        //click on the Register button
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        //it will take the name automatically.no need to type manually
        driver.findElement(By.id("FirstName")).sendKeys("Shital");
        //it will take the last name automatically.no need to type manually
        driver.findElement(By.id("LastName")).sendKeys("Mehta");
        //it will take the email automatically.no need to type manually
        driver.findElement(By.id("Email")).sendKeys("shital1234@bmail.com");
        //it will take the password automatically.no need to type manually
        driver.findElement(By.id("Password")).sendKeys("shital.123");
        //it will take the Confirmed password automatically.no need to type manually
        driver.findElement(By.id("ConfirmPassword")).sendKeys("shital.123");
        //Clicks on the register button automatically
        driver.findElement(By.id("register-button")).click();
        //Close the driver
        //driver.close();
    }
}
