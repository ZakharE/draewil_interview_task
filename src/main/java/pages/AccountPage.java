package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Getter
public class AccountPage extends Page {
    @FindBy(xpath = "//editable-list-item[@name='firstName']")
    private WebElement firstNameArea;
    @FindBy(xpath = "//editable-list-item[@name='lastName']")
    private WebElement lastNameArea;
    @FindBy(xpath = "//editable-list-item[@name='email']")
    private WebElement emailArea;
    @FindBy(xpath = "//editable-phone-input")
    private WebElement phoneArea;
    @FindBy(xpath = "//button[@type='button' and contains(., 'Edit')]")
    private WebElement editButton;

    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AccountPage editAccountData() {
        editButton.click();
        return this;
    }

    public AccountPage changeFirstName(String name) {
        WebElement input = firstNameArea.findElement(By.tagName("input"));
        input.clear();
        input.sendKeys(name);
        return this;
    }

    public AccountPage changeLastName(String lastName) {
        WebElement input = lastNameArea.findElement(By.tagName("input"));
        input.clear();
        input.sendKeys(lastName);
        return this;
    }

    public void saveChanges() {
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(editButton));
    }
}