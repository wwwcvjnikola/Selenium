import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Selenium2 {

    static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com");

        // otvaranje novih tabova

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");

        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());
        System.out.println(listaTabova);

        driver.switchTo().window(listaTabova.get(1)); // 1 je broj taba
        driver.navigate().to("https://www.youtube.com");

        driver.switchTo().window(listaTabova.get(2));
        driver.navigate().to("https://www.linkedin.com");

        driver.switchTo().window(listaTabova.get(3));
        driver.navigate().to("https://www.google.com");

        // zatvara nam poslednji tab
        //driver.close();

        // zatvara ceo browser
        //driver.quit();

        // zatvaranje 3 dodatna taba

        driver.close(); // nakon zatvaranja je i dalje fokus na tom poslednjem tabu
        driver.switchTo().window(listaTabova.get(2));
        driver.close();
        driver.switchTo().window(listaTabova.get(1));
        driver.close();

















    }




}
