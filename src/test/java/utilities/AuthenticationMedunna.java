package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthenticationMedunna {

    public static String generateToken() {

        Map<String,Object> bodyMap = new HashMap<>();
        bodyMap.put("password","qa.ahmet");
        bodyMap.put("rememberMe",true);
        bodyMap.put("username","qa_ahmet");

        //Response dan gelen token'i alabilmemiz için Content typ belirttik json olarak

       Response response= given().contentType(ContentType.JSON).body(bodyMap).post("https://medunna.com/api/authenticate");

       //getString() method ile id_token a denk gelen value yazdırır
        //jsonPath() value almak için kullanıldı
        return response.jsonPath().getString("id_token");

    }
}
