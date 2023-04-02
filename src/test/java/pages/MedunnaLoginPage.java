package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MedunnaLoginPage {


    public MedunnaLoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id ="account-menu" )
    public WebElement signSymbol;

    @FindBy(id = "login-item")
    public WebElement signInButton;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "rememberMe")
    public WebElement rememberMeCheckbox;

    @FindBy(xpath = "(//span[.='Sign in'])[3]")
    public WebElement signInButton2;

    @FindBy(id = "username")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(xpath = " //button[@type='submit']")
    public WebElement signInSubmitButton;

}
