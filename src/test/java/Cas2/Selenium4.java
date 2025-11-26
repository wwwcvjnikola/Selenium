package Cas2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium4 {
    public static void main (String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://duckduckgo.com/");

        //-----------------------

        // ID - jedinstven i stabilan
        // Name - posle ID-a najstabilniji i moze biti jedinstven
        // Class
        // CSS selector
        // Link Text - retko se pojavljuje i mora na elementu da postoji tekst u href tagu
        // Tag - koristi se kod pretrage webelementa unutar drugog webelementa
        // Relative xpath - Skracena verzija absolute xpath - dajemo input sa kojom putanjom se zavrsava xpath
        // Absolute xpath - Najnestabilniji jer vrsi pretragu od pocetka i svaka promena u html-u moze da poremeti pretragu

        //----------------------

        // Nije prakticno da svaki element samo trazimo i odmah uradimo akciju
        /*driver.findElement(By.xpath("//div[1]/div/textarea")).sendKeys("Wikipedia");
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/form/div[1]/div/textarea")).sendKeys(Keys.ENTER);*/
        // Umesto toga cemo praviti objekte za svaki element i moci da ih koristimo ponovo

        Thread.sleep(3000);
        WebElement searchBox = driver.findElement(By.id("searchbox_input"));
        searchBox.sendKeys("Wikipedia");
        WebElement searchButton = driver.findElement(By.cssSelector("button[type='submit']"));
        searchButton.click();
        Thread.sleep(3000);
        WebElement wikipediaButton = driver.findElement(By.cssSelector("a[data-testid='result-title-a']"));
        wikipediaButton.click();


        // Kada trazimo element preko klase, taj atribut 'class' mora da ima samo jednu vrednost
        // odnosno, vrednost unutar te klase ne sme da sadrzi razmak
        // U slucaju da hocete da nadjete element bas preko te klase potrebno je da
        // 1) umesto razmaka upisete tacku
        // 2) upisete tacku na pocetku vrednosti
        // 3) promenite pretragu sa By.className na By.cssSelector

        WebElement klasaKojaNeMozeDaSeNadje = driver.findElement(By.className("iconButton_button__A_Uiu searchbox_searchButton__LxebD"));
        WebElement kakoNapravitiCssOdKlase = driver.findElement(By.cssSelector(".iconButton_button__A_Uiu.searchbox_searchButton__LxebD"));

        // Ako trazite element preko klase koja u vrednosti ima razmak
        // dobicete gresku u konzoli gde pise Compound classes not permitted

        // Ako dobijete gresku u konzoli Unable to locate element
        // Ukazuje na dva moguca problema
        // 1) Driver nije sacekao da se ucita ceo html pre nego sto je krenuo u pretragu
        // Resenje: Dodati cekanje pre te linije koda
        // 2) Lokator nije stabilan/jedinstven/vidljiv
        // Resenje: Promeniti lokator


    }


}
