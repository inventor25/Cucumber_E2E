package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MedunnaLoginPage;
import pages.MedunnaHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;

public class MedunnaSignInStepDefinitions {
    MedunnaLoginPage medunnaPage = new MedunnaLoginPage();
    MedunnaHomePage userPage = new MedunnaHomePage();

    @Given("Kullanici {string} gider")
    public void given_kullanici_gider(String string) {
        Driver.getDriver().get(string);
    }

    @When("Kullanici giris bölümü sembolüne tiklar")
    public void kullanici_giris_bolumu_sembolune_tiklar() {
        medunnaPage.signSymbol.click();
        //assertTrue(medunnaPage.signSymbol.isDisplayed());
        //    System.out.println(medunnaPage.signInButton.getText());
    }

    @When("Kullanici Sign In butonuna tiklar")
    public void kullanici_sign_in_butonuna_tiklar() {
        medunnaPage.signInButton.click();
        ReusableMethods.waitFor(1);


    }

    @When("Kullanici Username {string} girer")
    public void kullanici_username_girer(String string) {
        medunnaPage.username.sendKeys(string);
    }

    @When("Kullanici Password {string} girer")
    public void kullanici_password_girer(String string) {
        medunnaPage.password.sendKeys(string);
    }

    @When("Kullanici altta ki sign in butonuna tıklar")
    public void kullanici_altta_ki_sign_in_butonuna_tıklar() {
        medunnaPage.signInButton2.click();
        ReusableMethods.waitFor(2);
    }

    @Then("Kullanici basarili giris yaptigini dogrular")
    public void kullanici_basarili_giris_yaptigini_dogrular() {

        System.out.println(userPage.userText.getText());
        assert userPage.userText.isDisplayed();
    }

    @Then("close the application")
    public void close_the_application() {
        Driver.closeDriver();
    }


}
