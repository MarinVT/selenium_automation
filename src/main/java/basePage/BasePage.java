package basePage;

import SeleniumDriver.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Global_Vars;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BasePage {

    public WebDriverWait wait;
    public Actions actions;
    public Select select;

    // Test
    /**
     * Constructor
     */
    public BasePage() {
        PageFactory.initElements(getDriver(), this);
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
    }

    /**
     * public static WebDriver driver;
     * @return griver
     */
    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    /**
     * NAVIGATE TO URL CUSTOM METHOD
     * @param url
     */
    public void navigateToSiteURL(String url) {
        getDriver().get(url);
    }


    /**
     * WAIT VISIBILITY OF WEBELEMENTS
     * @param element
     */
    public void waitVisibilityOfWebElement(WebElement element) {
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
        System.out.println();
    }

    /**
     * WAIT VISIBILITY OF SPECIFIC WEBELEMENT
     * @param element
     */
    public void waitElementToBeVisible(WebElement element) {
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Wait for an element to be clickable
     * @param webElement
     */
    public void waitElementAndClickOnIt(WebElement webElement) {
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        WebElement findElement = wait.until(ExpectedConditions.elementToBeClickable(webElement));
        findElement.click();
    }

    /**
     * Hover methods using Actions
     * @param webElement
     */
    public void hoverEffectOverAnElement(WebElement webElement) {
        actions = new Actions(getDriver());
        waitVisibilityOfWebElement(webElement);
        actions.moveToElement(webElement);
        actions.perform();
    }

    /**
     * Hover method and pause for 1 second using Actions class
     * @param webElement
     */
    public void hoverOverAnElementPause1Second(WebElement webElement) {
        actions = new Actions(getDriver());
        waitVisibilityOfWebElement(webElement);
        actions.moveToElement(webElement);
        actions.pause(1000);
        actions.perform();
    }

    /**
     * Custom wait and hover method
     * @param webElement
     */
    public void waitHoverOverElement(WebElement webElement) {
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        actions = new Actions(getDriver());
        actions.moveToElement(wait.until(ExpectedConditions.visibilityOf(webElement))).perform();
//        waitCustomMethod(2000);
    }

    /**
     * Hover and click custom method
     * @param webElement
     */
    public void hoverAndClick(WebElement webElement) {
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        actions = new Actions(getDriver());
        actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(webElement))).click().perform();
    }

    /**
     * Hover method with hold action
     * @param webElement
     */
    public void hoverHoldAndClickOnElement(WebElement webElement) {
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        actions = new Actions(getDriver());
        actions.moveToElement(wait.until(ExpectedConditions.visibilityOf(webElement))).clickAndHold().build().perform();
    }


    /**
     * SENDKEYS CUSTOM USING WEBELEMENT AND STRING TO BE ENTERED
     * @param webElement
     * @param stringToEnter
     */
    public void sendKeysViaWebElementAndEnterString(WebElement webElement, String stringToEnter) {
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).sendKeys(stringToEnter);
    }

    /**
     * Custom wait method for debugging
     * @param time
     */
    public void waitCustomMethod(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * VALIDATE CORRECT PAGE METHOD
     * @param searchString
     */
    public void validateCorrectPage(String searchString) {
        if (getDriver().getTitle().contains(searchString.trim())) {
            throw new IllegalStateException(
                    "This is not "
                    + searchString + " .The actual Url is: "
                    + getDriver().getCurrentUrl());
        }
    }

    /**
     * GET CURRENT PAGE METHOD
     * @return current URL of the page
     */
    public String getCurrentURL() {
        return getDriver().getCurrentUrl();
    }

    /**
     * DROPDOWN METHOD SELECTION BY TEXT
     * @param element
     * @param selectByText
     */
    public void selectFromDropDownByText(WebElement element, String selectByText) {
        waitVisibilityOfWebElement(element);
        select = new Select(element);
        select.selectByVisibleText(selectByText);
    }

    /**
     * DROPDOWN METHOD SELECTION BY VALUE
     * @param element
     * @param selectByValue
     */
    public void selectFromDropDownByValue(WebElement element, String selectByValue) {
        select = new Select(element);
        select.selectByValue(selectByValue);
    }

    /**
     * Clears a field's data added in it
     * @param element
     */
    public void clearField(WebElement element) {
        waitVisibilityOfWebElement(element);
        element.clear();
    }


    /**
     * Method returns webElement's extracted text
     * @param webElement
     * @return
     */
    public String readTextWebElement(WebElement webElement) {
        waitVisibilityOfWebElement(webElement);
        return webElement.getText();
    }


    /**
     * ASSERT METHOD using WebElement and its text
     * @param webElement
     * @param expectedText
     */
    public void assertEqualsByWebElementExpectedText(WebElement webElement, String expectedText) {
        waitVisibilityOfWebElement(webElement);
        Assert.assertEquals(readTextWebElement(webElement), expectedText);
        System.out.println("Main text is: " + expectedText);
    }

    /**
     * Returns specific error
     * @param element
     * @return
     */
    public String getErrorMessage(WebElement element) {
        String strErrorMsg = null;
//        WebElement errorMsg = driver.findElement(errorMsgTxt);
        if(element.isDisplayed() && element.isEnabled())
            strErrorMsg = element.getText();
        return strErrorMsg;
    }

    /**
     * Switch to alert message pop up window
     * @param text
     */
    public void waitForAlertWindowAndValidateText(String text) {
        String alertMessage = getDriver().switchTo().alert().getText();
        Assert.assertEquals(alertMessage, text);
    }

    /**
     * SWITCH TO NEW TAB IN THE BROWSER BASED ON ARRAY AND IT GOES TO SECOND TAB WHICH INDEX IS 1
     */
    public void openNewTab() {
        Set<String> handles = getDriver().getWindowHandles();
        List<String> list = new ArrayList<>(handles);
        waitCustomMethod(2000);
        String newWindow = list.get(1);
        getDriver().switchTo().window(newWindow);
    }

    /**
     * SCROLL DOWN ACTION USING KEYS
     * @param webElement
     */
    public void scrollDown(WebElement webElement) {
        waitVisibilityOfWebElement(webElement);
        actions = new Actions(getDriver());
        actions.sendKeys(Keys.PAGE_DOWN);
        actions.perform();
    }

    /**
     * SCROLL DOWN ACTION TO ELEMENT
     * @param webElement
     */
    public void scrollDownToElement(WebElement webElement) {
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromViewport(10, 10);
        actions = new Actions(getDriver());
        actions.scrollFromOrigin(scrollOrigin, 0, 2000).perform();
    }

    /**
     * It moves slider to right side using keyboard key to left
     * @param sliderElement
     * @param isRightSliding
     * @param keyPressTimes
     */
    public void moveSliderKeyArrowLeft(WebElement sliderElement, boolean isRightSliding, int keyPressTimes) {
        waitVisibilityOfWebElement(sliderElement);
        Actions moveSlider = new Actions(getDriver());

        if (isRightSliding) {
            for (int i = 0; i < keyPressTimes; i++) {
                moveSlider.sendKeys(Keys.ARROW_LEFT).perform();
            }

        }

    }

    /**
     * It moves slider to right side using keyboard key to right
     * @param sliderElement
     * @param isRightSliding
     * @param keyPressTimes
     */
    public void moveSliderKeyArrowRight(WebElement sliderElement, boolean isRightSliding, int keyPressTimes) {
        waitVisibilityOfWebElement(sliderElement);

        if (isRightSliding) {
            for (int i = 1; i < keyPressTimes; i++) {
                sliderElement.sendKeys(Keys.ARROW_RIGHT);
            }

        }

    }


    /*
    Get desired values method and returns list with items - LINK BELOW
    https://www.testingminibytes.com/courses/java-8-for-automation-qa-power-of-functional-programming/optimising-gettext-gettagname-getattribute-methods-in-selenium

    NOTE: This is a selector that will be passed to the method - private By menuItems = By.xpath("//div[@id='nav-xshop']/a")
    List<WebElement> elements = driver.findElements(menuItems)
    List<String> takeAllValues1 = getValues(elements(Webelement, Webelement::getText)
    List<String> takeAllValues2 = getValues(elements(Webelement, e -> e.getAttribute("href"))
    List<String> takeAllValues3 getValues(elements(Webelement, Webelement::getTagName)
     */

    /**
     * Lists all items
     * @param elements
     * @param function
     * @return
     */
    public List<String> getValuesFromDropDown(List<WebElement> elements, Function<WebElement, String> function) {
        return elements.stream().map(function).collect(Collectors.toList());
    }
    /*
    Call the method ->
    getValues.foreach(System::println)
     */

}
