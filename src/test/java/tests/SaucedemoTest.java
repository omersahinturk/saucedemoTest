package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SaucedemoPage;
import utils.ConfigReader;

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
        page.sendKeys(page.txtUsername,"standard_user");
        page.sendKeys(page.txtPassword,password);
        page.takeScreenshot();
        page.click(page.btnLogin);
        page.sleep(1000);
        page.takeScreenshot();
        //The url must be changed if logged in successfully
        page.assertNotEquals(currentURL,driver.getCurrentUrl());
    }

    @Test(testName = "US 302 - When locked out user tries to login",description = "When locked out user tries to login with right password I would like to see an error message \"Epic sadface: Sorry, this user has been locked out.")
    public void test02(){
        page.sendKeys(page.txtUsername,"locked_out_user");
        page.sendKeys(page.txtPassword,password);
        page.click(page.btnLogin);
        String expectedText = "Epic sadface: Sorry, this user has been locked out.";
        String err = driver.findElement(By.xpath("//h3")).getText();
        page.assertEquals(expectedText,err);
        page.sleep(1000);
        page.takeScreenshot();

    }



}
