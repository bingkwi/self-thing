package util;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.Set;

import static common.BaseTest.threadSleep;

public class WebUI {
    public WebDriverWait wait;
    public WebDriver driver;
    public WebUI(WebDriver _driver){
        driver = _driver;
    }
    public void waitForElementToBeVisible(WebElement locator, int time) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(locator));
    }
    public void waitForElementToBeClickable(WebElement locator, int time) {
        System.out.printf("Driver is: %s\n", driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void waitForOptionElementToBeVisible(WebElement locator1,WebElement locator2, int time) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(
                ExpectedConditions.or(
                        ExpectedConditions.visibilityOf(locator1),
                        ExpectedConditions.visibilityOf(locator2)
                )
        );
    }
    public void sendText(WebElement locator, String value){
        threadSleep(2);
        waitForElementToBeVisible(locator,20);
        locator.sendKeys(value);
    }
    public void onClick(WebElement locator){
        threadSleep(2);
        waitForElementToBeClickable(locator,20);
        locator.click();
    }
    public void onClickJS(WebElement locator){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", locator);

    }
    public void clearValue(WebElement locator){
        threadSleep(2);
        locator.clear();
    }
    public void verifyDisplay(WebElement locator, String expectedText){
        waitForElementToBeVisible(locator,20);
        Assert.assertEquals(true,locator.isDisplayed());
        Assert.assertEquals(locator.getText(), expectedText);
    }
    public void verifyContains(WebElement locator, String expectedText){
        waitForElementToBeVisible(locator,20);
        String actualText = locator.getText();
        Assert.assertTrue(actualText.contains(expectedText), "Text not display correct !");
    }
    public void verifyValueInput(WebElement locator, String expectedValue){
        waitForElementToBeVisible(locator,20);
        String getValue = locator.getAttribute("value");
        Assert.assertEquals(getValue, expectedValue);
    }
    public void verifyURL(String expectedURL){
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedURL));
    }
    public void enter(WebElement locator){
        locator.sendKeys(Keys.ENTER); // or Keys.ENTER
    }
    public void handleWindowTab(String expectedURL){ // Open a new window and back to the root window
        Set<String> windowHandles = driver.getWindowHandles();
        String originalWindowHandle = driver.getWindowHandle();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(originalWindowHandle)) {
                driver.switchTo().window(windowHandle);
                threadSleep(5);
                Assert.assertTrue(driver.getCurrentUrl().contains(expectedURL));
                break;
            }
        }
        driver.switchTo().window(originalWindowHandle);
    }
    public void switchToTheNewWindow(){
        Set<String> windowHandles = driver.getWindowHandles();
        // Switch to the new window/tab
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
        }
    }
    public void scrollToTheTopOfThePage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
    }

}
