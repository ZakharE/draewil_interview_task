package pages;

import helpers.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthorizationPage extends Page {
    private static final By LOGIN_FIELD_ID = By.id("passp-field-login");
    private static final By LOGIN_FIELD_XPATH = By.xpath("//button[@type='submit']");
    private static final By LOGIN_WRAPPER = By.id("passp-field-passwd");
    private static final By PASSWORD_FIELD_ID = By.id("passp-field-passwd");

    @FindBy(className = "passp-auth")
    private WebElement loginOverlay;

    public AuthorizationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MailBoxPage logIn(User user) {
        loginOverlay.findElement(LOGIN_FIELD_ID).sendKeys(user.getUserName());
        submitLogInButton();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_WRAPPER));
        loginOverlay.findElement(PASSWORD_FIELD_ID).sendKeys(user.getPassword());
        submitLogInButton();
        waitUntilNextPageIsNotLoaded();
        return new MailBoxPage(driver);
    }

    /**
     * wrapper to prevent StaleElementReferenceException
     */
    private void submitLogInButton() {
        WebElement logInButton = loginOverlay.findElement(LOGIN_FIELD_XPATH);
        logInButton.submit();
    }
}