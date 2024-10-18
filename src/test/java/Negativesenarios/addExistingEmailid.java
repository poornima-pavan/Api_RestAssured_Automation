package Negativesenarios;
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

public class addExistingEmailid {
	
	@Test
	public void addexistingemail() {

//prepare request body using JSON object

		JSONObject user = new JSONObject();
		user.put("user_first_name", "username");
		user.put("user_last_name", "userlastname");
		user.put("user_contact_number", "3007360430");
		user.put("user_email_id", "team5iu@gmail.com");

		JSONObject userAddress = new JSONObject();
		userAddress.put("plotNumber", "pl-3");
		userAddress.put("street", "shadow sR");
		userAddress.put("state", "GA");
		userAddress.put("country", "INDIA");
		userAddress.put("zipCode", "66466");
		user.put("userAddress", userAddress);

//ADD USER AND SAVE THE RESPONSE TO GET USER ID  
		Response response = RestAssured.given().auth().basic("Numpy@gmail.com", "userapi@october")
				.contentType(ContentType.JSON).body(user.toString())
				.baseUri("https://userserviceapp-f5a54828541b.herokuapp.com/uap/createusers")
				// .log().body()
				.when().post().then().assertThat().statusCode(409).log().body()
				// .body("user.user_first_name", Matchers.equalTo("testuse"))
				// .body("userAddress.state", equalTo("GA"))
				.extract().response();
	}
	
//	Response response = RestAssured.given().auth().basic("Numpy@gmail.com", "userapi@october")
//			.contentType(ContentType.JSON).body(user.toString())
//			.baseUri("https://userserviceapp-f5a54828541b.herokuapp.com/uap/createusers")
//			// .log().body()
//			.when().post().then().assertThat().statusCode(400).log().body()
//			// .body("user.user_first_name", Matchers.equalTo("testuse"))
//			// .body("userAddress.state", equalTo("GA"))
//			.extract().response();

}
