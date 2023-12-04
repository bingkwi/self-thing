package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import util.WebUI;

import java.util.Random;

public class LoginPage {
    private final WebUI WebUI;
    @FindBy(xpath = "//div[@class='footer']//a[@title='My Account'][normalize-space()='My Account']")
    private WebElement myAccLink;
    @FindBy(xpath = "//a[@title='Create an Account']")
    private WebElement createAccButton;
    @FindBy(xpath="//input[@name='firstname']")
    private WebElement firstNameInput;
    @FindBy(xpath="//input[@name='middlename']")
    private WebElement middleNameInput;
    @FindBy(xpath="//input[@name='lastname']")
    private WebElement lastNameInput;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;
    @FindBy(xpath="//input[@name='confirmation']")
    private WebElement confirmPasswordInput;
    @FindBy(xpath = "//button[@title='Register']")
    private WebElement registerButton;
    @FindBy(xpath = "//span[@class='label'][normalize-space()='Account']")
    private WebElement accountLabel;
    @FindBy(xpath="//a[@title='Log Out']")
    private WebElement logoutButton;
    @FindBy(xpath = "//span[normalize-space()='Thank you for registering with Main Website Store.']")
    private WebElement successfullyMessage;
    public LoginPage(WebDriver driver) {
        System.out.println("login pagwe jbndasjkdnkasdjkasbjkdbasjkbd");
        System.out.println(driver);
        PageFactory.initElements(driver, this);
        WebUI = new WebUI(driver);
    }

    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(9999);
    }

    public void clickMyAccLink() {
        WebUI.onClick(myAccLink);
    }
    public void clickRegisterBtn() {
        WebUI.onClick(registerButton);
    }

    public void clickCreateAccBtn() {
        WebUI.onClick(createAccButton);
    }
    public void submitForm(String firstName, String middleName, String lastName, String email, String password, String confirmPassword) {
        WebUI.sendText(lastNameInput, firstName);
        WebUI.sendText(middleNameInput, middleName);
        WebUI.sendText(lastNameInput, lastName);
        email +=  generateRandomNumber() + "@mail.net";
        WebUI.sendText(emailInput,email);
        WebUI.sendText(passwordInput, password);
        WebUI.sendText(confirmPasswordInput, confirmPassword);
    }

    public void showRegisterSuccessfullyMsg() {
       WebUI.waitForElementToBeVisible(successfullyMessage, 20);
        Assert.assertEquals(successfullyMessage.getText(), "Thank you for registering with Main Website Store.");
    }

    public void clickLogout() {
        WebUI.onClick(accountLabel);
        WebUI.waitForElementToBeVisible(logoutButton, 20);
        WebUI.onClick(logoutButton);
    }




}
