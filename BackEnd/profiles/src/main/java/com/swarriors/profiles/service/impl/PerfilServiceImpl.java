package com.swarriors.profiles.service.impl;

import com.swarriors.profiles.dto.PerfilDto;
import com.swarriors.profiles.model.test;
import com.swarriors.profiles.service.PerfilService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PerfilServiceImpl implements PerfilService {

    @Override
    public PerfilDto crearPerfil(String url) {
        return null;
    }

    @Override
    public String test(test str) {
        String s = "";
        System.setProperty("webdriver.chrome.driver","D:\\2022\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://linkedin.com/uas/login");
        WebElement username = driver.findElementById("username");
        username.sendKeys("droidmaniaco25@gmail.com");
        WebElement password = driver.findElementById("password");
        password.sendKeys("prueba123");
        driver.findElementByXPath("//button[@type='submit']").click();
        driver.get(str.getNum());
        // Nombre Completo
        String name = driver.findElement(By.tagName("h1")).getAttribute("innerHTML");
        System.out.println(name);
        // Trabajo Actual
        String work = driver.findElement(By.xpath("//div[@class=\"text-body-medium break-words\"]")).getAttribute("innerHTML");
        System.out.println(work);
        // Experiencia
        try {
            WebElement exp = driver.findElementById("experience-section");
            String c = driver.findElement(By.className("pv-entity__summary-info pv-entity__summary-info--background-section")).getAttribute("textContent");
            String[] asd = c.split(" ",0);
            for (String e: asd) {
                System.out.println(e);
            }
            //System.out.println(c);
        } catch(Exception e) {}


//        List<WebElement> el = driver.findElements(By.xpath("//h3[@class=\"t-16 t-black t-bold\"]"));
//        List<WebElement> al = driver.findElements(By.xpath("//p[@class=\"pv-entity__secondary-title t-14 t-black t-normal\"]"));
//        String com = "", com2 = "";
//        String a = driver.findElement(By.xpath("//section[@id=\"experience-section\"]")).getAttribute("textContent");
//        System.out.println(a);
//        int i = 0;
//        System.out.println("Experiencia\n");
//        for (WebElement e: el) {
//            com = el.get(i).getAttribute("textContent");
//            com2 = al.get(i).getAttribute("textContent");
//            i += 1;
//            System.out.println(com + com2);
//        }
//        // educacion
//        List<WebElement> ed = driver.findElements(By.xpath("//h3[@class=\"pv-entity__school-name t-16 t-black t-bold\"]"));
//        List<WebElement> ad = driver.findElements(By.xpath("//p[@class=\"pv-entity__secondary-title pv-entity__degree-name t-14 t-black t-normal\"]//span[@class=\"pv-entity__comma-item\"]"));
//        List<WebElement> od = driver.findElements(By.xpath("//p[@class=\"pv-entity__dates t-14 t-black--light t-normal\"]//span//following::time"));
//        String dom = "", dom2 = "", dom3 = "";
//        i = 0;
//        System.out.println("Educacion\n");
//        for (WebElement e: ed) {
//            dom = ed.get(i).getAttribute("textContent");
//            dom2 = ad.get(i).getAttribute("textContent");
//            dom3 = od.get(i).getAttribute("textContent");
//            i += 1;
//            System.out.println(dom + dom2 + dom3);
//        }
        s = "ok";
        return s;
    }
}
