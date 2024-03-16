package Pojo;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalPage {

    private WebDriver driver;
    private By labelAbout = By.xpath(".//p[@class='Account_text__fZAIn text text_type_main-default']");

    public PersonalPage(WebDriver driver) { this.driver = driver; }

    public void verifyLoadPersonalPage() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(labelAbout).getText() != null));
        String ExpectedText = "В этом разделе вы можете изменить свои персональные данные";
        String ActualText = driver.findElement(labelAbout).getText();
        Assert.assertEquals("Текст не соответствует ожидаемому результату", ExpectedText, ActualText);
    }
}
