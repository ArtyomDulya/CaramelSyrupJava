import Runner.BaseWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class СпроситьTest extends BaseWaits {

    @Test
    public void testADLearnMoreHeaders1() {
        List<String> expectedResult = Arrays.asList("Enter an item name", "New node", "Configure Clouds", "Jenkins");

        getDriver().findElement(By.xpath("//div[@id='main-panel']//a[@href='newJob']")).click();
        Assert.assertEquals(getDriver().findElement(By.xpath("//label[text()='Enter an item name']")).getText(), expectedResult.get(0));
        getDriver().navigate().back();

        getDriver().findElement(By.xpath("//div[@id='main-panel']//a[@href='computer/new']")).click();
        Assert.assertEquals(getDriver().findElement(By.xpath("//h1[text()='New node']")).getText(), expectedResult.get(1));
        getDriver().navigate().back();

        getDriver().findElement(By.xpath("//div[@id='main-panel']//a[@href='configureClouds']")).click();
        Assert.assertEquals(getDriver().findElement(By.xpath("//h1[text()='Configure Clouds']")).getText(), expectedResult.get(2));
        getDriver().navigate().back();

        getDriver().findElement(By.xpath("//span[text()='Learn more about distributed builds']")).click();
        List<String> windows = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(windows.get(1));
        Assert.assertEquals(getDriver().findElement(By.xpath("//a[text()='Jenkins']")).getText(), expectedResult.get(3));
    }

    @Test
    public void testNameUser() {
        getDriver().findElement(By.cssSelector("[href='/logout']")).click();
        WebElement login = getDriver().findElement(By.cssSelector("form[name='login'] input[name='j_username']"));
        login.click();
        login.sendKeys("ArtyomDulya");
        WebElement password = getDriver().findElement(By.cssSelector("form[name='login'] input[name='j_password']"));
        password.click();
        password.sendKeys("6da584b873ff481aa60ce442bb84921d");
        getDriver().findElement(By.cssSelector("button[name='Submit']")).click();

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.cssSelector("#tasks [href*='People']")))).click();
        Assert.assertEquals(getDriver().findElement(By.xpath("//td[text()='ArtyomDulya']")).getText(), "ArtyomDulya");
    }

    @Test
    public void testMainMenu() {
        getDriver().findElement(By.cssSelector("#tasks  a[href$='/newJob']")).click();
        Assert.assertEquals(getDriver().findElement(By.cssSelector(".h3")).getText(), "Enter an item name");
        getDriver().navigate().back();
        getDriver().findElement(By.cssSelector("#tasks [href*='People']")).click();
        Assert.assertEquals(getDriver().findElement(By.cssSelector("#main-panel h1")).getText(), "People");
        getDriver().navigate().back();
        getDriver().findElement(By.cssSelector("#tasks [href$='builds']")).click();
        Assert.assertEquals(getDriver().findElement(By.cssSelector("#main-panel h1")).getText(), "Build History of Jenkins");
        getDriver().navigate().back();
        getDriver().findElement(By.cssSelector("#tasks [href$='manage']")).click();
        Assert.assertEquals(getDriver().findElement(By.cssSelector("#main-panel h1")).getText(), "Manage Jenkins");
        getDriver().navigate().back();
        getDriver().findElement(By.cssSelector("#tasks [href$='views']")).click();
        Assert.assertEquals(getDriver().findElement(By.cssSelector("#main-panel h2")).getText(), "This folder is empty");
    }

    @Test
    public void testADLearnMoreHeaders()  {
        List<String> expectedResult = Arrays.asList("Enter an item name", "New node", "Configure Clouds", "Jenkins");

        waitForElementToBeDisplayed(getDriver().findElement(By.xpath("//div[@id='main-panel']//a[@href='newJob']")));
        clickCustom(getDriver().findElement(By.xpath("//div[@id='main-panel']//a[@href='newJob']")));
        waitForElementToBeDisplayed(getDriver().findElement(By.xpath("//label[text()='Enter an item name']")));
        Assert.assertEquals(getDriver().findElement(By.xpath("//label[text()='Enter an item name']")).getText(), expectedResult.get(0));
        getDriver().navigate().back();

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        waitForElementToBeDisplayed(getDriver().findElement(By.xpath("//a[@href='computer/new']")));
        clickCustom(getDriver().findElement(By.xpath("//span[text()='Set up an agent']")));
        waitForElementToBeDisplayed(getDriver().findElement(By.xpath("//h1[text()='New node']")));
        Assert.assertEquals(getDriver().findElement(By.xpath("//h1[text()='New node']")).getText(), expectedResult.get(1));
        getDriver().navigate().back();

        waitForElementToBeDisplayed(getDriver().findElement(By.xpath("//a[@href='configureClouds']")));
        clickCustom(getDriver().findElement(By.xpath("//a[@href='configureClouds']")));
        waitForElementToBeDisplayed(getDriver().findElement(By.xpath("//h1[text()='Configure Clouds']")));
        Assert.assertEquals(getDriver().findElement(By.xpath("//h1[text()='Configure Clouds']")).getText(), expectedResult.get(2));
        getDriver().navigate().back();

        waitForElementToBeDisplayed(getDriver().findElement(By.xpath("//span[text()='Learn more about distributed builds']")));
        clickCustom(getDriver().findElement(By.xpath("//span[text()='Learn more about distributed builds']")));
        List<String> windows = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(windows.get(1));
        waitForElementToBeDisplayed(getDriver().findElement(By.xpath("//a[text()='Jenkins']")));
        Assert.assertEquals(getDriver().findElement(By.xpath("//a[text()='Jenkins']")).getText(), expectedResult.get(3));
    }
}
