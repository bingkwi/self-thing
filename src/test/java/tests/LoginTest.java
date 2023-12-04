package tests;

import common.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    @BeforeClass
    public void setUp() {
        driver = getDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void Login_TC01_verifyLoginSuccess(){
        loginPage.clickMyAccLink();
        loginPage.clickCreateAccBtn();
        loginPage.submitForm("Katie", "", "Nguyen", "email@com.net", "1111111", "1111111");
        loginPage.clickLogout();
        loginPage.showRegisterSuccessfullyMsg();
    }
}
