import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {
    static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.navigate().to("https://www.bing.com/");

        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/form/div[1]/div/textarea"))
                .sendKeys("Wikipedia");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/form/div[1]/div/textarea"))
                .sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[3]/main/div[2]/ol[2]/li[1]/h2/a"))
                .click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div/div/div/div/form/div/div/div[1]/input"))
                .sendKeys("Nikola Tesla");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div/div/div/div/form/div/div/div[1]/input"))
                .sendKeys(Keys.ENTER);







    }
}
