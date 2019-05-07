import entities.User;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.*;

public class GetRequests extends BaseClass {

    @Test
    public void get200Response() {
        /*
        Response response =
        given()
                .auth().oauth2(ACCESS_TOKEN).
                when().
                get(BASE_ENDPOINT + "/public-api/users"); */

        Header authorized = new Header("access-token", ACCESS_TOKEN);

        RequestSpecification httpRequest = given();
        httpRequest.auth().oauth2(ACCESS_TOKEN);

        Response response = httpRequest.get(BASE_ENDPOINT + "/public-api/users");

        JsonPath jsonPathEvaluator = response.jsonPath();

        String id = jsonPathEvaluator.get("id");

    }

    @Test
    public void getUserResponse() {

     /*   User user = given().
                auth().oauth2(ACCESS_TOKEN).
                when().get(BASE_ENDPOINT + "/public-api/users?id=20").as(User.class); */

        Header authorized = new Header("access-token", ACCESS_TOKEN);

        RequestSpecification httpRequest = given();
        httpRequest.auth().oauth2(ACCESS_TOKEN);

        Response response = httpRequest.get(BASE_ENDPOINT + "/public-api/users?id=20");

        JsonPath jsonPathEvaluator = response.jsonPath();

        ArrayList results = jsonPathEvaluator.get("result");

    }
}
