package Cas4;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.security.PublicKey;
import java.time.Duration;

public class Zadatak9 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass

    public void setupPage () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @BeforeMethod

    public void setup () {
        driver.navigate().to("https://practicetestautomation.com/");
        WebElement practiceTab = driver.findElement(By.id("menu-item-20"));
        practiceTab.click();

        WebElement testLoginPage = driver.findElement(By.linkText("Test Login Page"));
        testLoginPage.click();

        String validUser = "student";
        String validPsswd = "Password123";

        WebElement usernameLabel = driver.findElement(By.id("username"));
        WebElement psswdLabel = driver.findElement(By.id("password"));
        WebElement submitBtn = driver.findElement(By.id("submit"));

        usernameLabel.clear();
        usernameLabel.sendKeys(validUser);
        psswdLabel.clear();
        psswdLabel.sendKeys(validPsswd);
        submitBtn.click();
    }

    @Test (priority = 10)

    public void title () {
        String expectedTitle = "Logged In Successfully | Practice Test Automation";
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    @Test (priority = 20)

    public void url() {
        String expectedUrl =  "https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    @Test (priority = 30)

    public void msg() {
        WebElement loginSuccessMsg = driver.findElement(By.className("post-header"));
        Assert.assertTrue(loginSuccessMsg.isDisplayed(), "Ne prikazuje se poruka");
    }

    @Test (priority = 40)

    public void logout(){
        WebElement logOutBtn = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logOutBtn.isDisplayed());
    }

    @Test (priority = 50)

    public void welcomMsg() {
        String validUser1 = "student";
        WebElement welcomMsg = driver.findElement(By.className("has-text-align-center"));
        Assert.assertTrue(welcomMsg.getText().contains(validUser1));
    }

    @AfterMethod

    public void logoutbtn() {
        WebElement logOutBtnAfter = driver.findElement(By.linkText("Log out"));
        logOutBtnAfter.click();
    }

    @AfterClass

    public void quit() {
        driver.quit();
    }



}
