package stepdefinitions.apistepdefinitions;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import pojos.Room;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static base_urls.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;


public class RoomCreationStepDefs {
    Response response;

    // unique room number olması için faker class kullanarak olusturduk
    int roomNumber = Faker.instance().number().numberBetween(1000, 1000000);
    Room expectedData;

    @Given("user sends post request for room data")
    public void user_sends_post_request_for_room_data() {
        //Set the url
        spec.pathParams("first", "api", "second", "rooms");

        //Set the expected data
        expectedData = new Room("Api'dan yeni Dadas oda", 25, roomNumber, "TWIN", true);

        //Send the request and get the response
        response = given(spec).body(expectedData).post("{first}/{second}");
        response.prettyPrint();
    }

    @Then("user gets the room data and assert")
    public void user_gets_the_room_data_and_assert() throws IOException {
        assertEquals(201, response.statusCode());

        //1. Validation
        /*
                1.yol da then() ve bod() methodunu kullanarak assert işlemlerini yaptık
                dönen response de body() method'u yardımıyla bize gelen response içinde ki type lerin
                value larına denk gelen değerleri alarak assert yaptırıyorum dilersek hard assertion yerine
                tek bir body() içerisinde soft assertion yapabiliriz

         */

        response.
                then().
                body("roomNumber", equalTo(roomNumber)).
                body("roomType", equalTo("TWIN")).
                body("status", equalTo(true)).
                body("price", equalTo(25)).
                body("description", equalTo("Api'dan yeni Dadas oda"));

        //2. Validation
        //Response muzu Json path objesi içerisine koyduk
        JsonPath jsonPath = response.jsonPath();
        //Expected data(yani pojo classımız) içerisinde ki roomNumber çağırdık fakat bu obje olduğu için cast işlemi yaptık ve jsonPath içerisinde inteeger gelen
        //roomNumber i aldık assert yaptık
        assertEquals((int) expectedData.getRoomNumber(), jsonPath.getInt("roomNumber"));
        assertEquals(expectedData.getRoomType(), jsonPath.getString("roomType"));
        assertEquals(expectedData.getStatus(), jsonPath.getBoolean("status"));
        assertEquals((int) expectedData.getPrice(), jsonPath.getInt("price"));
        assertEquals(expectedData.getDescription(), jsonPath.getString("description"));

        //3. Validation
        /*
        Response muzu map a çevirerek assert işlemi yaptık
        response.as method unu kullanıp responsu muzu map 'a çevirdik
         */
        Map<String, Object> actualDataMap = response.as(HashMap.class);

        //actualDataMap.get("roomNumber") map içerisinden key girerek value çağırıp assert yaptım
        assertEquals(expectedData.getRoomNumber(), actualDataMap.get("roomNumber"));
        assertEquals(expectedData.getRoomType(), actualDataMap.get("roomType"));
        assertEquals(expectedData.getStatus(), actualDataMap.get("status"));
        assertEquals(expectedData.getPrice(), actualDataMap.get("price"));
        assertEquals(expectedData.getDescription(), actualDataMap.get("description"));

        //4. Validation
        /*
        response i response.as diyerek pojo class a çevirdim sonucunda pojoyu kullanarak
        olusturduğum expected data ile assert yaptım
         */
        Room actualDataPojo = response.as(Room.class);

        assertEquals(expectedData.getRoomNumber(), actualDataPojo.getRoomNumber());
        assertEquals(expectedData.getRoomType(), actualDataPojo.getRoomType());
        assertEquals(expectedData.getStatus(), actualDataPojo.getStatus());
        assertEquals(expectedData.getPrice(), actualDataPojo.getPrice());
        assertEquals(expectedData.getDescription(), actualDataPojo.getDescription());

        //5. Validation
        // Object mapper objesi olusturarak  readValue methodu ile gelen response u
        //asString diyerek stringe çevirip Room class ına çevirdim ve assert yaptım
        Room actualDataObjectMapper = new ObjectMapper().readValue(response.asString(), Room.class);

        assertEquals(expectedData.getRoomNumber(), actualDataObjectMapper.getRoomNumber());
        assertEquals(expectedData.getRoomType(), actualDataObjectMapper.getRoomType());
        assertEquals(expectedData.getStatus(), actualDataObjectMapper.getStatus());
        assertEquals(expectedData.getPrice(), actualDataObjectMapper.getPrice());
        assertEquals(expectedData.getDescription(), actualDataObjectMapper.getDescription());

        //6. Validation
        //Bir diğer assert tipi Gson dır obje olusturup respone string olarak okuyup room class
        //ına çevirdim yani de-serialization işlemi yaptım
        Room actualDataGson = new Gson().fromJson(response.asString(), Room.class);

        assertEquals(expectedData.getRoomNumber(), actualDataGson.getRoomNumber());
        assertEquals(expectedData.getRoomType(), actualDataGson.getRoomType());
        assertEquals(expectedData.getStatus(), actualDataGson.getStatus());
        assertEquals(expectedData.getPrice(), actualDataGson.getPrice());
        assertEquals(expectedData.getDescription(), actualDataGson.getDescription());

    }
}