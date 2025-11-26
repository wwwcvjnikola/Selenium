import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium3 {
    static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();

        driver.navigate().to("https://www.bing.com");

        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/form/div[1]/div/textarea"))
                        .sendKeys("IT Bootcamp");
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/form/div[1]/div/textarea"))
                .sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[3]/main/div[2]/ol[2]/li[1]/div[2]/div[2]/h2/a"))
                .click();







    }
}
