package Domaci.nedelja9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Ponedeljak {

    WebDriver driver;
    WebDriverWait wait;

    String validFirstName = "nikola";
    String validLastName = "cvjeticanin";
    String validUserName = "dzoni";
    String validPassword = "Sifra123!";


    @BeforeClass
    public void setupPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
    }

    @BeforeMethod
    public void setup() {
        driver.navigate().to("https://demoqa.com/login");

/*        // NewUser
        driver.findElement(By.id("newUser")).click();

        // Forma
        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/register"));
        driver.findElement(By.id("firstname")).sendKeys(validFirstName);
        driver.findElement(By.id("lastname")).sendKeys(validLastName);
        driver.findElement(By.id("userName")).sendKeys(validUserName);
        driver.findElement(By.id("password")).sendKeys(validPassword);

        // I'm not a robot
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.className("recaptcha-checkbox-border")));
            driver.findElement(By.className("recaptcha-checkbox-border")).click();
        } catch (Exception e) {

        }

        // Register
        // treba skrol za dugme register. To nisam znao kako pa sam izguglao kako bi to moglo biti.
        // Znam da je i Dragoljub pokazivao na casu. Nije da sam razumeo :)

        wait.until(ExpectedConditions.elementToBeClickable(By.id("register")));

        WebElement registerBtn = driver.findElement(By.id("register"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", registerBtn);
        registerBtn.click();

//        wait.until(ExpectedConditions.elementToBeClickable(By.id("register")));
//        driver.findElement(By.id("register")).click();



        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
        } catch (Exception e){

        }

        // Back to Login
        wait.until(ExpectedConditions.elementToBeClickable(By.id("gotologin")));
        driver.findElement(By.id("gotologin"));

*/

        // Zamisao je bila sledeca da probam da se registrujem pa da se logujem pod tim kredencijalima
        // kako bih dobio odredjene cookies-e a zatim da ih extract-ujem. Ali mi je ovo gore propalo tj
        // nisam uspeo da odradim registraciju plus login iz nekog razloga iako mi pise
        // "process finished with exit code 0". 6 i po sati sam radio ovo samo sto se nisam obesio :)

        driver.findElement(By.id("userName")).sendKeys(validUserName);
        driver.findElement(By.id("password")).sendKeys(validPassword);
        driver.findElement(By.id("login")).click();

        // pricali smo u grupi gde je neko spomenuo da su ova 4 cookie-a neophodna za logovanje
        // pa sam trazio nacin kako da ih izvucem.

        Cookie token = driver.manage().getCookieNamed("token");
        Cookie userID = driver.manage().getCookieNamed("userID");
        Cookie expires = driver.manage().getCookieNamed("expires");
        Cookie username = driver.manage().getCookieNamed("username");

        String tokenValue = token.getValue();
        String userIDValue = userID.getValue();
        String expiresValue = expires.getValue();
        String usernameValue = username.getValue();

        driver.navigate().to("https://demoqa.com/login");

        driver.manage().addCookie(new Cookie("token", tokenValue));
        driver.manage().addCookie(new Cookie("userID", userIDValue));
        driver.manage().addCookie(new Cookie("expires", expiresValue));
        driver.manage().addCookie(new Cookie("username", usernameValue));

        driver.navigate().refresh();



    }

    @Test (priority = 10)
    public void urlTest(){

    }

    @Test (priority = 20)
    public void usernamecheck() {

    }





}
