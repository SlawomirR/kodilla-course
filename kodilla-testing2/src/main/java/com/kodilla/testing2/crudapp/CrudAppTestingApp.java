package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CrudAppTestingApp {
    public static final String XPATH_INPUT = "//html/body/main/section[1]/form/fieldset[1]/input";
    public static final String XPATH_TEXTAREA = "//html/body/main/section[1]/form/fieldset[2]/textarea";
    public static final String XPATH_WAIT_FOR = "//select[1]"; //change this
    public static final String XPATH_SELECT = "//div[contains(@class, \"tasks-container\")]/form/div/fieldset/select[1]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://interceptor2048.github.io");
/*
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            //Handle exception
        }
*/
        driver.get("https://interceptor2048.github.io");

        WebElement searchField = driver.findElement(By.xpath(XPATH_INPUT));
        searchField.sendKeys("New robotic task 1");

        WebElement textareaField = driver.findElement(By.xpath(XPATH_TEXTAREA));
        textareaField.sendKeys("The robotic content 1");

        while (!driver.findElement(By.xpath(XPATH_WAIT_FOR)).isDisplayed()) ;

        WebElement selectCombo = driver.findElement(By.xpath(XPATH_SELECT));
        Select selectBoard = new Select(selectCombo);
        selectBoard.selectByIndex(1);
    }
}
