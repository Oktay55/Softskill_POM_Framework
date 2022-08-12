package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPageElements {

    public LoginPageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }
    @FindBy(css = "input[placeholder='Username']")
    public WebElement usernameInput;

    @FindBy(css = "input[placeholder='Password']")
    public WebElement passwordInput;

    @FindBy(css = "button[aria-label='LOGIN']")
    public WebElement loginInput;

    @FindBy(xpath = "//*[text()='Invalid username or password']")
    public WebElement invalidMessage;



}
