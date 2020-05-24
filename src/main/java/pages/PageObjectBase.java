package pages;

import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@AllArgsConstructor
public class PageObjectBase {
      WebDriver driver;
      protected void waitUntilNextPageIsNotLoaded(){
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.not(ExpectedConditions.titleIs(driver.getTitle())));
      }
}
