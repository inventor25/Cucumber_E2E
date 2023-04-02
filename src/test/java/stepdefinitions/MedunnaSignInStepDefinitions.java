package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MedunnaLoginPage;
import pages.MedunnaHomePage;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;

public class MedunnaSignInStepDefinitions {
    MedunnaLoginPage medunnaLoginPage = new MedunnaLoginPage();
    MedunnaHomePage medunnaHomePage = new MedunnaHomePage();

    @Given("Kullanici {string} gider")
    public void given_kullanici_gider(String string) {
        Driver.getDriver().get(string);
    }

    @When("Kullanici giris bölümü sembolüne tiklar")
    public void kullanici_giris_bolumu_sembolune_tiklar() {
        medunnaLoginPage.signSymbol.click();
        //assertTrue(medunnaPage.signSymbol.isDisplayed());
        //    System.out.println(medunnaPage.signInButton.getText());
    }

    @When("Kullanici Sign In butonuna tiklar")
    public void kullanici_sign_in_butonuna_tiklar() {
        medunnaLoginPage.signInButton.click();
        ReusableMethods.waitFor(1);


    }

    @When("Kullanici Username {string} girer")
    public void kullanici_username_girer(String string) {
        medunnaLoginPage.username.sendKeys(string);
    }

    @When("Kullanici Password {string} girer")
    public void kullanici_password_girer(String string) {
        medunnaLoginPage.password.sendKeys(string);
    }

    @When("Kullanici altta ki sign in butonuna tıklar")
    public void kullanici_altta_ki_sign_in_butonuna_tıklar() {
        medunnaLoginPage.signInButton2.click();
        ReusableMethods.waitFor(2);
    }

    @Then("Kullanici basarili giris yaptigini dogrular")
    public void kullanici_basarili_giris_yaptigini_dogrular() {

        System.out.println(medunnaHomePage.userText.getText());
        assert medunnaHomePage.userText.isDisplayed();
    }

    @Then("close the application")
    public void close_the_application() {
        Driver.closeDriver();
    }

    @Given("user is on {string} page")
    public void user_is_on_page(String url) {
        Driver.getDriver().get(url);

    }
    @When("click on user icon")
    public void click_on_user_icon() {

        medunnaHomePage.userIcon.click();
    }
    @When("click on Sign In option")
    public void click_on_sign_in_option() {
        medunnaHomePage.signInOption.click();

    }
    @When("enter {string} in Username input")
    public void enter_in_username_input(String username) {
        medunnaLoginPage.usernameInput.sendKeys(username);

    }
    @When("enter {string} in Password input")
    public void enter_in_password_input(String password) {
        medunnaLoginPage.passwordInput.sendKeys(password);

    }
    @When("click on Remember Me checkbox")
    public void click_on_remember_me_checkbox() {
        medunnaLoginPage.rememberMeCheckbox.click();

    }
    @When("click on Sign In submit button")
    public void click_on_sign_in_submit_button() {
        medunnaLoginPage.signInSubmitButton.click();

    }
}
