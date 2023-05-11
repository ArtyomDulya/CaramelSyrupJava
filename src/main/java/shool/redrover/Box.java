package shool.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;

public class Box {

    public void artyomDulyaHeaderButtonTest() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        driver.get("https://openweathermap.org/");
        Thread.sleep(5000);

        WebElement guide = driver.findElement(By.xpath("//ul//div//ul/li//a[@href='/guide']"));
        WebElement api = driver.findElement(By.xpath("//div[@id='desktop-menu']//ul//li[2]//a[@href='/api']"));
        WebElement dashboard = driver.findElement((By.xpath("//div[@id='desktop-menu']//ul//li[3]//a[@href='/weather-dashboard']")));
        WebElement marketplace = driver.findElement(By.xpath("//div[@id='desktop-menu']" +
                "//ul//li[4]//a[@href='https://home.openweathermap.org/marketplace']"));
        WebElement pricing = driver.findElement(By.xpath("//div[@id='desktop-menu']//ul//li[5]//a[@href='/price']"));
        WebElement maps = driver.findElement(By.xpath("//div[@id='desktop-menu']//ul//li[6]//a[@href='/weathermap']"));
        WebElement ourInitiatives = driver.findElement(By.xpath("//div[@id='desktop-menu']//ul//li[7]//a[@href='/our-initiatives']"));
        WebElement partners = driver.findElement(By.xpath("//div[@id='desktop-menu']//ul//li[8]//a[@href='/examples']"));
        WebElement blog = driver.findElement(By.xpath("//div[@id='desktop-menu']" +
                "//ul//li[9]//a[@href='https://openweather.co.uk/blog/category/weather']"));
        WebElement forBusiness = driver.findElement(By.xpath("//div[@id='desktop-menu']//ul//li[10]//a[@href='https://openweather.co.uk']"));
        WebElement signIn = driver.findElement(By.xpath("//div[@id='desktop-menu']//ul//li[11]//a[text()='Sign in']"));

        WebElement support = driver.findElement(By.xpath("//div[@id='desktop-menu']//ul//li[11]//a[text()='Sign in']"));
        WebElement supportFAQ = driver.findElement(By.xpath("//ul[@id='support-dropdown-menu']//li//a[@href='/faq']"));
        WebElement supportHowToStart = driver.findElement(By.xpath("//ul[@id='support-dropdown-menu']//li[2]//a[@href='/appid']"));
        WebElement supportAsk = driver.findElement(By.xpath("//ul[@id='support-dropdown-menu']" +
                "//li[3]//a[@href='https://home.openweathermap.org/questions']"));

        WebElement[] headers = {guide, api, dashboard, marketplace, pricing, maps, ourInitiatives, partners
                , blog, forBusiness, signIn};

        ArrayList<String> urls = new ArrayList<String>(10);
        urls.add("https://openweathermap.org/guide");
        urls.add("https://openweathermap.org/api");
        urls.add("https://openweathermap.org/weather-dashboard");
        urls.add("https://home.openweathermap.org/marketplace");
        urls.add("https://openweathermap.org/price");
        urls.add("https://openweathermap.org/weathermap?basemap=map&cities=true&layer=temperature&lat=50.2786&lon=57.1245&zoom=5");
        urls.add("https://openweathermap.org/our-initiatives");
        urls.add("https://openweathermap.org/examples");
        urls.add("https://openweather.co.uk/blog/category/weather");
        urls.add("https://openweather.co.uk/");
        urls.add("https://home.openweathermap.org/users/sign_in");
        int count = 0;

        WebElement backs = driver.findElement(By.xpath("//a[@href='/']"));

        for (int i = 0; i < headers.length; i++) {
            headers[i].click();
            Thread.sleep(5000);

            if(driver.getCurrentUrl().equals(urls.get(0))) {
                count++;
            }

            driver.navigate().back();

            if(headers[i] == marketplace) {
                backs.click();
            }
        }

        int actualResult = count;
        int expectedResult = 11;

        Assert.assertEquals(actualResult, expectedResult);
    }
}
