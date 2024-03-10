package Pojo;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {

    private WebDriver driver;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private By buttonExit = By.xpath(".//button[text()='Выход']");
    private By labelLoginPage = By.xpath(".//p[@class='undefined text text_type_main-default text_color_inactive mb-4']");

    public void clickButtonExit() {
        driver.findElement(buttonExit).click();
    }

    public void verifyLogout() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(labelLoginPage).getText() != null));
        String ExpectedText = "Вы — новый пользователь? Зарегистрироваться";
        String ActualText = driver.findElement(labelLoginPage).getText();
        Assert.assertEquals("Текст не соответствует ожидаемому результату", ExpectedText, ActualText);
    }

    public void waitForLoadPage() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(buttonExit).getText() != null));
    }
}

