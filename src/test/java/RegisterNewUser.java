import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.DashboardPage;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;

public class RegisterNewUser {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://preprod-business.draewil.net/#!/registration");
    }

    @Test(dataProviderClass = UserInfoDataProvider.class, dataProvider = "userInfo")
    public void changeAccountInfoOfNewUser(UserInfo userInfo) {

        HomePage homePage = new HomePage(driver);
        homePage.setFirstName(userInfo.getFirstName())
                .setLastName(userInfo.getLastName())
                .setEmail(userInfo.getEmail())
                .setPhoneNumber(userInfo.getPhone())
                .setPassword(userInfo.getPassword())
                .setInviteCode(userInfo.getInviteCode())
                .register();
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.goToAccountSettings();
        AccountPage accountPage = new AccountPage(driver);
        assertAccountPAgeHasProperValues(accountPage, userInfo);

        String newName = "new";
        String newLastName = "name";
        userInfo.setFirstName(newName);
        userInfo.setLastName(newLastName);
        accountPage.editAccountData().changeFirstName(newName).changeLastName(newLastName).saveChanges();

        assertAccountPAgeHasProperValues(accountPage, userInfo);
    }

    private void assertAccountPAgeHasProperValues(AccountPage accountPage, UserInfo userInfo) {
        assertThat(accountPage.getFirstNameArea().getText(), Matchers.containsString(userInfo.getFirstName()));
        assertThat(accountPage.getLastNameArea().getText(), Matchers.containsString(userInfo.getLastName()));
        assertThat(accountPage.getEmailArea().getText(), Matchers.containsString(userInfo.getEmail()));
        assertThat(accountPage.getPhoneArea().getText(), Matchers.containsString(userInfo.getPhone()));
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}