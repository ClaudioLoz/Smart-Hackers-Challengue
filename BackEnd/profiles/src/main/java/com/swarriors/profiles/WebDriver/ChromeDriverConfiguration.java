package com.swarriors.profiles.WebDriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class ChromeDriverConfiguration {

    @PostConstruct
    void PostConstruct() {
        System.setProperty("webdriver.chrome.driver","D:\\2022\\chromedriver.exe");
    }

    @Bean
    public ChromeDriver driver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        DesiredCapabilities dcap = new DesiredCapabilities();
        dcap.setCapability("pageLoadStrategy", "normal");
        options.merge(dcap);
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://linkedin.com/uas/login");
        WebElement username = driver.findElementById("username");
        username.sendKeys("droidmaniaco25@gmail.com");
        WebElement password = driver.findElementById("password");
        password.sendKeys("prueba123");
        driver.findElementByXPath("//button[@type='submit']").click();
        return driver;
    }
}
