import java.io.File;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class Basic {
    private WebDriver driver;
    private String baseUrl;


    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", getAppPath());
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com.ua/";
    }


    @Test
    public void testSearch() {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys("Selenium Webdriver");
        driver.findElement(By.xpath("//input[@value=\"Поиск в Google\"]")).click();
    }

    private final String getAppPath() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("chromedriver.exe").getFile());
        return file.getAbsolutePath();
    }

}