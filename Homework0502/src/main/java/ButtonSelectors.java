import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ButtonSelectors {
    private WebDriver driver;

    public ButtonSelectors(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class=\"mh-profile-title svelte-kdyqkb\"]")
    private WebElement profileButton;
    @FindBy(xpath = "//*[@class=\"mh-subtle svelte-11h1c9\"]")
    private WebElement exitButton;

    public void clickProfileButton() {
        profileButton.click();
    }

    public void clickExitButton() {
        exitButton.click();
    }
}
