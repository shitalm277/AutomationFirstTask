package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BuildComputer {
    static WebDriver driver;
    public static void main(String[]args){
        System.setProperty("webdriver.chrome.driver","src/test/Driver/chromedriver.exe");
        driver = new ChromeDriver();//open the browser
        driver.manage().window().maximize();//open the browser in full screen
        driver.get("https://demo.nopcommerce.com/");//it will take you to this website
        driver.findElement(By.xpath("//div[@class='header-menu']/ul[1]/li[1]/a")).click();//clicks on the Computer menu
        driver.findElement(By.xpath("//ul[@class='sublist']/li[1]/a")).click();//clicks on Desktops menu
        driver.findElement(By.xpath("//div[@class='item-grid']/div[1]/div[1]/div[2]/h2/a")).click();//clicks on Build your own computer
    }
}
