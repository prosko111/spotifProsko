import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogAndPass {
    private WebDriver driver;

    public LogAndPass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, LoginPage.class); //Можем использовать this, вместо LoginPage.class
    }

    @FindBy(id = "login-username")
    private WebElement emailInput;
    @FindBy(id = "login-password")
    private WebElement passInput;
    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private WebElement loginButton;

    public void setCreds(String email, String password) {
        emailInput.sendKeys(email);
        passInput.sendKeys(password);
    }

    public void clickLogIn() {
        loginButton.click();// Log in
    }
}
