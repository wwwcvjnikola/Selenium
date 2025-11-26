package Domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AmazonDragoljub {
    public static void main (String[] args){

        //Domaci:
        //Testirati dodavanje knjige u korpu i da li se knjiga obrise kada obrisete kolacice.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2");

        // Ovaj deo je bitan u ovom momentu jer se nekada prikaze poruka pre odlaska na stranicu
        // Iz razloga sto se nekad pojavi, a nekad ne, stavljamo try catch blok
        try {
            WebElement continueButton = driver.findElement(By.cssSelector("button[type='submit']"));
            continueButton.click();
        } catch (Exception e) {

        }

        // Pre pocetka testa zelim da proverim da li je korpa prazna
        // da ne dodjem u situaciju da je korpa puna, ne radi dugme za dodavanje
        // i meni prodje test jer bih ocitao nesto u korpi

        // Prvo proveravam da li je broj na korpi 0
        WebElement cartNumberBeforeAddingItem = driver.findElement(By.id("nav-cart-count"));
        Assert.assertEquals(cartNumberBeforeAddingItem.getText(), "0");

        // Zatim cu da kliknem na korpu i da proverim da li je prazna
        WebElement cartButtonBeforeAddingItem = driver.findElement(By.id("nav-cart"));
        cartButtonBeforeAddingItem.click();
        WebElement emptyCartMessage = driver.findElement(By.id("sc-empty-cart"));
        Assert.assertTrue(emptyCartMessage.isDisplayed());

        // Vracam se korak unazad kada se uverim da je korpa prazna
        driver.navigate().back();

        // Takodje kada proveravam korpu zelim da proverim da li sam dodao bas tu knjigu koju sam hteo
        // Iz tog razloga je potrebno da na ovom koraku pronadjem naziv knjige i sacuvam u string koji
        // cu kasnije koristiti za asertaciju
        WebElement itemTitle = driver.findElement(By.id("productTitle"));
        String expectedItemTitle = itemTitle.getText();

        // Dodajem proizvod u korpu
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        // Proveravam poruku da li pise da je uspesno dodata knjiga u korpu
        WebElement addedToCartMessage = driver.findElement(By.id("NATC_SMART_WAGON_CONF_MSG_SUCCESS"));
        Assert.assertTrue(addedToCartMessage.isDisplayed());

        // Proveravam da li se broj na korpi sada promenio na 1
        WebElement cartNumberAfterAddingItem = driver.findElement(By.id("nav-cart-count"));
        Assert.assertEquals(cartNumberAfterAddingItem.getText(), "1");

        WebElement cartButton = driver.findElement(By.id("nav-cart"));
        cartButton.click();

        // Proveravam da li postoji knjiga u korpi
        WebElement itemInCart = driver.findElement(By.className("sc-list-item-content"));
        Assert.assertTrue(itemInCart.isDisplayed());

        // Proveravam da li je bas dodata knjiga u korpi, a ne neka druga knjiga
        WebElement itemTitleInCart = driver.findElement(By.className("a-truncate-cut"));
        Assert.assertEquals(itemTitleInCart.getText(), expectedItemTitle);

        // Nakon toga na stranici cu da otvorim dev tools (desni klik -> inspect) i na tabu
        // 'Application' cu da trazim koji cookie treba da obrisem da bi se knjiga obrisala iz korpe
        // Na poslu bih pitao developere koji cookie brise korpu, ali svakako nema previse
        // cookie opcija pa sam resio da pokusam jedan po jedan cookie da obrisem
        // session cookie se vezuje za sesiju i trebalo bi da obrise sve radnje koje nisu sacuvane
        // tokom sesije
        driver.manage().deleteCookieNamed("session-id");
        driver.navigate().refresh();

        // Kada obrisem pravi cookie onda cu da proverim da li je korpa sada ponovo prazna
        WebElement cartNumberAfterRemovingItem = driver.findElement(By.id("nav-cart-count"));
        Assert.assertEquals(cartNumberAfterRemovingItem.getText(), "0");

        WebElement emptyCartAfterRemovingItemMessage = driver.findElement(By.id("sc-empty-cart"));
        Assert.assertTrue(emptyCartAfterRemovingItemMessage.isDisplayed());

        driver.quit();

    }
}
