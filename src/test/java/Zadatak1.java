import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
    public void main (String[] args){

        //Zadatak 1
        //Pokrenite browser, idite na Linkedin sajt, uradite refresh, idite na Helloworld sajt
        //vratite se nazad i odstampajte poslednji URL na kom se nalazite
        //na kraju zatvorite driver

        WebDriverManager.chromedriver().setup();

        WebDriver d1 = new ChromeDriver();
        // max the window
        d1.manage().window().maximize();

        d1.navigate().to("https://www.google.com");
        //linkedin
        d1.navigate().to("https://www.linkedin.com/home");
        d1.navigate().refresh();
        // helloworld
        d1.navigate().to("https://www.helloworld.rs/");
        d1.navigate().back();
        System.out.println("URL: " + d1.getCurrentUrl());
        //d1.quit();









    }

}
