package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SaucedemoPage extends BasePage {

    public SaucedemoPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    public WebElement txtUsername;

    @FindBy(id = "password")
    public WebElement txtPassword;

    @FindBy(id = "login-button")
    public WebElement btnLogin;

}
