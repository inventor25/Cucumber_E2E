package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MedunnaPage {


    public MedunnaPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath ="//li[@id='account-menu']" )
    public WebElement signSymbol;

    @FindBy(xpath = "(//*[@data-icon='sign-in-alt'])[1]")
    public WebElement signInButton;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "(//span[.='Sign in'])[3]")
    public WebElement signInButton2;
}
