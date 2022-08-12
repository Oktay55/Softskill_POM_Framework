package Test;

import POM.LoginPageElements;
import Utilis.BaseDriver;
import javafx.scene.layout.Priority;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_LoginTest extends BaseDriver {

    LoginPageElements loginPageElements;

    @Test
    public void loginPositiveTest() {

        String expectedUserName = "oktaysaglam55@gmail.com";
        String expectedPassword = "#Samsunspor55";

        String expectedURL = "https://campus.techno.study/user-courses";


        loginPageElements = new LoginPageElements(driver);

        String actualUserName = "oktaysaglam55@gmail.com";
        loginPageElements.usernameInput.sendKeys(actualUserName);
        String actualPassword = "#Samsunspor55";
        loginPageElements.passwordInput.sendKeys(actualPassword);

        loginPageElements.loginInput.click();

        Assert.assertEquals(actualUserName, expectedUserName);

        Assert.assertEquals(actualPassword, expectedPassword);

        String actualURL = driver.getCurrentUrl();

        if(!actualURL.equals(expectedURL)) {
            System.out.println("Successfully, loaded on the homepage");
        } else {
            Assert.fail("Failed");
        }

    }
    @Test(dependsOnMethods = "loginPositiveTest")
    public void loginNegativeTest() {

        String expectedUserName = "oktaysaglam55@gmail.com";
        String expectedPassword = "#Samsunspor55";

        loginPageElements = new LoginPageElements(driver);

        String actualUserName = "abc";
        loginPageElements.usernameInput.sendKeys(actualUserName);
        String actualPassword = "123";
        loginPageElements.passwordInput.sendKeys(actualPassword);

        loginPageElements.loginInput.click();

        Assert.assertNotEquals(actualUserName, expectedUserName);

        Assert.assertNotEquals(actualPassword, expectedPassword);


        String invalidText = loginPageElements.invalidMessage.getText();

        boolean isInvalidTextDisplayed = loginPageElements.invalidMessage.isDisplayed();

        Assert.assertTrue(isInvalidTextDisplayed);
        Assert.assertEquals(invalidText, "Invalid username or password");



    }

}
