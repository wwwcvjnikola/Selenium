package Cas4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class Zadatak10 {

    /*WebDriver driver;
    WebDriverWait wait;
    WebElement firstNameLabel;
    WebElement lastNameLabel;
    WebElement emailLabel;
    WebElement ageLabel;
    WebElement salaryLabel;
    WebElement departmentLabel;
    WebElement submitBtn;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @BeforeMethod

    public void setup() {
        driver.navigate().to("https://demoqa.com/");
        WebElement elements = driver.findElement(By.className("card-body"));
        wait.until(ExpectedConditions.elementToBeClickable(By.className("card-body"))).click();
        WebElement webTablesTab = driver.findElement(By.id("item-3"));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("item-3"))).click();
        WebElement addBtn = driver.findElement(By.id("addNewRecordButton"));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("addNewRecordButton"))).click();

        String firstname1 = "Nikola";
        String lastname1 = "Cvjeticanin";
        String email1 = "cvjnikola@gmail.com";
        String age1 = "34";
        String salary1 = "1000";
        String department1 = "QA";

        firstNameLabel = driver.findElement(By.id("firstName"));
        lastNameLabel = driver.findElement(By.id("lastName"));
        emailLabel = driver.findElement(By.id("userEmail"));
        ageLabel = driver.findElement(By.id("age"));
        salaryLabel = driver.findElement(By.id("salary"));
        departmentLabel = driver.findElement(By.id("department"));

        firstNameLabel.sendKeys(firstname1);
        lastNameLabel.sendKeys(lastname1);
        emailLabel.sendKeys(email1);
        ageLabel.sendKeys(age1);
        salaryLabel.sendKeys(salary1);
        departmentLabel.sendKeys(department1);

        submitBtn = driver.findElement(By.id("submit"));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("submit"))).click();
    }


    @Test (priority = 10)






    @Test (priority = 20)





    @AfterMethod






    @AfterClass

*/









}
