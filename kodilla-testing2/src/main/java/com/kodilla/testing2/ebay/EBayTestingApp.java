package com.kodilla.testing2.ebay;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EBayTestingApp {
    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://ebay.com");

        WebElement searchField = driver.findElement(By.id("gh-ac"));
        searchField.sendKeys("Laptop");
        searchField.submit();
        searchField = driver.findElement(By.id("e1-34"));
        searchField.click();
        searchField = driver.findElement(By.id("e1-13"));
        searchField.sendKeys("279");
        searchField = driver.findElement(By.id("e1-14"));
        searchField.sendKeys("280");
        searchField.submit();
    }
}
/*
3. W metodzie main napisz kod, który tworzy Selenium WebDriver (wykorzystaj istniejącą klasę WebDriverConfig do jego
utworzenia), znajduje pole do wyszukiwania przedmiotów, wstawia do niego napis "Laptop" i zatwierdza wyszukiwanie
*/