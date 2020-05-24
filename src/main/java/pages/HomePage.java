package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageObjectBase {
    @FindBy(linkText = "Войти")
    private WebElement logInButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AuthorizationPage gotToAuthorizationPage() {
        logInButton.click();
        return new AuthorizationPage(driver);
    }
}
