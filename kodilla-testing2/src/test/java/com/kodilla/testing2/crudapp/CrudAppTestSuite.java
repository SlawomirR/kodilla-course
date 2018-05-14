package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class CrudAppTestSuite {
    private static final String BASE_URL = "https://slawomirr.github.io";
    private WebDriver driver;
    private Random generator;
    private WebDriverWait wait;

    @Before
    public void initTest() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
        wait = new WebDriverWait(driver, 3);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].innerText = \'Asking Heroku to load data... please wait\'",
                driver.findElement(By.xpath("/html/body/h1"))
        );
        waitForJQueryLoad(driver);
    }

    @After
    public void cleanUpAfterTest() {
        sleepTime(3_000);
        driver.close();
    }

    @Test
    public void shouldCreateTrelloCard() {
        // Given
        String taskName = createCrudAppTestTask();
        // When
        sendTestTaskToTrello(taskName);
        // Then
        assertTrue(checkTaskExistsInTrello(taskName));
        // Clean up
        deleteAddedTestTaskInCrudApp(taskName);
    }

    private String createCrudAppTestTask() {
        final String XPATH_TASK_NAME = "//form[contains(@action, \"createTask\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action, \"createTask\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[contains(@action, \"createTask\")]/fieldset[3]/button";
        String taskName;
        String taskContent;
        String fiveDigit = "" + 1 + generator.nextInt(10) + generator.nextInt(10) + generator.nextInt(10)
                + generator.nextInt(10) + generator.nextInt(10) + generator.nextInt(10);
        taskName = "Task number " + fiveDigit;
        taskContent = taskName + " content";

        waitForJQueryLoad(driver);

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();

        System.out.println(" ===> taskName: " + taskName);
        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) {
        waitForJQueryLoad(driver);

        driver.findElements(By.xpath("//div[@class=\"datatable__tasks-container\"]/*")).stream()
                .filter(anyForm -> anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                        .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectBoard = theForm.findElement(By.xpath("./div/fieldset[2]/select[1]"));
                    (new Select(selectBoard)).selectByValue("5a9ef8cacec866c4ed4448d1");

                    waitForJQueryLoad(driver);

                    WebElement selectList = theForm.findElement(By.xpath("./div/fieldset[2]/select[2]"));
                    (new Select(selectList)).selectByValue("5a9f052fc31ef828f00e4fbd");

                    WebElement buttonCreateCard = theForm.findElement(By.xpath("./div/fieldset[2]/button"));
                    buttonCreateCard.click();
                });
        wait.until(ExpectedConditions.alertIsPresent());
    }

    private boolean checkTaskExistsInTrello(String taskName) {
        final String TRELLO_URL = "https://trello.com/b/r3PFBoTh/kodilla-application";
        boolean result;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverTrello.get(TRELLO_URL);

        waitForJQueryLoad(driverTrello);
        result = driverTrello.findElements(By.xpath("//*[@id=\"board\"]/*")).stream()
                .filter(theSpan -> theSpan.getText().contains(taskName))
                .collect(Collectors.toList())
                .size() > 0;

        driverTrello.close();
        return result;
    }

    private void deleteAddedTestTaskInCrudApp(String taskName) {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

        waitForJQueryLoad(driver);
        driver.findElements(By.xpath("//div[@class=\"datatable__tasks-container\"]/*")).stream()
                .filter(anyForm -> anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                        .getText().equals(taskName))
                .forEach(theForm -> {
                            WebElement deleteButton = theForm.findElement(By.xpath("./div/fieldset[1]/button[4]"));
                            deleteButton.click();
                        }
                );
        waitForJQueryLoad(driver);
    }

    private void waitForJQueryLoad(WebDriver currentDriver) {
        WebDriverWait jsWait;
        jsWait = new WebDriverWait(currentDriver, 120);
        ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) driver)
                .executeScript("return jQuery.active") == 0);
        jsWait.until(jQueryLoad);
    }

    private void sleepTime(int miliSeconds) {
        try {
            Thread.sleep(miliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
