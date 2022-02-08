import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CreatePass {
    private WebDriver driver;
    private LoginPage loginPage;
    private LogAndPass logAndPass;
    private ProfilePage profilePage;
    private ChangeLogAndPass changeLogAndPass;
    private ButtonSelectors buttonSelectors;


    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        loginPage = new LoginPage(driver);
        logAndPass = new LogAndPass(driver);
        profilePage = new ProfilePage(driver);
        changeLogAndPass = new ChangeLogAndPass(driver);
        buttonSelectors = new ButtonSelectors(driver);

    }

    @Test
    public void test() {
        loginPage.open();
        logAndPass.setCreds("prosko123@yandex.ru", "virtual111");
        logAndPass.clickLogIn();
        profilePage.clickAccount();
        profilePage.clickChange();
        changeLogAndPass.changeSetCreds("virtual111", "virtual666", "virtual666");
        changeLogAndPass.clickChangeButton();
        buttonSelectors.clickProfileButton();
        buttonSelectors.clickExitButton();
        loginPage.open();
        logAndPass.setCreds("prosko123@yandex.ru", "virtual111");
        logAndPass.clickLogIn();
        WebElement errorMessage = driver.findElement(By.xpath("//span[@class=\"ng-binding ng-scope\"]"));
        String strText = errorMessage.getText();
        Assert.assertEquals("Неправильное имя пользователя или пароль.", strText);
        loginPage.open();
        logAndPass.setCreds("prosko123@yandex.ru", "virtual666");
        logAndPass.clickLogIn();
        profilePage.clickAccount();
        profilePage.clickChange();
        changeLogAndPass.changeSetCreds("virtual666", "virtual111", "virtual111");
        changeLogAndPass.clickChangeButton();

        driver.close();




//        driver.get("https://accounts.spotify.com/ru");

//        driver.findElement(By.id("login-username")).sendKeys("prosko123@yandex.ru");
//        driver.findElement(By.id("login-password")).sendKeys("virtual123");

 //       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
 //       driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click(); // Log in

//        driver.findElement(By.id("account-settings-link")).click(); // Account

//        driver.findElement(By.id("change_password")).click(); // Change

//        driver.findElement(By.id("old_password")).sendKeys("virtual123");
//        driver.findElement(By.id("new_password")).sendKeys("virtual321");
//        driver.findElement(By.id("new_password_confirmation")).sendKeys("virtual321");

//        driver.findElement(By.xpath("//*[@class=\"ButtonLegacy-o653de-1 crQDxy\"]")).click(); // Change pass

//        driver.findElement(By.xpath("//*[@class=\"mh-profile-title svelte-kdyqkb\"]")).click(); // profile
//        driver.findElement(By.xpath("//*[@class=\"mh-subtle svelte-11h1c9\"]")).click(); // Exit

        // Авторизуемся со старым паролем
//        driver.get("https://accounts.spotify.com/ru");

//        driver.findElement(By.id("login-username")).sendKeys("prosko123@yandex.ru");
//        driver.findElement(By.id("login-password")).sendKeys("virtual123");


//        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click(); // Log in

        //Проверяем что не смогли залогиниться
//        WebElement errorMessage = driver.findElement(By.xpath("//span[@class=\"ng-binding ng-scope\"]"));
//        String strText = errorMessage.getText();
//        Assert.assertEquals("Неправильное имя пользователя или пароль.", strText);


        // Логинемся с новым паролем

//        driver.get("https://accounts.spotify.com/ru");

//        driver.findElement(By.id("login-username")).sendKeys("prosko123@yandex.ru");
//        driver.findElement(By.id("login-password")).sendKeys("virtual321");

//        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click(); // Log in


        //Меняем пароль на изначальный

//        driver.findElement(By.id("account-settings-link")).click(); // Account

//        driver.findElement(By.id("change_password")).click(); // Change

//        driver.findElement(By.id("old_password")).sendKeys("virtual321");
//        driver.findElement(By.id("new_password")).sendKeys("virtual123");
//        driver.findElement(By.id("new_password_confirmation")).sendKeys("virtual123");


//        driver.findElement(By.xpath("//*[@class=\"ButtonLegacy-o653de-1 crQDxy\"]")).click(); // Change pass

//        driver.close();

    }
}
