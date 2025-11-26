package Domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utorak {
    public static void main (String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Otvoriti youtube i pustiti pesmu po zelji (prvo otvoriti pretrazivac, zatim search youtube,
        // pa pustiti pesmu)

        // otvaranje pretrazivaca
        driver.navigate().to("https://duckduckgo.com/");

        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div/div/main/article/div[1]/div[1]/div[2]/div/header/div/section[2]/form/div/div/input"))
                .sendKeys("youtube");
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div/div/main/article/div[1]/div[1]/div[2]/div/header/div/section[2]/form/div/div/div/button[2]"))
                .sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/div[6]/div[4]/div/div/div/div[2]/section[1]/ol/li[1]/article/div[3]/h2/a/span"))
                .click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div[2]/ytd-masthead/div[4]/div[2]/yt-searchbox/div[1]/form/input"))
                .sendKeys("imagine dragons believer");
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div[2]/ytd-masthead/div[4]/div[2]/yt-searchbox/button"))
                .sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-video-renderer[1]/div[1]/div/div[1]/div/h3/a/yt-formatted-string"))
                .click();








    }
}
