package pages;

import helpers.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class AuthorizationPage extends PageObjectBase {
    @FindBy(className = "passp-auth")
    private WebElement loginOverlay;
    private final By loginFieldId = By.id("passp-field-login");
    private final By loginFieldXpath = By.xpath("//button[@type='submit']");
    private final By loginWrapper = By.id("passp-field-passwd");
    private final By passwordFieldId = By.id("passp-field-passwd");

    public AuthorizationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MailBoxPage logIn(User user) {
        loginOverlay.findElement(loginFieldId).sendKeys(user.getUserName());
        submitLogInButton();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginWrapper));
        loginOverlay.findElement(passwordFieldId).sendKeys(user.getPassword());
        submitLogInButton();
        waitUntilNextPageIsNotLoaded();
        return new MailBoxPage(driver);
    }

    //wrapper to prevent StaleElementReferenceException
    private void submitLogInButton() {
        WebElement logInButton = loginOverlay.findElement(loginFieldXpath);
        logInButton.submit();
    }

}
