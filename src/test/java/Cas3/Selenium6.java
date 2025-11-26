package Cas3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Selenium6 {
    public static void main (String[] args) throws InterruptedException {

        // Sleepers - ceka onoliko vremena koliko zadamo dok ne nastavi dalje sa radom
        // Implicit wait - ceka odredjeno vreme dok se ne pojavi element
        // Explicit wait - ceka dok se ne ispuni odredjen uslov
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://wordpress.com/");

        // U ovoj liniji koda zadajemo komandu da driver ceka maksimalno 30 sekundi
        // da se pojavi neki element
        // Odnosno ceka najvise 30 sekundi pre nego sto vrati gresku "NoSuchElementException"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebElement logInButton = driver.findElement(By.linkText("Log in"));
        logInButton.click();

        String validUsername = "cvjnikola";
        String validPassword = "N&K20052020";
        WebElement usernameField = driver.findElement(By.id("usernameOrEmail"));
        usernameField.clear();
        usernameField.sendKeys(validUsername);

        WebElement continueButton = driver.findElement(By.cssSelector("button[type='submit']"));
        continueButton.click();

        //Thread.sleep(3000);
        // Da bismo koristili Explicit wait moramo prvo da napravimo objekat za cekanje
        // Tom objektu takodje dodeljujemo vreme koliko ce najduze da se ceka da se uslov ispuni
        // Ako se uslov ne ispuni za dato vreme onda ce program da vrati gresku
        // Ovaj objekat uglavnom pisemo na pocetku projekta, nakon inicijalizacije drivera
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Kad kreiramo objekat za cekanje onda mozemo da biramo koji uslov treba da se ispuni
        // da bi se zavrsilo cekanje
        // Najcesce cemo birati:
        // visibilityOf (cekamo da se element pojavi)
        // urlToBe (cekamo da se URL promeni)
        // elementToBeClickable (cekamo da element postane klikabilan)
        // Kod ovih cekanja moramo da prosledimo i lokator za koji element ce se izvrsiti cekanje
        // Taj lokator MORA da bude pre kreiranja objekta
        // Jer ako se prvo napravi u ovom slucaju WebElement passwordField
        // i program ne nadje taj element
        // onda program i ne stigne do cekanja
        // Iz tog razloga je ovde redosled prvo wait pa onda WebElement passwordField
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("password"))));

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys(validPassword);

        continueButton.click();

        //Thread.sleep(5000);
        wait.until(ExpectedConditions.urlToBe("https://wordpress.com/home/dragoljubqa.wordpress.com"));

        String expectedURL = "https://wordpress.com/home/dragoljubqa.wordpress.com";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);

        WebElement welcomeMessage = driver.findElement(By.className("masterbar__item-howdy-howdy"));
        Assert.assertTrue(welcomeMessage.isDisplayed());

        Assert.assertTrue(welcomeMessage.getText().contains(validUsername));


    }
}
