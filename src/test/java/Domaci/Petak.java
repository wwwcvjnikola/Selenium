package Domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Petak {
   public static void main(String[] args) {

       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       driver.manage().window().maximize();
       driver.navigate().to("https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/");
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       // Dodavanje knjige u Cart
       WebElement addToCartBtn = driver.findElement(By.id("add-to-cart-button"));
       wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
       addToCartBtn.click();

       // odlazimo na Cart kako bismo proverili da je knjiga dodata
       WebElement cartIcon = driver.findElement(By.id("nav-cart-count-container"));
       wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
       cartIcon.click();

       // provera da li je naziv knjige i pisca na strani kao i rec Subtotal koji se nalazi u obracunu za cenu
       String bookTitle = "Selenium Framework Design in Data-Driven Testing";
       String authorName = "Carl Cocchiaro";
       String subtotal = "Subtotal";

       Assert.assertTrue(driver.getPageSource().contains(bookTitle), "Naslov knjige nije pronadjen");
       Assert.assertTrue(driver.getPageSource().contains(authorName), "Ime autora nije na strani");
       Assert.assertTrue(driver.getPageSource().contains(subtotal), "Nemamo subtotal dugme");

       // provera Cart URL-a
       String expectedURL = "https://www.amazon.com/gp/cart/view.html?ref_=nav_cart";
       Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

       // Ako mi izadje prozor za nastavak kupovine kada pokrenemo kod, da zaobidjemo to. Idem po klasi proverio
       // sam da li je jedinstven class

       try {
           WebElement continueShoppingBtn = driver.findElement(By.className("a-button-text"));
           if (continueShoppingBtn.isDisplayed()) {
               continueShoppingBtn.click();
           }
       } catch (Exception e){
       }

       // brisanje cookies-a

       driver.manage().deleteAllCookies();
       driver.navigate().refresh();

       // ponovno testiranje bookTitle i authoreName kako bismo proverili da li je knjiga i dalje u korpi
       // nakon brisanja cookies-a. Posto sam na primeru video da je ispravno da nakon brisanja cookies-a
       // ne bude nista u korpi icicu sa asertacijom gde cu gledati false kao ispravno da mi ne izbaci error.

       Assert.assertFalse(driver.getPageSource().contains(bookTitle), "Knjiga je i dalje u korpi");
       Assert.assertFalse(driver.getPageSource().contains(authorName), "Knjiga je i dalje u korpi");

       if (!driver.getPageSource().contains(bookTitle)) {
           System.out.println("Knjiga se vise ne nalazi u korpi nakon brisanja cookies-a");
       }

















    }
}
