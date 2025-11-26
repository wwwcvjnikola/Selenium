package Cas3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium7 {
    public static void main (String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://wordpress.com/");

        Cookie cookie = new Cookie("wordpress_logged_in", "cvjnikola%7C1858364233%7C7zOYJyNlpqXvfvAolTZw1nsHzDGGH6Af350BMeAU7WV%7C9c21cf56c1b3648d086655b3548859074222d9018adcef621e742a13bcc86a0a");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();

        // neke od akcija za Cookie

        driver.manage().deleteCookieNamed("wordpress_logged_in");
        driver.manage().deleteCookie(cookie);
        driver.manage().deleteAllCookies();

    }
}
