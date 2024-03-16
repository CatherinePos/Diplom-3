import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pojo.*;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        return new Object[][]{
                {"Катерина", "posty@yandex.ru", "FatoR123"},
        };
    }

    private WebDriver driver;
    private final By EnterModal = By.xpath(".//div/h2[text()='Вход']");

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
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(EnterModal).getText() != null));
        String ExpectedText = "Вход";
        String ActualText = driver.findElement(EnterModal).getText();
        Assert.assertEquals("Текст не соответствует ожидаемому результату", ExpectedText, ActualText);
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

    @Test
    @Description("Удаление пользователя")
    public void testDeleteUser() {
        DeleteUser deleteUser = new DeleteUser(driver);
        Response correctLoginWithExistingUser = deleteUser.getDataUser(new User(Email, Password, Name));
        accessToken = correctLoginWithExistingUser.path("accessToken");
        if (accessToken != null) deleteUser.getDeleteUser(accessToken);
    }
}