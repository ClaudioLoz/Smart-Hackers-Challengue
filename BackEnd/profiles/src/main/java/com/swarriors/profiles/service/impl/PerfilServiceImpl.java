package com.swarriors.profiles.service.impl;

import com.swarriors.profiles.model.*;
import com.swarriors.profiles.service.PerfilService;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
@Transactional
@AllArgsConstructor
public class PerfilServiceImpl implements PerfilService {

    private final ChromeDriver driver;

    private String formattingString (String cadena) {
        cadena = cadena.replaceAll("\n","");
        cadena = cadena.replaceAll("\\s+", " ");
        cadena = cadena.replaceAll("\\s+", " ");
        cadena = cadena.replaceAll("&amp;", "");
        return cadena;
    }

    private void scrollSlowly(Integer ocurrences, Integer duration) throws InterruptedException {
        String scroll = "window.scrollBy", cad;
        Integer init = 0, end = 750;
        for (Integer i=0; i<ocurrences; i++) {
            cad = scroll + "(" + init.toString() + "," + end.toString() + ")";
            ((JavascriptExecutor) driver).executeScript(cad, "");
            init = end;
            end += 750;
            TimeUnit.SECONDS.sleep(duration);
        }
    }


    @Override
    public Perfil crearPerfil(URL url) throws InterruptedException {

        Perfil perfil = new Perfil();
        String link = url.getUrl();

        driver.get(link);
        scrollSlowly(5,3);

        perfil.setCertificaciones(new ArrayList<>());
        perfil.setExperiencias(new ArrayList<>());
        perfil.setVoluntariado(new ArrayList<>());
        perfil.setEducacion(new ArrayList<>());
        perfil.setSkills(new ArrayList<>());

        try {
            List<WebElement> bts = driver.findElementsByXPath("//button[starts-with(@class,\"pv-profile-section__see-more-inline pv-profile-section__text-truncate-toggle\")]");
            for(WebElement bt: bts) {
                bt.click();
            }
        }catch (Exception e) {
            //System.out.println("No hay botones");
        }

        try {
            perfil.setLinkLinkedin(link);

            String name = driver.findElement(By.tagName("h1")).getAttribute("innerHTML");
            perfil.setNombre(name);

            String work = driver.findElement(By.xpath("//div[@class=\"text-body-medium break-words\"]")).getAttribute("innerHTML");
            perfil.setTrabajoActual(formattingString(work));

            String place = driver.findElement(By.xpath("//span[@class=\"text-body-small inline t-black--light break-words\"]")).getAttribute("innerHTML");
            perfil.setResidencia(formattingString(place));
        } catch (Exception e) {
            System.out.println("Error en el link");
        }

        setExperience(perfil);
        setEducation(perfil);
        setVoluntariados(perfil);
        setSkills(perfil);
        setIntereses(perfil);

        return perfil;
    }

    private void setEducation (Perfil perfil) {
        try {
            Integer oc = driver.findElements(By.xpath("(//li[@class=\"pv-profile-section__list-item pv-education-entity pv-profile-section__card-item ember-view\"])")).size();
            String ied = "(//li[@class=\"pv-profile-section__list-item pv-education-entity pv-profile-section__card-item ember-view\"])";
            String fed = "/descendant::h3";
            String const1 = "/descendant::span[2]";
            String const2 = "/descendant::p[@class=\"pv-entity__dates t-14 t-black--light t-normal\"]/span[2]";
            String educ;
            List<Educacion> eds = new ArrayList<>();
            for(Integer i=1; i<=oc; i++) {
                educ = ied + "[" + i.toString() + "]";
                Educacion ed = new Educacion();
                ed.setCentroEducativo(formattingString(driver.findElement(By.xpath(educ + fed)).getAttribute("textContent")));
                ed.setGrado(formattingString(driver.findElement(By.xpath(educ + const1)).getAttribute("textContent")));
                ed.setPeriodo(formattingString(driver.findElement(By.xpath(educ + const2)).getAttribute("textContent")));
                eds.add(ed);
            }
            perfil.setEducacion(eds);
        } catch (Exception e) {
            System.out.println("No education found");
        }

    }

