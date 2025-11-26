package Cas2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Selenium5 {
    static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://duckduckgo.com/");

        Thread.sleep(3000);
        WebElement searchBox = driver.findElement(By.id("searchbox_input"));
        searchBox.sendKeys("Wikipedia");
        WebElement searchButton = driver.findElement(By.cssSelector("button[type='submit']"));
        searchButton.click();
        Thread.sleep(3000);
        WebElement wikipediaButton = driver.findElement(By.cssSelector("a[data-testid='result-title-a']"));
        wikipediaButton.click();

        WebElement wikipediaSearchBox = driver.findElement(By.id("searchInput"));
        wikipediaSearchBox.sendKeys("Nikola Tesla");

        WebElement searchButtonByCustomCSS = driver.findElement(By.cssSelector("button[type='submit']"));
        searchButtonByCustomCSS.click();

        //--------------------------------------

        Thread.sleep(1000);

        // Asertujem da li je URL validan
        String expectedURL = "https://en.wikipedia.org/wiki/Nikola_Tesla";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        // Asertujem da li je title validan (tekst unutar taba)
        String expectedTitle = "Nikola Tesla - Wikipedia";
        Assert.assertEquals(driver.getTitle(), expectedTitle);

        // Asertujem da li je naslov stranice valida
        String expectedPageHeader = "Nikola Tesla";
        WebElement pageHeader = driver.findElement(By.id("firstHeading"));
        String actualPageHeader = pageHeader.getText();
        Assert.assertEquals(actualPageHeader, expectedPageHeader);

        // Asertujem da li je slika prisutna
        WebElement pageImage = driver.findElement(By.className("infobox-image"));
        Assert.assertTrue(pageImage.isDisplayed());

        //------------------------

        // Kako asertovati da li je bas ta slika prisutna
        // Mozemo preko 'alt' atributa da izvucemo opis slike i da asertujemo taj tekst

        // Element slike nema jedinstven lokator ali ga mogu naci preko parent elementa
        // Parent element vec imam kao lokator pod nazivom pageImage
        // Da bih izvrsio pretragu samo unutar tog elementa
        // potrebno je da pozovem taj lokator i na njemu da izvrsim .findElement()
        WebElement image = pageImage.findElement(By.tagName("img"));
        String expectedAltImageText = "Head-and-shoulder photograph of a slender man with dark hair and moustache, dark suit and white-collar shirt";
        String actualAltImageText = image.getAttribute("alt");
        Assert.assertEquals(actualAltImageText, expectedAltImageText);

        // Na isti nacin mozemo da proverimo i src vrednost elementa

        String expectedSrcText = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/79/Tesla_circa_1890.jpeg/250px-Tesla_circa_1890.jpeg";
        String actualSrcText = image.getAttribute("src");
        Assert.assertEquals(actualSrcText, expectedSrcText);






    }
}
