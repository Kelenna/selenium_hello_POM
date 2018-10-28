package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResults {
    private static WebElement element = null;

    public static WebElement resultsArea(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id='rso']/div[2]/div"));

        return element;
    }

}
