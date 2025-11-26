package Cas3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak6 {
    public static void main (String[] args) throws InterruptedException {

        // Logovanje na WordPress

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://duckduckgo.com/");

        Thread.sleep(1000);
        WebElement searchBar = driver.findElement(By.id("searchbox_input"));
        searchBar.sendKeys("wordpress");
        Thread.sleep(2000);
        WebElement searchBttn = driver.findElement(By.cssSelector(".iconButton_button__A_Uiu.searchbox_searchButton__LxebD"));
        searchBttn.click();
        Thread.sleep(2000);
        WebElement wplink = driver.findElement(By.linkText("WordPress.com: Everything You Need to Build Your Website"));
        wplink.click();
        Thread.sleep(2000);
        WebElement login = driver.findElement(By.cssSelector(".x-nav-item.x-nav-item--wide.lpc.x-nav--log-in"));
        login.click();
        Thread.sleep(2000);
        Thread.sleep(1000);
        WebElement username = driver.findElement(By.id("usernameOrEmail"));
        username.sendKeys("cvjnikola");
        Thread.sleep(1000);
        WebElement continueBtn = driver.findElement(By.cssSelector(".components-button.is-next-40px-default-size.is-primary"));
        continueBtn.click();
        Thread.sleep(1000);
        WebElement psswd = driver.findElement(By.id("password"));
        psswd.sendKeys("N&K20052020");
        Thread.sleep(1000);
        WebElement login2 = driver.findElement(By.cssSelector(".components-button.is-next-40px-default-size.is-primary"));
        login2.click();










    }

}
