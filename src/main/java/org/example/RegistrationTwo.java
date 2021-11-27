package org.example;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationTwo {
    static WebDriver driver;

    public RegistrationTwo() {
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        driver.findElement(By.id("FirstName")).sendKeys(new CharSequence[]{"Shital"});
        driver.findElement(By.id("LastName")).sendKeys(new CharSequence[]{"Mehta"});
        driver.findElement(By.id("Email")).sendKeys(new CharSequence[]{"shital@gmail.com"});
        driver.findElement(By.id("Password")).sendKeys(new CharSequence[]{"shital123"});
        driver.findElement(By.id("ConfirmPassword")).sendKeys(new CharSequence[]{"shital123"});
        driver.findElement(By.id("register-button")).click();
        String actualText = driver.findElement(By.xpath("//div[@class='page-body']/div[1]")).getText();
        System.out.println(actualText);
        driver.close();
    }
}
