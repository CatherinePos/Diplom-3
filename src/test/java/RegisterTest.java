import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pojo.*;

@RunWith(Parameterized.class)
public class RegisterTest {
    public String accessToken;
    private final String Name;
    private final String Email;
    private final String Password;

    public RegisterTest(String Name, String Email, String Password) {
        this.Name = Name;
        this.Email = Email;
        this.Password = Password;
    }

    @Parameterized.Parameters
    public static Object[][] enterData() {
        return new Object[][] {
                { "Катерина", "posty@yandex.ru", "FatoR123" },
        };
    }

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/register");
    }

    @After
    public void setDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Проверка успешной регистрации")
    public void testSuccessRegister() {
        RegisterPage objRegisterPage = new RegisterPage(driver);
        objRegisterPage.enterName(Name);
        objRegisterPage.enterEmail(Email);
        objRegisterPage.enterPassword(Password);
        objRegisterPage.clickButtonRegister();
        DeleteUser deleteUser = new DeleteUser();
        Response correctLoginWithExistingUser = deleteUser.getDataUser(new User(Email,Password, Name));
        accessToken = correctLoginWithExistingUser.path("accessToken");
        deleteUser.getDeleteUser(accessToken);
    }

    @Test
    @DisplayName("Проверка ошибки для некорректного пароля")
    public void testErrorRegisterWithIncorrectPassword() {
        RegisterPage objRegisterPage = new RegisterPage(driver);
        objRegisterPage.enterName("TestName");
        objRegisterPage.enterEmail("TestEmail@email.com");
        objRegisterPage.enterPassword("12345");
        objRegisterPage.clickButtonRegister();
        objRegisterPage.verifyErrorRegisterWithIncorrectPassword();
    }

}