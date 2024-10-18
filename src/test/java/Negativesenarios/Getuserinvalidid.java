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

import io.restassured.RestAssured;

public class Getuserinvalidid {
	
	  @Test
	   public void getuserinvalidid() {

			JSONObject user = new JSONObject();
			user.put("user_first_name", "useitaitstterr");
			user.put("user_last_name", "Nsrapoitesttrer");
			user.put("user_contact_number", "3017360430");
			user.put("user_email_id", "team58uu@gmail.com");

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
					.when().post().then().assertThat().statusCode(201).log().body()
					// .body("user.user_first_name", Matchers.equalTo("testuse"))
					// .body("userAddress.state", equalTo("GA"))
					.extract().response();

			int user_id = response.path("user_id");
			String user_first_name = response.path("user_first_name");
	   
	   
	   
	    RestAssured
	               .given()
	               .auth().basic("Numpy@gmail.com", "userapi@october")
	                   .pathParam("user_id",10000)
	                   .baseUri("https://userserviceapp-f5a54828541b.herokuapp.com/uap/user/")
	                  .log().all()
	               .when()
	                    .get("{{user_id}}")
	               
	                .then()
	                     .assertThat()
	                     .statusCode(200)
	                     .header("Content-Type", "application/json");
	   }}
//    
////    
//    
