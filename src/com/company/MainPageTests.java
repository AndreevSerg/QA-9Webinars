package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTests extends TestBase{

    @Test(priority = 2)
    public void changeLanguageTest(){
        selectLanguage("ru");
        clickOnGoButton();
        String text = getViewBasketButtonText();
        Assert.assertEquals(text, "Посмотреть корзину", "Text not valid");
    }

    @Test(priority = 1)
    public void changeLanguageTest2(){
        selectLanguage("ru");
        clickOnGoButton();
        WebElement goButton = driver.findElement(By.cssSelector("button.btn.btn-default[type=\"submit\"]"));
        waitUntilAllElementContainsText("Выполнить", goButton, 20);
        String text = getViewBasketButtonText();
        Assert.assertEquals(text, "Посмотреть корзину", "Text not valid");
    }

    private String getViewBasketButtonText() {
        WebElement basketButton = driver.findElement(By.className("btn-group"));
        String text = basketButton.getText();
        return text;
    }

    private void clickOnGoButton() {
        WebElement submitLangButton = driver.findElement(By.cssSelector("button.btn.btn-default[type=\"submit\"]"));
        submitLangButton.click();
    }

    private Select selectLanguage(String lang) {
        Select langDropDown = new Select(driver.findElement(By.name("language")));
       // langDropDown.selectByIndex(2);
        //langDropDown.selectByVisibleText(lang);
        //langDropDown.deselectByVisibleText("suomi");
        langDropDown.selectByValue(lang);
        System.out.println(langDropDown.getAllSelectedOptions().get(0));
        return langDropDown;
    }

}
