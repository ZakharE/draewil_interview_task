package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Page {
    @FindBy(xpath = "//combined-text-input[@label='First name']//input")
    private WebElement firstNameField;
    @FindBy(xpath = "//combined-text-input[@label='Last name']//input")
    private WebElement lastNameField;
    @FindBy(xpath = "//combined-text-input[@label='Email address']//input")
    private WebElement emailField;
    @FindBy(xpath = "//combined-text-input[@label='Password']//input")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@name='phonePhoneNumber']")
    private WebElement phoneNumberField;
    @FindBy(xpath = "//combined-text-input[@label='Invite code']//input")
    private WebElement invitationCodeField;
    @FindBy(xpath = "//button[@class='c-registration_button']")
    private WebElement registrationButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage setFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
        return this;
    }

    public HomePage setLastName(String lastName) {
        lastNameField.sendKeys(lastName);
        return this;
    }

    public HomePage setEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public HomePage setPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public HomePage setInviteCode(String inviteCode) {
        invitationCodeField.sendKeys(inviteCode);
        return this;
    }

    public void register() {
        registrationButton.submit();
    }


    public HomePage setPhoneNumber(String phone) {
        phoneNumberField.sendKeys(phone);
        return this;
    }
}