package stepdefinitions.apistepdefinitions;

import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.Room;

import static base_urls.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stepdefinitions.MedunnaRoomStepDefs.roomNumber;

public class RoomGetStepDefs {

    //Set the url
    //https://medunna.com/api/rooms?sort=createdDate,desc
    @Given("user sends get request and validate")
    public void user_sends_get_request_and_validate() {

        /*
        spec imizin içinde base url ve autentication hazır olduğundan
         sadece parametre eklememiz yeterli olacaktır

         UI olarak oluşturduğumuz room'u Api da yani backend olarak automation  kullanarak
         test etmiş olduk

         */
        spec.pathParams("first","api","second","rooms").
                queryParam("sort","createdDate,desc");
        //Set the expected data
        Room expectedData = new Room("Created By Erzurum For Api Test",25,roomNumber,"SUITE",true);

        //Send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        assertEquals(200,response.statusCode());


        JsonPath jsonPath = response.jsonPath();

        System.out.println(jsonPath.getList("roomNumber"));
        System.out.println("roomNumber = " + roomNumber);

        assertTrue(jsonPath.getList("roomNumber").contains(expectedData.getRoomNumber()));
        assertTrue(jsonPath.getList("roomType").contains(expectedData.getRoomType()));
        assertTrue(jsonPath.getList("status").contains(expectedData.getStatus()));
        //assertTrue(jsonPath.getList("price").contains(25.0));
        assertTrue(jsonPath.getList("description").contains(expectedData.getDescription()));
    }
}
