package com.company;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;


    @BeforeMethod
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://selenium1py.pythonanywhere.com/en-gb/");
    }


    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    void waitUntilElementClickable(WebElement element, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void waitUntilElementVisible (WebElement element, int time){
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    void waitUntilElementInVisible (WebElement element, int time){
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    void waitUntilAllElementsVisible (List<WebElement> elements, int time){
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfAllElements(elements));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    void waitUntilAllElementContainsText (String text, WebElement element, int time){
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
