package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class CrudAppTestSuite {
    private static final String XPATH_AJAX_PART = "//select[1]";
    private static final String BASE_URL = "https://slawomirr.github.io";
    private WebDriver driver;
    private Random generator;

    @Before
    public void initTest() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
        while (!driver.findElement(By.xpath(XPATH_AJAX_PART)).isDisplayed()) {
            try {
                driver.navigate().refresh();
                Thread.sleep(5_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @After
    public void cleanUpAfterTest() {
        driver.close();
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
        System.out.println(" ===> taskName: " + taskName);
        System.out.println(" ===> taskContent: " + taskContent);

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) {
        driver.navigate().refresh();
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (!driver.findElement(By.xpath(XPATH_AJAX_PART)).isDisplayed()) ;

        driver.findElements(By.xpath("//div[@class=\"datatable__tasks-container\"]/*")).stream()
                .filter(anyForm -> anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                        .getText().equals(taskName))
                .forEach(anyForm -> System.out.println(anyForm
                        .getText()));

        driver.findElements(By.xpath("//div[@class=\"datatable__tasks-container\"]/*")).stream()
                .filter(anyForm -> anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                        .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectBoard = theForm.findElement(By.xpath("./div/fieldset[2]/select[1]"));
                    System.out.println(selectBoard.getText());
                    (new Select(selectBoard)).selectByValue("5a9ef8cacec866c4ed4448d1");

                    try {
                        Thread.sleep(2_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    WebElement selectList = theForm.findElement(By.xpath("./div/fieldset[2]/select[2]"));
                    System.out.println(selectList.getText());
                    (new Select(selectList)).selectByValue("5a9f052fc31ef828f00e4fbd");

                    WebElement buttonCreateCard = theForm.findElement(By.xpath("./div/fieldset[2]/button"));
                    System.out.println(buttonCreateCard.getText());
                    buttonCreateCard.click();
                });
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean checkTaskExistsInTrello(String taskName) {
        final String TRELLO_URL = "https://trello.com/b/r3PFBoTh/kodilla-application";
        boolean result;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverTrello.get(TRELLO_URL);

        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        result = driverTrello.findElements(By.xpath("//*[@id=\"board\"]/*")).stream()
                .filter(theSpan -> theSpan.getText().contains(taskName))
                .collect(Collectors.toList())
                .size() > 0;

        driverTrello.close();
        return result;
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
        //ToDo clean up
    }
}
