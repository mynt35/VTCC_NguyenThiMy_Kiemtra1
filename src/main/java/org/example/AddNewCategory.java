package org.example;

import static org.testng.AssertJUnit.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class AddNewCategory extends BaseTest {
    @Test (priority = 1)
    public void AddNew() throws Exception {

        //Mở trang cms.anhtester.com
        driver.get("https://cms.anhtester.com/login");
        Thread.sleep(5000);

        //Nhập username và password
        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        driver.findElement(By.id("email")).sendKeys("admin@example.com");
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("123456");
        Thread.sleep(1000);

        //Click nút Login
        driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/form/button")).click();


        // Add new category
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/li[2]/a/span[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/li[2]/ul/li[8]/a/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Add New category")).click();
        Thread.sleep(3000);
        //name
        driver.findElement(By.id("name")).sendKeys("Flowers");
        Thread.sleep(3000);
        // Parent Category
        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div/div/div/div[2]/form/div[2]/div/div/button/div/div/div")).click();
        Thread.sleep(2000);
        //--demo in category
        driver.findElement(By.xpath("//*[@id=\"bs-select-1-4\"]/span")).click();
        Thread.sleep(3000);
        //Ordering Number
        driver.findElement(By.id("order_level")).sendKeys("18");
        Thread.sleep(3000);
        // Click  Type
        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div/div/div/div[2]/form/div[4]/div/div/button/div/div/div")).click();
        Thread.sleep(3000);
        // Chọn Digital
        driver.findElement(By.xpath("//*[@id=\"bs-select-2-1\"]/span")).click();
        Thread.sleep(3000);
        //Meta Title
        driver.findElement(By.cssSelector("[placeholder = 'Meta Title']")).sendKeys("listing");
        Thread.sleep(3000);
        //Meta Description
        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div/div/div/div[2]/form/div[8]/div/textarea")).sendKeys("listing");
        Thread.sleep(3000);

        //Filtering Attributes
        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div/div/div/div[2]/form/div[9]/div/div/button")).click();
        Thread.sleep(3000);
        //Chọn capacity
        driver.findElement(By.xpath("//*[@id=\"bs-select-3-2\"]/span[2]")).click();
        Thread.sleep(3000);
        //Chọn Save
        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div/div/div/div[2]/form/div[10]/button")).click();
        Thread.sleep(3000);
        // Search category vừa tạo(Flowers) để verify kết quả
        WebElement src_category = driver.findElement(By.id("search"));
        src_category.sendKeys("Flowers");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.RETURN);
        action.perform();
        Thread.sleep(3000);
        WebElement searchresult = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/table/tbody/tr/td[2]"));
        Assert.assertTrue(searchresult.getText().contains("Flowers"));
    }
}

