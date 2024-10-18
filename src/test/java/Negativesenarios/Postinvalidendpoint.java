package Negativesenarios;

//package restAssuredTests;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;

public class Postinvalidendpoint {

	@Test
	public void adduser() {

		// prepare request body using JSON object

		JSONObject user = new JSONObject();
		user.put("user_first_name", "negativesenario");
		user.put("user_last_name", "Negativelastname");
		user.put("user_contact_number", "3907360430");
		user.put("user_email_id", "team517iu@gmail.com");

		JSONObject userAddress = new JSONObject();
		userAddress.put("plotNumber", "pl-3");
		userAddress.put("street", "shadow sR");
		userAddress.put("state", "GA");
		userAddress.put("country", "INDIA");
		userAddress.put("zipCode", "66466");
		user.put("userAddress", userAddress);

		// ADD USER AND SAVE THE RESPONSE TO GET USER ID
		Response response = RestAssured.given().auth().basic("Numpy@gmail.com", "userapi@october")
				.contentType(ContentType.JSON).body(user.toString())
				.baseUri("https://userserviceapp-f5a54828541b.herokuapp.com/uap/createuserss")
				// .log().body()
				.when().post().then().assertThat().statusCode(404).log().body()
				// .body("user.user_first_name", Matchers.equalTo("testuse"))
				// .body("userAddress.state", equalTo("GA"))
				.extract().response();

//			    int user_id = response.path("user_id");
//			    String user_first_name = response.path("user_first_name");
//			    
//			    System.out.println("user id is " + user_id);
//			    System.out.println("firstname is "+user_first_name);
//			    
	}

}
