package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    private WebDriver driver;
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
}
