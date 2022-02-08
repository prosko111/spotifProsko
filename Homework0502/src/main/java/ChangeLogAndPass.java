import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangeLogAndPass {
    private WebDriver driver;

    public ChangeLogAndPass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, ChangeLogAndPass.class); //Можем использовать this, вместо LoginPage.class
    }

    @FindBy(id = "old_password")
    private WebElement oldPassword;
    @FindBy(id = "new_password")
    private WebElement newPassword;
    @FindBy(id = "new_password_confirmation")
    private WebElement newPasswordConfirmation;
    @FindBy(xpath = "//*[@class=\"ButtonLegacy-o653de-1 crQDxy\"]")
    private WebElement changeButton;

    public void changeSetCreds(String oldPass, String newPass, String newPassConfirm) {
        oldPassword.sendKeys(oldPass);
        newPassword.sendKeys(newPass);
        newPasswordConfirmation.sendKeys(newPassConfirm);

    }

    public void clickChangeButton() {
        changeButton.click();
    }
}
