package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static java.awt.SystemColor.text;

public class Registration{
    static WebDriver driver;
    public static void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public static void typeText(By by, String text){
        driver.findElement(by).sendKeys(text);
        }

    public static String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }

    public static String currentTimeStamp(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmss");
        return sdf.format(date);
    }

    public static void waitForClickable(By by, int timeInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitforVisible(By by , int timeInSeconds){
        WebDriverWait wait = new WebDriverWait(driver,timeInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    @BeforeMethod
    public void openBrowser(){
        System.out.println(currentTimeStamp());//to check the date stamp in returning
        System.setProperty("webdriver.chrome.driver","src/test/Driver/chromedriver.exe");
        //object for browser
        driver = new ChromeDriver(); //open the browser
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.manage().window().maximize(); //screen opens in full screen size
        //type the URL
        driver.get("https://demo.nopcommerce.com/"); // this URL will be opened directly.
    }

    @Test
    public void userShouldBeAbleToRegisterSuccessfully(){



        //click on the Register button
        clickOnElement(By.xpath("//a[@class='ico-register']"));


        //it will take the name automatically.no need to type manually
        typeText(By.name("FirstName"), "Shital");
        //it will take the last name automatically.no need to type manually
        typeText(By.name("LastName"), "Mehta");


        //select day from the dropdown
        Select selectDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
        selectDay.selectByVisibleText("27");

        //select month from dropdown
        Select selectMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        selectMonth.selectByValue("5");

        //select year from dropdown
        Select selectYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
        selectYear.selectByValue("1989");

        //it will take the email automatically.no need to type manually
        String email = "shitalm7+" +currentTimeStamp() + "@gmail.com";
        System.out.println((email));
        driver.findElement(By.name("Email")).sendKeys(email);

        waitforVisible(By.id("Newsletter"), 20);

        clickOnElement(By.id("Newsletter"));

        typeText(By.id("Password"), "shital.123");
        typeText(By.id("ConfirmPassword"), "shital.123");
        //it will take the password automatically.no need to type manually
        //it will take the Confirmed password automatically.no need to type manually

        waitForClickable(By.name("register-button"), 10);
        clickOnElement(By.name("register-button"));
        //Clicks on the register button automatically
        String actualRegisterSuccessMessage = getTextFromElement(By.xpath("//div[@class='result']"));
        String expectedRegisterSuccessMessage = "Your registration completed";
        Assert.assertEquals(actualRegisterSuccessMessage,expectedRegisterSuccessMessage);


        }
    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }
}
