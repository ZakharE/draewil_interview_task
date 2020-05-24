package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Slf4j
public class MailBoxPage extends Page {
    private static final String MAIL_SUBJECT_X_PATH = "//span[@title='%s']/..";

    @FindBy(xpath = "//input[@placeholder='Поиск']")
    private WebElement searchField;

    MailBoxPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> findEmailOnPage(String mailSubject) {
        return driver.findElements(By.xpath(String.format(MAIL_SUBJECT_X_PATH, mailSubject)));
    }

    public EmailPage openEmail(WebElement email) {
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
