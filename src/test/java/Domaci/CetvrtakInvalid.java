package Domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CetvrtakInvalid {
    public static void main (String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");

        // Primer sa invalid kredencijalima
        String invalidUserName = "Nikola";
        String validPsswd = "secret_sauce";

        Thread.sleep(1000);
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.clear();
        usernameInput.sendKeys(invalidUserName);
        Thread.sleep(1000);
        WebElement psswdInput = driver.findElement(By.id("password"));
        psswdInput.clear();
        psswdInput.sendKeys(validPsswd);
        Thread.sleep(1000);
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();

        // provera da li smo ostali na login strani - URL

        String expectedUrl = "https://www.saucedemo.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

        // provera Error poruke - da li je prikazana i da li je tekst te poruke onaj koji treba da bude

        WebElement errorDisplayed = driver.findElement(By.cssSelector("div[class='error-message-container error']"));
        Assert.assertTrue(errorDisplayed.isDisplayed());
        System.out.println("Error poruka je prikazana: " + errorDisplayed.isDisplayed());
        System.out.println("--------------------------------------------");

        String expectedErrorText = "Epic sadface: Username and password do not match any user in this service";
        String actualErrorText = errorDisplayed.getText();
        Assert.assertEquals(actualErrorText, expectedErrorText);

        // da li su vidljive x ikone na UserName i Psswd poljima

        WebElement usernameIconX = driver.findElement(By.cssSelector("#user-name + svg"));
        WebElement psswdIconX = driver.findElement(By.cssSelector("#password + svg"));

        Assert.assertTrue(usernameIconX.isDisplayed());
        Assert.assertTrue(psswdIconX.isDisplayed());

        System.out.println("Ikona 'X' u Username polju: " + usernameIconX.isDisplayed());
        System.out.println("--------------------------------------------");
        System.out.println("Ikona 'X' u Psswd polju: " + psswdIconX.isDisplayed());

        // Malo sam cesljao po netu sto se tice dela kod cssSelector za polja. Posto ikone kao svg imaju identicne
        // kodove, trazio sam nacin kako preko parrent-a tj label-a u kome se nalaze da ih oznacim.
        // Ne znam koliko je ovo tacno sto sam odradio - parrent # oznacava ID + svg tag u child-u










    }
}
