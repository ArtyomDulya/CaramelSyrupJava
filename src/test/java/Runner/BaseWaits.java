package Runner;

import Runner.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseWaits extends BaseTest {

    public void waitForElementToBeDisplayed(WebElement element) {
        beforeMethod();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        ExpectedCondition<Boolean> elementDisplayed = arg0 -> {
            try {
                element.isDisplayed();
                return true;
            } catch (Exception e) {
                return false;
            }
        };
        wait.until(elementDisplayed);
    }

   public   void clickCustom(WebElement element) {
        beforeMethod();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        ExpectedCondition<Boolean> elementIsClickable = arg0 -> {
            try {
                element.click();
                return true;
            } catch (Exception e) {
                return false;
            }
        };
        wait.until(elementIsClickable);
    }

    public void waitForElementToBeDisplayed(WebElement element, int timeOutPeriod) {
        beforeMethod();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeOutPeriod));
        ExpectedCondition<Boolean> elementDisplayed = arg0 -> {
            try {
                element.isDisplayed();
                return true;
            } catch (Exception e) {
                return false;
            }
        };
        wait.until(elementDisplayed);
    }

    public void clickCustom(WebElement element, int timeOutPeriod) {
        beforeMethod();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeOutPeriod));
        ExpectedCondition<Boolean> elementIsClickable = arg0 -> {
            try {
                element.click();
                return true;
            } catch (Exception e) {
                return false;
            }
        };
        wait.until(elementIsClickable);
    }

    public void tryClick(WebElement elementToClick, WebElement elementToWaitFor) {
        beforeMethod();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        ExpectedCondition<Boolean> condition = arg0 -> {
            try {
                clickCustom(elementToClick, 5);
                waitForElementToBeDisplayed(elementToWaitFor, 5);
                return true;
            } catch (Exception e) {
                return false;
            }
        };
        wait.until(condition);
    }
}
