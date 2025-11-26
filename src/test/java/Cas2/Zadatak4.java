package Cas2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
    public static void main (String[] args) throws InterruptedException {

        //Otici na neki pretrazivac
        //Zatim ukucati "Wikipedia" u polje za pretragu
        // Odraditi pretragu i otvoriti stranicu
        // Na stranici Wikipedia pretraziti "Nikola Tesla"

        WebDriverManager.chromedriver().setup();
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.navigate().to("https://duckduckgo.com/");

        Thread.sleep(3000);
        WebElement search = browser.findElement(By.id("searchbox_input"));
        search.sendKeys("Wikipedia");
        Thread.sleep(3000);
        WebElement searchButton = browser.findElement(By.cssSelector(".iconButton_button__A_Uiu.searchbox_searchButton__LxebD"));
        searchButton.click();
        WebElement wikipedia = browser.findElement(By.cssSelector("a[data-testid='result-title-a']"));
        wikipedia.click();
        Thread.sleep(3000);
        WebElement searchwiki = browser.findElement(By.id("searchInput"));
        searchwiki.sendKeys("Nikola Tesla");
        Thread.sleep(2000);
        WebElement wikiButton = browser.findElement(By.cssSelector(".pure-button.pure-button-primary-progressive"));
        wikiButton.click();

        // stale element - ne moze da se pronadje element jer se stranica promenila. Kada hocemo da iskoristimo
        // isti element 2 puta na razlicitim strnanama




    }
}
