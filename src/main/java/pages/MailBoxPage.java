package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Slf4j
public class MailBoxPage extends LogOutPage {
    @FindBy(xpath = "//input[@placeholder='Поиск']")
    WebElement searchField;
    private final String mailSubjectXPath = "//span[@title='%s']/..";

    public MailBoxPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> findEmailOnPage(String mailSubject) {
        return driver.findElements(By.xpath(String.format(mailSubjectXPath, mailSubject)));

    }

    public EmailPage clickOnEmailSubject(WebElement email) {
        email.click();
        waitUntilNextPageIsNotLoaded();
        return new EmailPage(driver);
    }

    public MailBoxPage searchEmailInInbox(String mailSubject) {
        searchField.sendKeys(mailSubject);
        searchField.sendKeys(Keys.ENTER);
        return this;
    }
}
