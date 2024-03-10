package Pojo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;

    private By fieldEmail = By.xpath(".//input[@name='name']");
    private By fieldPassword = By.xpath(".//input[@name='Пароль']");
    private By buttonEnterMain = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");
    private By buttonEnterModal = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private By buttonEnterPersonal = By.xpath(".//a[@href='/account']");
    private By buttonEnterRegistration = By.xpath(".//a[@href='/login']");
    private By buttonEnterForgot = By.xpath(".//a[@href='/login']");


    public LoginPage(WebDriver driver) { this.driver = driver; }

    public void clickButtonEnterMain() { driver.findElement(buttonEnterMain).click(); }
    public void clickButtonEnterModal() { driver.findElement(buttonEnterModal).click(); }
    public void clickButtonEnterPersonal() { driver.findElement(buttonEnterPersonal).click(); }
    public void clickButtonEnterRegistration () { driver.findElement(buttonEnterRegistration).click(); }
    public void clickButtonEnterForgot () { driver.findElement(buttonEnterForgot).click(); }

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

}