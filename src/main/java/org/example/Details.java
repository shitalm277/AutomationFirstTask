package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Details {
    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/test/Driver/chromedriver.exe");
        driver = new ChromeDriver(); // open the browser
        driver.manage().window().maximize(); //open the browser in full screen
        driver.get("https://demo.nopcommerce.com/"); //the website will be opened
        driver.findElement(By.xpath("//div[@class='news-items']/div[2]/div[3]/a")).click();// details link will be opened
        //in the title text box it will type as Maven homework automatically. no need to type.
        driver.findElement(By.id("AddNewComment_CommentTitle")).sendKeys("Maven Project homework");
        //in the comment text box it will type the comments automatically. no need to type.
        driver.findElement(By.id("AddNewComment_CommentText")).sendKeys("This is the first homework of Maven Project.");
        driver.findElement(By.xpath("//div[@class='buttons']/button[1]")).click(); //it will click on the New Comment button
        String actualText = driver.findElement(By.xpath("//div[@class='result']")).getText();
        System.out.println(actualText);
        //close the browser
        driver.close();
    }
}
