package Domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CetvrtakValid {
    public static void main (String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");

        // Primer sa validnim kredencijalima
        String validUserName = "standard_user";
        String validPsswd = "secret_sauce";

        Thread.sleep(1000);
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.clear();
        usernameInput.sendKeys(validUserName);
        Thread.sleep(1000);
        WebElement psswdInput = driver.findElement(By.id("password"));
        psswdInput.clear();
        psswdInput.sendKeys(validPsswd);
        Thread.sleep(1000);
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();

        // provera URL-a

        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

        // provera "Products" taba kada se logujemo da li ispisuje pravilan tekst

        String expectedSectionText = "Products";
        WebElement sectionText = driver.findElement(By.className("title"));
        String actualSectionText = sectionText.getText();
        Assert.assertEquals(actualSectionText, expectedSectionText);

        // provera Cart ikone u uglu da li je prisutna i da li je ona koja bi trebala da bude

        WebElement cartImg = driver.findElement(By.id("shopping_cart_container"));
        Assert.assertTrue(cartImg.isDisplayed());
        System.out.println("Ikona je prisutna: " + cartImg.isDisplayed());

        String expectedID = "shopping_cart_container";
        String actualID = cartImg.getAttribute("id");
        Assert.assertEquals(actualID, expectedID);










    }
}
