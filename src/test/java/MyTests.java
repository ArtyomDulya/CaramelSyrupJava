import Runner.BaseWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTests extends BaseWaits {

    @Test
    public void testArtyomDulyaThehostbest() throws InterruptedException {

        String expectedResult = "https://thehostbest.ru/business-card-site/";

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://thehostbest.ru/");

        WebElement button = driver.findElement(By.xpath("//a[text()='Визитка']"));
        js.executeScript("window.scrollBy(0,200)");
        button.click();

        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void artyomDulyaAuthorization() throws InterruptedException {
        int random = (int) (Math.random() * 3);
        int randompass = (int) (20 + Math.random() * 20);
        String user = "alex" + randompass;
        String email = "user" + random + "@gmail.com";
        String pass = "12345user";

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://openweathermap.org/");
        Thread.sleep(5000);

        WebElement signIn = driver.findElement
                (By.xpath("//div[@id='desktop-menu']//ul//li[11]//a[text()='Sign in']"));
        signIn.click();

        WebElement newAccount = driver.findElement(By.xpath("//a[text()='Create an Account.']"));
        newAccount.click();

        WebElement userName = driver.findElement(By.xpath("//input[@id='user_username']"));
        userName.click();
        userName.sendKeys(user);

        WebElement emailInput = driver.findElement(By.xpath("//input[@id='user_email']"));
        emailInput.click();
        emailInput.sendKeys(email);

        WebElement password = driver.findElement(By.xpath("//input[@id='user_password']"));
        password.click();
        password.sendKeys(pass);

        WebElement password2 = driver.findElement(By.xpath("//input[@id='user_password_confirmation']"));
        password2.click();
        password2.sendKeys(pass);

        WebElement capca = driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']"));
        Thread.sleep(5000);
    }

    @Test
    public void artyomDulyaAuthorizationKinopoisk() {

        int expectedResult = 10;

        getDriver().get("https://hd.kinopoisk.ru/");

        WebElement button = getDriver().findElement(By.xpath("//button[@class='HeaderNavigationMenu_icon-container__fb6lu']"));
        button.click();
        WebElement filmsInput = getDriver().findElement(By.xpath("//span[text()='Фильмы']"));
        filmsInput.click();
        WebElement films = getDriver().findElement(
                By.xpath("//div[@id='__next']//div[@class='styles_container__TJkuX styles_categories__ly3pq']//a[1]"));
        WebElement onlineCinema = getDriver().findElement(
                By.xpath("//div[@id='__next']//div[@class='styles_container__TJkuX styles_categories__ly3pq']//a[2]"));
        WebElement genres = getDriver().findElement(
                By.xpath("//div[@id='__next']//div[@class='styles_container__TJkuX styles_categories__ly3pq']//a[3]"));
        WebElement countries = getDriver().findElement(
                By.xpath("//div[@id='__next']//div[@class='styles_container__TJkuX styles_categories__ly3pq']//a[4]"));
        WebElement years = getDriver().findElement(
                By.xpath("//div[@id='__next']//div[@class='styles_container__TJkuX styles_categories__ly3pq']//a[5]"));
        WebElement criticism = getDriver().findElement(
                By.xpath("//div[@id='__next']//div[@class='styles_container__TJkuX styles_categories__ly3pq']//a[6]"));
        WebElement series = getDriver().findElement(
                By.xpath("//div[@id='__next']//div[@class='styles_container__TJkuX styles_categories__ly3pq']//a[7]"));
        WebElement fees = getDriver().findElement(
                By.xpath("//div[@id='__next']//div[@class='styles_container__TJkuX styles_categories__ly3pq']//a[8]"));
        WebElement prizes = getDriver().findElement(
                By.xpath("//div[@id='__next']//div[@class='styles_container__TJkuX styles_categories__ly3pq']//a[9]"));
        WebElement directions = getDriver().findElement(
                By.xpath("//div[@id='__next']//div[@class='styles_container__TJkuX styles_categories__ly3pq']//a[10]"));

        WebElement[] cells = {films, onlineCinema, genres, countries, years, criticism,
                series, fees, prizes, directions};

        int actualResult = 0;
        for (int i = 0; i < cells.length; i++) {
            waitForElementToBeDisplayed(cells[i]);
            actualResult++;
        }
        Assert.assertEquals(actualResult, expectedResult);
    }


}
