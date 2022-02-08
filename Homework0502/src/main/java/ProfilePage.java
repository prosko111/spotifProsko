import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "account-settings-link")
    private WebElement accountButton;
    @FindBy(id = "change_password")
    private WebElement changePassButton;

    public void clickAccount() {
        accountButton.click();

    }

    public void clickChange() {
        changePassButton.click();
    }

}
