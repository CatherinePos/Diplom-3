import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import Pojo.WebDriverCreator;
import org.openqa.selenium.chrome.ChromeDriver;
import Pojo.LoginPage;

@RunWith(Parameterized.class)
public class LoginTest {

    private final String Email;
    private final String Password;

    public LoginTest(String Email, String Password) {
        this.Email = Email;
        this.Password = Password;
    }

    @Parameterized.Parameters
    public static Object[][] enterData() {
        return new Object[][] {
                { "posty@yandex.ru", "FatoR123"},
        };
    }

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = WebDriverCreator.createWebDriver();
    }
    @After
    public void setDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginMainPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site");
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickButtonEnterMain();
        objLoginPage.enterEmail(Email);
        objLoginPage.enterPassword(Password);
        objLoginPage.clickButtonEnterModal();
    }
}