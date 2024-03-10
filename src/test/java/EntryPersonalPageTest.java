import Pojo.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EntryPersonalPageTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(ConstructorSection.URL);
    }

    @After
    public void setDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Проверка перехода по клику на «Личный кабинет»")
    public void testEntryPersonalPage() {
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickButtonEnterMain();
        objLoginPage.enterEmail("posty@yandex.ru");
        objLoginPage.enterPassword("FatoR123");
        objLoginPage.clickButtonEnterModal();
        objLoginPage.clickButtonEnterPersonal();
        PersonalPage objPersonalPage = new PersonalPage(driver);
        objPersonalPage.verifyLoadPersonalPage();
    }

}