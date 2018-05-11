package com.kodilla.testing2.ebay;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EBayTestingApp {
    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://ebay.com");

        WebElement searchField = driver.findElement(By.id("gh-ac"));
        searchField.sendKeys("Laptop");
        searchField.submit();
/*
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            //Handle exception
        }
*/
        searchField = driver.findElement(By.id("w3-w0-w1-multiselect[5]"));
        searchField.click();
        searchField = driver.findElement(By.id("w3-w0-w4-0-0[0]"));
        searchField.sendKeys("279");
        searchField = driver.findElement(By.id("w3-w0-w4-0-1[0]"));
        searchField.sendKeys("280");
        searchField = driver.findElement(By.xpath("//*[@id=\"w3-w0-w4-0\"]/div/button"));
        searchField.click();
        driver.findElement(By.xpath("/html/body")).sendKeys(Keys.F5);
    }
}
