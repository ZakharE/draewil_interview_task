package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonHeader {
    private static final By LOG_OUT_BUTTON_X_PATH = By.xpath("//li/a[contains(@href, 'logout')]");
    private final WebDriver driver;

    @FindBy(css = "a img.user-pic__image")
    private WebElement userPictureDropDown;

    public CommonHeader(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void logOut() {
        userPictureDropDown.click();
        driver.findElement(LOG_OUT_BUTTON_X_PATH).click();
    }
}