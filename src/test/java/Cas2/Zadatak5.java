package Cas2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.sql.SQLOutput;

public class Zadatak5 {
    static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/");

        String validUserName = "student";
        String validPsswd = "Password123";

        Thread.sleep(1000);
        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();
        Thread.sleep(1000);
        WebElement TestLogInPageButton = driver.findElement(By.linkText("Test Login Page"));
        TestLogInPageButton.click();
        Thread.sleep(1000);
        WebElement UserNameImput = driver.findElement(By.id("username"));
        UserNameImput.clear();
        UserNameImput.sendKeys("student");
        Thread.sleep(1000);
        WebElement PsswdImput = driver.findElement(By.id("password"));
        PsswdImput.clear();
        PsswdImput.sendKeys("Password123");
        Thread.sleep(1000);
        WebElement SubmitButton = driver.findElement(By.id("submit"));
        SubmitButton.click();



        // Assert URL

        Thread.sleep(1000);
        String URL = "https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertEquals(driver.getCurrentUrl(), URL);

        // Assert Main h1 Title

        Thread.sleep(1000);
        String Title = "Logged In Successfully";
        WebElement header = driver.findElement(By.cssSelector("h1[class='post-title']"));
        String actualHeader = header.getText();
        Assert.assertEquals(actualHeader, Title);

        // Assert Congrats Text

        Thread.sleep(1000);
        String CongratsMsg = "Congratulations student. You successfully logged in!";
        WebElement congratsText = driver.findElement(By.cssSelector("p[class='has-text-align-center']"));
        String actualText = congratsText.getText();
        Assert.assertEquals(actualText, CongratsMsg);

        // Assert Btn visiable

        Thread.sleep(1000);
        WebElement LogOutBtn = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(LogOutBtn.isDisplayed(), "true");
        System.out.println("Vidljivost: " + LogOutBtn.isDisplayed());

        // provera da li izlazi poruka za korisnika koji je logovan

        WebElement welcomeMessage = driver.findElement(By.className("post-content"));
        Assert.assertTrue(welcomeMessage.getText().contains(validUserName));
















    }
}
