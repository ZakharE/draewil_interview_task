package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends Page {
    @FindBy(xpath = "//a[@ui-sref='main.account']")
    private WebElement accountButton;

    public DashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToAccountSettings() {
        accountButton.click();
    }
}
