package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class App 
{
    public static void main(String[] args)
    {
        // Setup driver automatically
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();


        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // Optional (use if GUI issues)
        // options.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        System.out.println("Login successful!");
    }
}
