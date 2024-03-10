package Pojo;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

    private WebDriver driver;

    private By fieldName = By.xpath(".//label[text()='Имя']/../input");
    private By fieldEmail = By.xpath(".//label[text()='Email']/../input");
    private By fieldPassword = By.xpath(".//input[@name='Пароль']");
    private By buttonRegister = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private By labelIncorrectPassword = By.xpath(".//p[@class='input__error text_type_main-default']");

    public RegisterPage(WebDriver driver) { this.driver = driver; }

    public void clickButtonRegister() { driver.findElement(buttonRegister).click(); }

    public void enterName (String Name) {
        new WebDriverWait(driver, 3);
        driver.findElement(fieldName).click();
        driver.findElement(fieldName).sendKeys(Name);
    }

    public void enterEmail (String Email) {
        new WebDriverWait(driver, 3);
        driver.findElement(fieldEmail).click();
        driver.findElement(fieldEmail).sendKeys(Email);
    }

    public void enterPassword (String Password) {
        new WebDriverWait(driver, 3);
        driver.findElement(fieldPassword).click();
        driver.findElement(fieldPassword).sendKeys(Password);
    }

    public void verifyErrorRegisterWithIncorrectPassword() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(labelIncorrectPassword).getText() != null));
        String ExpectedText = "Некорректный пароль";
        String ActualText = driver.findElement(labelIncorrectPassword).getText();
        Assert.assertEquals("Текст не соответствует ожидаемому результату", ExpectedText, ActualText);
    }

}