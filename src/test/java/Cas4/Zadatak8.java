package Cas4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Zadatak8 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://practicetestautomation.com/");
        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();
        WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
        testLoginPageButton.click();
    }

    @Test(priority = 1)
    public void userCanLogIn() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement logInButton = driver.findElement(By.id("submit"));

        String validUsername = "student";
        String validPassword = "Password123";
        usernameField.clear();
        usernameField.sendKeys(validUsername);
        passwordField.clear();
        passwordField.sendKeys(validPassword);
        logInButton.click();

        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logOutButton.isDisplayed());

        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);

        WebElement welcomeMessage = driver.findElement(By.className("post-content"));
        Assert.assertTrue(welcomeMessage.getText().contains(validUsername));
    }

    @Test(priority = 2)
    public void userCanLogOut() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement logInButton = driver.findElement(By.id("submit"));

        String validUsername = "student";
        String validPassword = "Password123";
        usernameField.clear();
        usernameField.sendKeys(validUsername);
        passwordField.clear();
        passwordField.sendKeys(validPassword);
        logInButton.click();

        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
        logOutButton.click();

        WebElement logInButtonAfterLogOut = driver.findElement(By.id("submit"));
        Assert.assertTrue(logInButtonAfterLogOut.isDisplayed());

        boolean isPresent = false;

        try {
            isPresent = driver.findElement(By.linkText("Log out")).isDisplayed();
        } catch (Exception e) {

        }

        Assert.assertFalse(isPresent);
    }

    @Test(priority = 3)
    public void userCannotLogInWithInvalidUsername() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement logInButton = driver.findElement(By.id("submit"));

        String invalidUsername = "not student";
        String validPassword = "Password123";
        usernameField.clear();
        usernameField.sendKeys(invalidUsername);
        passwordField.clear();
        passwordField.sendKeys(validPassword);
        logInButton.click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("error"))));

        WebElement error = driver.findElement(By.id("error"));
        Assert.assertTrue(error.isDisplayed());
        Assert.assertEquals(error.getText(), "Your username is invalid!");
    }

    @Test(priority = 4)
    public void userCannotLogInWithInvalidPassword() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement logInButton = driver.findElement(By.id("submit"));

        String validUsername = "student";
        String invalidPassword = "123 password";
        usernameField.clear();
        usernameField.sendKeys(validUsername);
        passwordField.clear();
        passwordField.sendKeys(invalidPassword);
        logInButton.click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("error"))));

        WebElement error = driver.findElement(By.id("error"));
        Assert.assertTrue(error.isDisplayed());
        Assert.assertEquals(error.getText(), "Your password is invalid!");
    }

    @AfterMethod
    public void clearData() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
