package Cas4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Selenium8 {
    public static void main (String[] args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        // Kad se suocim sa elementima koji nisu jedinstveni, mogu da ih pronadjem sve
        // da ih ubacim u listu i iz te liste da izvlacim elemente po indexu

        // U ovom slucaju sam hteo da kliknem na dugme Forms ali ono ima isti lokator
        // kao dugme Elements
        /*WebElement elementsButton = driver.findElement(By.className("card-body"));
        elementsButton.click();
        WebElement formsButton = driver.findElement(By.className("card-body"));
        formsButton.click();*/

        // U tom slucaju cu samo napraviti listu koja ce naci sve elemente sa tim lokatorom
        List<WebElement> listOfButtons = driver.findElements(By.className("card-body"));
        // Mogu da prosledim direktno index liste i da kazem programu da klikne bas na taj element
        //listOfButtons.get(1).click();

        // Ali sta da radim ako ne znam da li ce element uvek biti na toj poziciji?
        // Zato pravim petlju koja ce:
        // 1) proci kroz svaki element iz liste
        // 2) izvuci tekst iz svakog tog elementa
        // 3) uporediti taj tekst sa zeljenim tekstom
        // 4) ako je uslov ispunjen onda ce da uradi klik
        // Posle klika obavezno dodati break komandu da bi se petlja prekinula
        // U suprotnom ce klik da se odradi, a petlja ce nastaviti da trazi dalje elemente
        for (int i = 0; i < listOfButtons.size(); i++) {
            if (listOfButtons.get(i).getText().equals("Widgets")) {
                listOfButtons.get(i).click();
                break;
            }
        }

        //----------------Korak po korak

        // Treba mi lista koja ce proci kroz sve elemente u listi

        for (int i = 0; i < listOfButtons.size(); i++) {

        }

        // Posto program unapred zna koja je velicina liste,
        // mozemo da iskoristimo taj broj i da kazemo da se do tog broja izvrsava petlja
        // Ako lista ima 5 elemenata onda ce listOfButtons.size() biti 5

        //-----------------

        // Ako hocu da dohvatim neki element iz liste napisacu

        listOfButtons.get(0).getText();
        listOfButtons.get(1).getText();
        listOfButtons.get(2).getText();

        // Ovo mogu da uradim za svaki element
        // Posto se u petlji promenljiva i krece od 0 do 5
        // Mogu da ubacim tu promenljivu u uslov

        //listOfButtons.get(i).getText();

        //--------------------

        // Mogu da napravim uslov koji ce da proverava tekst elementa i ako je uslov ispunje
        // da uradi odredjenu akciju

        if (listOfButtons.get(0).getText().equals("Elements")) {
            listOfButtons.get(0).click();
        }

        // Ovde sam napravio uslov koji kaze:
        // Proveri mi tekst PRVOG elementa iz liste
        // Ako je tekst jednak 'Elements' onda uradi klik na to dugme

        //----------------------

        // Sad cemo da sve spojimo

        for (int i = 0; i < listOfButtons.size(); i++) {
            // Otvaramo petlju koja ce se ici na svaki element iz liste

            // Pravimo uslov gde ce i prvo biti 0 i proveriti prvi element u listi
            // Ako uslov nije ispunjen onda ce petlja da krene ispocetka
            // Proverice za naredni element gde je i jednako 1
            // Ako uslov opet nije ispunjen ide dalje
            // ...

            if (listOfButtons.get(i).getText().equals("Elements")) {
                // Kad dodje do elementa koji ispunjava uslov
                // tek tad ce se otvoriti ovaj blok koda i uraditi akcija klika
                // I to na koji element klik?
                // Bas na onaj koji zadovoljava uslov
                // Odnosno element koji ima index i
                listOfButtons.get(i).click();

                // Nakon toga dodati break kako bi program izasao iz petlje
                break;
            }
        }


    }
}
