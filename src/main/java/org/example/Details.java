package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Details {
    static WebDriver driver;

    public Details() {
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.xpath("//div[@class='news-items']/div[2]/div[3]/a")).click();
        driver.findElement(By.id("AddNewComment_CommentTitle")).sendKeys(new CharSequence[]{"Maven Project homework"});
        driver.findElement(By.id("AddNewComment_CommentText")).sendKeys(new CharSequence[]{"This is the first homework of Maven Project."});
        driver.findElement(By.xpath("//div[@class='buttons']/button[1]")).click();
        String actualText = driver.findElement(By.xpath("//div[@class='result']")).getText();
        System.out.println(actualText);
        driver.close();
    }
}
