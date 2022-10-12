package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SaucedemoPage;
import utils.ConfigReader;

public class SaucedemoTest extends BaseTest {
    SaucedemoPage page;

    @BeforeMethod
    public void setUp(){
        page = new SaucedemoPage(driver);
    }

    @Test(testName = "US 301 - Verify login",description = "US 301 - Verify standard_user can login with right password")
    public void test01(){
        String currentURL = driver.getCurrentUrl();
        page.sendKeys(page.txtUsername,ConfigReader.readProperty("username"));
        page.sendKeys(page.txtPassword,ConfigReader.readProperty("password"));
        page.takeScreenshot();
        page.click(page.btnLogin);
        page.sleep(2000);
        page.takeScreenshot();
        //The url must be changed if logged in successfully
        page.assertNotEquals(currentURL,driver.getCurrentUrl());
    }



}
