package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
    private static WebElement element = null;

    public static WebElement SearchField(WebDriver driver){

        element = driver.findElement(By.xpath("//input[@id='lst-ib']"));

        return element;
    }

    public static WebElement SubmitSearch(WebDriver driver){

         element = driver.findElement(By.xpath("//input[@value=\"Поиск в Google\"]"));

        return element;
    }

}




