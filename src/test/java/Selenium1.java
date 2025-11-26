import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium1 {
    static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        // U ovoj komandi postavljamo driver

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //driver.get("https://www.google.com"); // ne zanima je da li je strana pukla ili slicno

        // otvara google - URL mora biti ceo sa npr https://
        driver.navigate().to("https://www.google.com"); // pre nego sto otvori proverava - preporuka

        // ispisuje u konzoli
        System.out.println("TRENUTNI URL");
        System.out.println(driver.getCurrentUrl());

        // idemo na youtube
        driver.navigate().to("https://www.youtube.com");

        // ispisuje u konzoli
        System.out.println("TRENUTNI URL");
        System.out.println(driver.getCurrentUrl());

        // back i browseru
        driver.navigate().back();

        // ispisuje u konzoli
        System.out.println("TRENUTNI URL");
        System.out.println(driver.getCurrentUrl());

        // forward u browseru
        driver.navigate().forward();

        // refresh strane
        driver.navigate().refresh();

        // izlazak iz browsera - moze i sa close()
        driver.quit();
















    }
}
