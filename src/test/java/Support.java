import Runner.BaseWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Support extends BaseWaits {

    @Test
    public void testArtyomDulyaTopListsHeaderLoop() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        List<String> expectedResult = Arrays.asList("Top Rated", "Top Rated Real Languages",
                "Top Rated Esoteric Languages", "Top Rated Assembly Languages", "Top Hits",
                "New Languages this month", "New Comments");

        getDriver().get("https://www.99-bottles-of-beer.net/");

        List<String> actualResult = new ArrayList<>();

        WebElement topLists = getDriver().findElement(
                By.xpath("//ul[contains(@id, 'menu')]//a[normalize-space(text())='Top Lists']"));
        topLists.click();

        WebElement topRaterText = getDriver().
                findElement(By.xpath("//div[contains(@id, main)]//h2[normalize-space(text())='Top Rated']"));

        WebElement topRatedReal = getDriver().findElement(By.xpath("//ul[@id='submenu']//a[text()='Top Rated Real']"));
        WebElement topRatedRealText = getDriver().findElement(By.xpath("//h2[text()='Top Rated Real Languages']"));

        WebElement topRatedEsoteric = getDriver().findElement(By.xpath("//a[text()='Top Rated Esoteric']"));
        WebElement topRatedEsotericText = getDriver().findElement(By.xpath("//h2[text()='Top Rated Esoteric Languages']"));

        WebElement topRatedAssembly = getDriver().findElement(By.xpath("//a[@href='./toplist_assembly.html']"));
        WebElement topRatedAssemblyText = getDriver().findElement(By.xpath("//h2[text()='Top Rated Assembly Languages']"));

        WebElement topHits = getDriver().findElement(By.xpath("//a[text()='Top Hits']"));
        WebElement topHitsText = getDriver().findElement(By.xpath("//h2[text()='Top Hits']"));

        WebElement newLanguages = getDriver().findElement(By.xpath("//a[text()='New Languages this month']"));
        WebElement newLanguagesText = getDriver().findElement(By.xpath("//h2[text()='New Languages this month']"));

        WebElement newComments = getDriver().findElement(By.xpath("//a[text()='New Comments']"));
        WebElement newCommentsText = getDriver().findElement(By.xpath("//h2[text()='New Comments']"));

        List<WebElement> listTop = Arrays.asList(topRatedReal, topRatedEsoteric, topRatedAssembly, topHits,
                newLanguages, newComments);

        List<WebElement> listText = Arrays.asList(topRaterText, topRatedRealText, topRatedEsotericText, topRatedAssemblyText,
                topHitsText, newLanguagesText, newCommentsText);

        for(int i = 0; i < listTop.size(); i++) {
            listTop.get(i).click();
            actualResult.add(listText.get(i).getText());

        }

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testArtyomDulyaHeaderButton() throws InterruptedException {

        int expectedResult = 3;
        getDriver().get("https://openweathermap.org/");

        WebElement guide = getDriver().findElement(By.xpath("//ul//div//ul/li//a[@href='/guide']"));
        WebElement api = getDriver().findElement(By.xpath("//div[@id='desktop-menu']//ul//li[2]//a[text()='API']"));
        WebElement dashboard = getDriver().findElement((By.xpath("//div[@id='desktop-menu']//ul//li[3]//a[@href='/weather-dashboard']")));

        List<WebElement> headers = Arrays.asList(guide, api, dashboard);

        List<String> urls = Arrays.asList("https://openweathermap.org/guide", "https://openweathermap.org/api",
                "https://openweathermap.org/weather-dashboard");

        int count = 0;
        for (WebElement element : headers) {
            try {
                element.click();
            } catch (Exception e) {
                Thread.sleep(5000);
                element.click();
            }
            getDriver().getCurrentUrl();
            for (int j = 0; j < urls.size(); j++) {
                if (getDriver().getCurrentUrl().equals(urls.get(j))) {
                    count++;
                }
            }
            getDriver().navigate().back();
        }

        int actualResult = count;

        Assert.assertEquals(actualResult, expectedResult);
    }
}
