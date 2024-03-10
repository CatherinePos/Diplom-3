import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConstructorSection {

    private WebDriver driver;
    final static String URL = "https://stellarburgers.nomoreparties.site/";
    private By labelAbout = By.xpath(".//h1[@class='text text_type_main-large mb-5 mt-10']");
    private By labelConstructor = By.xpath(".//a[@href='/']");
    private By logoStellarBurgers = By.xpath("//*[@xmlns='http://www.w3.org/2000/svg']");
    private By labelBuns = By.xpath("//*[text()='Булки']/.");
    private By labelBunVisible = By.xpath("//div[contains(span/text(),'Булки') and contains(@class,'current')]");
    private By labelSauces = By.xpath("//*[text()='Соусы']/.");
    private By labelSauceVisible = By.xpath("//div[contains(span/text(),'Соусы') and contains(@class,'current')]");
    private By labelFillings = By.xpath("//*[text()='Начинки']/.");
    private By labelFillingVisible = By.xpath("//div[contains(span/text(),'Начинки') and contains(@class,'current')]");

    public ConstructorSection(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLabelConstructor() {
        driver.findElement(labelConstructor).click();
    }

    public void clickLogoStellarBurgers() {
        driver.findElement(logoStellarBurgers).click();
    }

    public void clickLabelBuns() {
        driver.findElement(labelBuns).click();
    }

    public void clickLabelSauces() {
        driver.findElement(labelSauces).click();
    }

    public void clickLabelFillings() {
        driver.findElement(labelFillings).click();
    }

    public void verifyLoadConstructorSection() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(labelAbout).getText() != null));
        String ExpectedText = "Соберите бургер";
        String ActualText = driver.findElement(labelAbout).getText();
        Assert.assertEquals("Текст не соответствует ожидаемому результату", ExpectedText, ActualText);
    }

    public Boolean checkVisibleBun() {
        return driver.findElement(labelBunVisible).isDisplayed();
    }

    public Boolean checkVisibleSauces() {
        return driver.findElement(labelSauceVisible).isDisplayed();
    }

    public Boolean checkVisibleFillings() {
        return driver.findElement(labelFillingVisible).isDisplayed();
    }
}

