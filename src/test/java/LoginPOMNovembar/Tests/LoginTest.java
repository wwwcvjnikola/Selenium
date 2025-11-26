package LoginPOMNovembar.Tests;

import LoginPOMNovembar.Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://practicetestautomation.com/");
        homePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginButton();
        loginPage.clickOnSubmitButton();
        logoutPage.clickOnLogOutButton();
    }

    @Test
    public void userCanLogIn() {
        String validUsername = "student";
        String validPassword = "Password123";
        homePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginButton();
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.getSubmitButton();
        Assert.assertTrue(profilePage.getLogOutButton().isDisplayed());
    }

}
