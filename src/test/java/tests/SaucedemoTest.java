package tests;

import base.BaseTest;
import data.DataProviders;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SaucedemoPage;
import utils.ConfigReader;

import java.util.List;

public class SaucedemoTest extends BaseTest {
    SaucedemoPage page;
    public String password = "secret_sauce";

    @BeforeMethod
    public void setUp(){
        page = new SaucedemoPage(driver);
    }

    @Test(testName = "US 301 - Verify login",description = "US 301 - Verify standard_user can login with right password")
    public void test01(){

        String currentURL = driver.getCurrentUrl();
        page.login();
        //The url must be changed if logged in successfully
        page.assertNotEquals(currentURL,driver.getCurrentUrl());
        page.takeScreenshot();
        page.sleep(1000);
    }

    @Test(testName = "US 302 - When locked out user tries to login",description = "When locked out user tries to login with right password I would like to see an error message \"Epic sadface: Sorry, this user has been locked out.")
    public void test02(){
        page.sendKeys(page.txtUsername,"locked_out_user");
        page.sendKeys(page.txtPassword,password);
        page.click(page.btnLogin);
        String expectedText = "Epic sadface: Sorry, this user has been locked out.";
        String err = driver.findElement(By.xpath("//h3")).getText();
        page.assertEquals(expectedText,err);
        page.takeScreenshot();
        page.sleep(1000);


    }

    @Test(testName = "US 303 - When problem_user logs in", description = "all items on homepage should display same images")
    public void test03(){
        page.sendKeys(page.txtUsername,"problem_user");
        page.sendKeys(page.txtPassword,password);
        page.click(page.btnLogin);
        List<WebElement> imgList = page.imageList;

        //Retrieve the first image source which would be the same
        String expectedImg = imgList.get(0).getAttribute("src");
        for(WebElement element: imgList){
           page.assertEquals(expectedImg,element.getAttribute("src"));
        }
        page.takeScreenshot();
        page.sleep(1000);
    }
    /*
    - All items ,  - About,  Logout,  Reset app state
    */
    //dataProvider = "roles", dataProviderClass = DataProviders.class)
  /*  @Test(dataProvider = "nav buttons", dataProviderClass = DataProviders.class,
            testName = "US 304 - test display options",
            description = "I need an option to see navigation menu. When user clicks the button it should display following buttons:")*/

    @Test(testName = "US 304 - test display options", description = "I need an option to see navigation menu. When user clicks the button it should display following buttons:")
    public void test04(){
        page.login();
        page.click(page.btnBurgerMenu);
        String[] menuList= new String[] {"All Items","About","Logout","Reset App State"};
        for(String item:menuList){
            Assert.assertTrue(page.verifyLinkedMenu(item));
        }
        page.sleep(1000);

    }

    @Test(testName = "US 305 - Footer of the page should be \"© 2022 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy\"")
    public void test05() {
        page.login();
        page.click(page.btnBurgerMenu);
        String expected = "© 2022 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
        String actual = page.getText(page.footerTxt);
        page.assertEquals(actual, expected);

        page.takeScreenshot();
        page.sleep(1000);
    }



}
