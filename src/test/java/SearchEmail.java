import helpers.Email;
import helpers.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.EmailPage;
import pages.HomePage;
import pages.MailBoxPage;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchEmail {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mail.yandex.ru");
    }

    @Test(dataProvider = "credentials", dataProviderClass = TestsDataProvider.class)
    public void findsOneEmail_ifSubjectIsSpecified(User user, Email email) {
        String inboxPageTitle = "Входящие — Яндекс.Почта";

        MailBoxPage mailBoxPage = new HomePage(driver)
                .goToAuthorizationPage()
                .logIn(user);
        assertTrue(driver.getTitle().contains(inboxPageTitle), "Wrong page title");

        List<WebElement> emailsOnPage = mailBoxPage
                .searchEmailInInbox(email.getSubject())
                .findEmailOnPage(email.getSubject());
        assertEquals(emailsOnPage.size(), 1);

        EmailPage emailPage = mailBoxPage.openEmail(emailsOnPage.get(0));
        assertEmailsEqual(email, emailPage);

        emailPage.getHeader().logOut();
    }

    private void assertEmailsEqual(Email expectedEmail, EmailPage emailPage) {
        assertEquals(emailPage.getMailSender().getText(), expectedEmail.getSender());
        assertEquals(emailPage.getMailSubject().getText(), expectedEmail.getSubject());
        assertEquals(emailPage.getMailContent().getText(), expectedEmail.getContent());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
