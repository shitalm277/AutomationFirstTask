package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
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

public class Registration {
    static WebDriver driver;

    public Registration() {
    }

    public static void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public static void typeText(By by, String text) {
        driver.findElement(by).sendKeys(new CharSequence[]{text});
    }

    public static String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public static String currentTimeStamp() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmss");
        return sdf.format(date);
    }

    public static void waitForClickable(By by, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, (long)timeInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitforVisible(By by, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, (long)timeInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    @BeforeMethod
    public void openBrowser() {
        System.out.println(currentTimeStamp());
        System.setProperty("webdriver.chrome.driver", "src/test/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test
    public void userShouldBeAbleToRegisterSuccessfully() {
        clickOnElement(By.xpath("//a[@class='ico-register']"));
        typeText(By.name("FirstName"), "Shital");
        typeText(By.name("LastName"), "Mehta");
        Select selectDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
        selectDay.selectByVisibleText("27");
        Select selectMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        selectMonth.selectByValue("5");
        Select selectYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
        selectYear.selectByValue("1989");
        String email = "shitalm7+" + currentTimeStamp() + "@gmail.com";
        System.out.println(email);
        driver.findElement(By.name("Email")).sendKeys(new CharSequence[]{email});
        waitforVisible(By.id("Newsletter"), 20);
        clickOnElement(By.id("Newsletter"));
        typeText(By.id("Password"), "shital.123");
        typeText(By.id("ConfirmPassword"), "shital.123");
        waitForClickable(By.name("register-button"), 10);
        clickOnElement(By.name("register-button"));
        String actualRegisterSuccessMessage = getTextFromElement(By.xpath("//div[@class='result']"));
        String expectedRegisterSuccessMessage = "Your registration completed";
        Assert.assertEquals(actualRegisterSuccessMessage, expectedRegisterSuccessMessage);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }
}
