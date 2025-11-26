package Cas3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Zadatak7b {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();

        WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
        testLoginPageButton.click();

        String validUsername = "student";
        String validPassword = "Password123";

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        usernameField.clear();
        usernameField.sendKeys(validUsername);
        passwordField.clear();
        passwordField.sendKeys(validPassword);
        submitButton.click();

        //-------------------------------

        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);

        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/logged-in-successfully/");

        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logOutButton.isDisplayed());

        WebElement welcomeMessage = driver.findElement(By.className("post-content"));
        Assert.assertTrue(welcomeMessage.getText().contains(validUsername));

        //-------------------------------

        logOutButton.click();
        WebElement submitButtonAfterLogOut = driver.findElement(By.id("submit"));
        Assert.assertTrue(submitButtonAfterLogOut.isDisplayed());

        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");

        //WebElement logOutButtonAfterLogOut = driver.findElement(By.linkText("Log out"));
        //Assert.assertFalse(logOutButtonAfterLogOut.isDisplayed());

        // Kada zelimo da proverimo da li neki element NIJE PRISUTAN
        // ne mozemo tek tako da koristimo Assert.assertFalse(element)
        // jer program ce da vrati gresku da ne moze da pronadje element

        // Nacin da zaobidjemo ovaj problem je da koristimo try catch blok
        // Try deo ce uvek da pokusa da izvrsi deo koda ali ako ne uspe i ako dobijemo gresku
        // onda program nece da pukne tu nego ce nastaviti dalje
        // Catch deo nam nije bitan, ali je obavezna u javi kao deo try catch bloka i potrebno je
        // samo da kreiramo taj deo i da prosledimo da uhvati neki Exception
        // Ako zelimo taj Exception koji smo nazvali 'e' mozemo da odstampamo u catch bloku

        // Pre pocetka pravimo boolean cija je vrednost false
        // Na kraju cemo raditi asertaciju bas ovo booleana i ocekujemo da bude false
        // Taj boolean ce se promeniti na true samo ako element bude vidljiv na stranici

        boolean isPresent = false;

        try {
            // Upravo u ovom delu kazemo programu - Ako pronadjes element, promeni vrednost booleana na true
            isPresent = driver.findElement(By.linkText("Log out")).isDisplayed();
        } catch (Exception e) {
            // Ovaj deo bloka moze da ostane prazan
            // Za catch deo je bitno da se prosledi Exception i da se dodeli naziv
        }

        Assert.assertFalse(isPresent);


    }

}
