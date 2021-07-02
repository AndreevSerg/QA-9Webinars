package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class OscarProductTests extends TestBase{
    @Test
    public void addProductToBasketTest() throws InterruptedException {
        selectBooksCategory();
        Assert.assertTrue(isItBooksPage());
        List<WebElement> productList = driver.findElements(By.className("product_pod"));
        String firstBookName = productList.get(0).findElement(By.tagName("h3")).getText();
        String firstBookPrice = productList.get(0).findElement(By.cssSelector(".product_price .price_color")).getText();
        System.out.println(firstBookPrice);
        addToBasketFirstBook();
        Assert.assertTrue(alertsIsPresent());
        List<WebElement> alertsData =  driver.findElements(By.cssSelector(".alert strong"));
        Assert.assertTrue(isItFirstBookName(firstBookName, alertsData));
        Thread.sleep(5000);
        Assert.assertTrue(isItFirstBookPrice(firstBookPrice, alertsData));

    }

    @Test
    public void countProductInBasketTest() throws InterruptedException {
        selectBooksCategory();
        addToBasketFirstBook();
        driver.navigate().refresh();
        Thread.sleep(3000);
        addToBasketFirstBook();
        clickOnViewBasketButton();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement pageTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'Basket')]")));
        Assert.assertTrue(pageTitle.isDisplayed());
        Assert.assertTrue(driver.getCurrentUrl().contains("/basket/"));
        int count = getProductCountBasket();
        Assert.assertTrue(count==2);


    }

    @Test
    public void productListShouldBeVisible(){
        selectBooksCategory();
        List<WebElement> images = driver.findElements(By.className("image_container"));
        waitUntilAllElementsVisible(images, 20);
        int size = images.size();
        Assert.assertEquals(size, 20, "Quantity of items are not in value");

    }

    private int getProductCountBasket() {
      return Integer.parseInt(driver.findElement(By.id("id_form-0-quantity")).getAttribute("Value"));
    }

    private void clickOnViewBasketButton() {
        driver.findElement(By.cssSelector(".btn-group a.btn.btn-default"));
    }

    private boolean isItFirstBookPrice(String firstBookPrice, List<WebElement> alertsData) {
        System.out.println(alertsData.get(2).getText());
       return alertsData.get(2).getText().equals(firstBookPrice);
    }

    private boolean isItFirstBookName(String firstBookName, List<WebElement> alertsData) {
       return alertsData.get(0).getText().equals(firstBookName);
    }

    private boolean alertsIsPresent() {
        return driver.findElements(By.className("alert")).size() == 3;
    }

    private void addToBasketFirstBook() {
        List<WebElement> productList = driver.findElements(By.className("product_pod"));
        productList.get(0).findElement(By.cssSelector(".product_pod [type=\"submit\"]")).click();
    }

    private boolean isItBooksPage() {
       return driver.findElement(By.className("page-header")).getText().contains("Books");
    }

    private void selectBooksCategory() {
        driver.findElement(By.className("dropdown-submenu")).click();
    }
}
