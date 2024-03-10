import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import Pojo.WebDriverCreator;
import Pojo.*;

public class ConstructorSectionTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = WebDriverCreator.createWebDriver();
        driver.get(ConstructorSection.URL);
    }

    @After
    public void setDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор по клику на «Конструктор»")
    public void testEntryConstructorSectionWithClickLabelConstructor() {
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickButtonEnterMain();
        objLoginPage.enterEmail("posty@yandex.ru");
        objLoginPage.enterPassword("FatoR123");
        objLoginPage.clickButtonEnterModal();
        objLoginPage.clickButtonEnterPersonal();
        ConstructorSection objConstructorSection = new ConstructorSection(driver);
        objConstructorSection.clickLabelConstructor();
        objConstructorSection.verifyLoadConstructorSection();
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    public void testEntryConstructorSectionWithClickLogoStellarBurgers() {
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickButtonEnterMain();
        objLoginPage.enterEmail("posty@yandex.ru");
        objLoginPage.enterPassword("Fator123");
        objLoginPage.clickButtonEnterModal();
        objLoginPage.clickButtonEnterPersonal();
        ConstructorSection objConstructorSection = new ConstructorSection(driver);
        objConstructorSection.clickLogoStellarBurgers();
        objConstructorSection.verifyLoadConstructorSection();
    }

    @Test
    @DisplayName("Проверка перехода к разделу «Булки»")
    public void testEntryBuns() {
        ConstructorSection objConstructorSection = new ConstructorSection(driver);
        objConstructorSection.clickLabelSauces();
        objConstructorSection.clickLabelBuns();
        objConstructorSection.checkVisibleBun();
    }

    @Test
    @DisplayName("Проверка перехода к разделу «Соусы»")
    public void testEntrySauces() {
        ConstructorSection objConstructorSection = new ConstructorSection(driver);
        objConstructorSection.clickLabelSauces();
        objConstructorSection.checkVisibleSauces();
    }

    @Test
    @DisplayName("Проверка перехода к разделу «Начинки»")
    public void testEntryFillings() {
        ConstructorSection objConstructorSection = new ConstructorSection(driver);
        objConstructorSection.clickLabelFillings();
        objConstructorSection.checkVisibleFillings();
    }

} 