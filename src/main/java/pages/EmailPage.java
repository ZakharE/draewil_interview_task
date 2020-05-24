package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class EmailPage extends LogOutPage {
    @FindBy(css = "span.mail-Message-Toolbar-Subject-Wrapper")
    private WebElement mailSubject;
    @FindBy(css = "span.mail-Message-Sender-Email.mail-ui-HoverLink-Content")
    private WebElement mailSender;
    @FindBy(css = "div.js-message-body-content.mail-Message-Body-Content")
    private WebElement mailContent;


    public EmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


}
