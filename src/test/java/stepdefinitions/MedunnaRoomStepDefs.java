package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import pages.MedunnaHomePage;
import pages.MedunnaRoomPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class MedunnaRoomStepDefs {

    MedunnaHomePage medunnaHomePage = new MedunnaHomePage();
    MedunnaRoomPage medunnaRoomPage = new MedunnaRoomPage();
    public static int roomNumber = Faker.instance().number().numberBetween(1000,1000000);
    public static String firstId;

    @When("click on Items&Titles")
    public void click_on_items_titles() {
        medunnaHomePage.itemsdAndTitles.click();

    }
    @When("click on Room option")
    public void click_on_room_option() {
        medunnaHomePage.roomOption.click();

    }
    @When("click on Create a new room button")
    public void click_on_create_a_new_room_button() {
        medunnaRoomPage.createANewRoomButton.click();

    }
    @When("enter {string} room number input")
    public void enter_room_number_input(String arg) {
        //SendKeys string değer kabull ettiği için int olan roomNumber a concat yaparak
        //String olmasını sağladık
        medunnaRoomPage.roomNumberInput.sendKeys(roomNumber+"");

    }
    @When("select Suite option from Room Type dropdown")
    public void select_suite_option_from_room_type_dropdown() {
        //Select objesi ile dropdown ı handle ettik selectByVisibleText ile
        new Select(medunnaRoomPage.roomTypeDropDown).selectByVisibleText("SUITE");

    }
    @When("click on Status checkbox")
    public void click_on_status_checkbox() {
        medunnaRoomPage.statusCheckbox.click();

    }
    @When("enter {string} in Price input")
    public void enter_in_price_input(String price) {
        medunnaRoomPage.priceInput.sendKeys(price);

    }
    @When("enter {string} in Description input")
    public void enter_in_description_input(String description)  {
        medunnaRoomPage.descriptionInput.sendKeys(description);
        ReusableMethods.waitFor(2);

    }
    @When("click on Save button")
    public void click_on_save_button() {
        //medunnaRoomPage.saveSubmitButton.click();

        ReusableMethods.clickWithJS(medunnaRoomPage.saveSubmitButton);
        ReusableMethods.waitFor(2);


    }
}