    private void setExperience (Perfil perfil) {
        try {
            Integer oc = driver.findElements(By.xpath("//section[@class=\"pv-profile-section__card-item-v2 pv-profile-section pv-position-entity ember-view\"]")).size();
            String iexp = "(//section[@class=\"pv-profile-section__card-item-v2 pv-profile-section pv-position-entity ember-view\"])";
            String fexp = "/descendant::li";
            String const1 = "/div/div[@class=\"display-flex flex-column full-width\"]";
            String const2 = "/div/a";
            String const3 = "/descendant::span[2]";
            String const4 = "/descendant::p[2]";
            String const5 = "/descendant::span[3]";
            String const6 = "/descendant::span[5]";
            String const7 = "/descendant::h3";
            String exp;
            List<Experiencia> exps = new ArrayList<>();
            for (Integer i = 1; i <= oc; i++) {
                exp = iexp + "[" + i.toString() + "]";
                Experiencia ex = new Experiencia();
                List<Cargo> lc = new ArrayList<>();
                try {
                    String a = driver.findElement(By.xpath(exp + const1)).getAttribute("innerHTML");
                    String comp = driver.findElement(By.xpath(exp + const1 + const4)).getAttribute("textContent");
                    Cargo ca = new Cargo();
                    ex.setCompania(formattingString(comp));
                    ca.setCargo(formattingString(driver.findElement(By.xpath(exp + const1 + const7)).getAttribute("textContent")));
                    ca.setPeriodo(formattingString(driver.findElement(By.xpath(exp + const1 + const5)).getAttribute("textContent")));
                    lc.add(ca);
                    ex.setCargo(lc);
                } catch (Exception e) {
                    String a = driver.findElement(By.xpath(exp + const2)).getAttribute("innerHTML");
                    ex.setCompania(driver.findElement(By.xpath(exp + const2 + const3)).getAttribute("textContent"));
                    Integer ac = driver.findElements(By.xpath(exp + fexp)).size();
                    for (Integer k = 1; k <= ac; k++) {
                        Cargo ca = new Cargo();
                        ca.setCargo(formattingString(driver.findElement(By.xpath(exp + fexp + "[" + k.toString() + "]" + const5)).getAttribute("textContent")));
                        ca.setPeriodo(formattingString(driver.findElement(By.xpath(exp + fexp + "[" + k.toString() + "]" + const6)).getAttribute("textContent")));
                        lc.add(ca);
                    }
                    ex.setCargo(lc);
                }
                exps.add(ex);
            }
            perfil.setExperiencias(exps);
        } catch (Exception e) {
            System.out.println("No experience Found");
        }
    }

    private void setVoluntariados (Perfil perfil) {
        try {
            Integer oc = driver.findElements(By.xpath("(//section[@class=\"pv-profile-section volunteering-section ember-view\"])/descendant::li")).size();
            String ied = "(//section[@class=\"pv-profile-section volunteering-section ember-view\"])/descendant::li";
            String at1 = "/descendant::h3";
            String at2 = "/descendant::span[2]";
            String at3 = "/descendant::h4[2]/span[2]";
            String at4 = "/descendant::h4[4]/span[2]";
            String vstr;
            List<Voluntariado> vs = new ArrayList<>();
            for(Integer i=1; i<=oc; i++) {
                vstr = ied + "[" + i.toString() + "]";
                Voluntariado v = new Voluntariado();
                v.setRol(formattingString(driver.findElement(By.xpath(vstr + at1)).getAttribute("textContent")));
                v.setOrganizacion(formattingString(driver.findElement(By.xpath(vstr + at2)).getAttribute("textContent")));
                v.setPeriodo(formattingString(driver.findElement(By.xpath(vstr + at3)).getAttribute("textContent")));
                v.setCausa(formattingString(driver.findElement(By.xpath(vstr + at4)).getAttribute("textContent")));
                vs.add(v);
            }
            perfil.setVoluntariado(vs);
        } catch (Exception e) {
            System.out.println("No voluntariados found");
        }
    }

    private void setSkills (Perfil perfil) {
        try {
            Integer oc = driver.findElements(By.xpath("(//section[@class=\"pv-profile-section pv-skill-categories-section artdeco-card mt4 p5 ember-view\"])/descendant::ol[@class=\"pv-skill-categories-section__top-skills pv-profile-section__section-info section-info pb1\"]/li")).size();
            String ied = "(//section[@class=\"pv-profile-section pv-skill-categories-section artdeco-card mt4 p5 ember-view\"])/descendant::ol[@class=\"pv-skill-categories-section__top-skills pv-profile-section__section-info section-info pb1\"]/li";
            String c = "/descendant::span";
            String sk;
            List<String> sks = new ArrayList<>();
            for(Integer i=1; i<=oc; i++) {
                sk = ied + "[" + i.toString() + "]";
                sks.add(formattingString(driver.findElement(By.xpath(sk + c)).getAttribute("textContent")));
            }
            perfil.setSkills(sks);
        } catch (Exception e) {
            System.out.println("No skills found");
        }
    }


    private void setIntereses (Perfil perfil) {
        try {
            Integer oc = driver.findElements(By.xpath("(//section[@class=\"pv-profile-section pv-interests-section artdeco-card mt4 p5 ember-view\"])/descendant::li")).size();
            String ied = "(//section[@class=\"pv-profile-section pv-interests-section artdeco-card mt4 p5 ember-view\"])/descendant::li";
            String c = "/descendant::span";
            String is;
            List<String> iss = new ArrayList<>();
            for(Integer i=1; i<=oc; i++) {
                is = ied + "[" + i.toString() + "]";
                iss.add(formattingString(driver.findElement(By.xpath(is + c)).getAttribute("textContent")));
            }
            perfil.setIntereses(iss);
        } catch (Exception e) {
            System.out.println("No intereses found");
        }
    }

}
