package pages;

import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ExtentManager;

import java.util.List;


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

    @FindBy(xpath = "//div[@class='inventory_item_img']//img")
    public List<WebElement> imageList;

    @FindBy(id = "react-burger-menu-btn")
    public WebElement btnBurgerMenu;

    @FindBy(className = "footer_copy")
    public WebElement footerTxt;

    public void login(){
        this.sendKeys(txtUsername,"standard_user");
        this.sendKeys(txtPassword,"secret_sauce");
        this.click(btnLogin);
    }

    public boolean verifyLinkedMenu(String linkText){
        String path = "//a[text()='" + linkText +"']";
        List<WebElement> linksItems = driver.findElements(By.xpath(path));
        if (linksItems.size() > 0) {
            this.highlightElement(linksItems.get(0));
            logInfo("Link text=" + linkText + ", xpath=" + path);
            return true;
        }
        else {
            logWarning("Can't find: " + path);
        return false;
        }

    }


}
