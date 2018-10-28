import java.io.File;
import java.util.List;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.SearchPage;
import pageObjects.SearchResults;


public class Basic {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", getAppPath());
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com";
    }

    @Test
    public void testSearch() {
        driver.get(baseUrl);
        SearchPage.SearchField(driver).sendKeys("Hello world!");
        SearchPage.SubmitSearch(driver).submit();
        List<WebElement> resultList =  SearchResults.resultsArea(driver).findElements(By.className("g"));
        resultList.get(4).findElement(By.tagName("a")).click();
        List<WebElement> helloCheck = driver.findElements(By.xpath("//*[contains(text(), 'hello world')]"));
        Assert.assertTrue("Not Found!", helloCheck.size() > 0);
    }

    private final String getAppPath() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("chromedriver.exe").getFile());
        return file.getAbsolutePath();
    }

}