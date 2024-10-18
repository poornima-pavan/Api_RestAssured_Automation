package restAssuredTests;

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

public class PostAdduser {

	@Test
	public void adduser() {

//prepare request body using JSON object

		JSONObject user = new JSONObject();
		user.put("user_first_name", "useaitstterr");
		user.put("user_last_name", "NNsrapitesttrer");
		user.put("user_contact_number", "3907360430");
		user.put("user_email_id", "team517iu@gmail.com");

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

		System.out.println("user id is " + user_id);
		System.out.println("firstname is " + user_first_name);
//		    
//	
////		    
////GET USER BY USER_ID
//		    
		    RestAssured
		               .given()
		               .auth().basic("Numpy@gmail.com", "userapi@october")
		                   .pathParam("user_id",user_id)
		                   .baseUri("https://userserviceapp-f5a54828541b.herokuapp.com/uap/user/")
		                  .log().all()
		               .when()
		                    .get("{user_id}")
		               
		                .then()
		                     .assertThat()
		                     .statusCode(200)
		                     .header("Content-Type", "application/json");
//		    
////		    
//		    
////GETUSERBY FIRST NAME
		    
		    RestAssured
		               .given()
		               .auth().basic("Numpy@gmail.com", "userapi@october")
		                   .pathParam("user_first_name",user_first_name)
		                   .baseUri("https://userserviceapp-f5a54828541b.herokuapp.com/uap/users/username/")
		                   .log().all()
		               .when()
		                   .get("{user_first_name}")
		               
		               .then()
		                    .assertThat()
		                    .statusCode(200)
		                    .header("Content-Type", "application/json");
//		   // .body("booking.firstname", Matchers.equalTo("api testing"))
//		                     //.body("user_first_name", Matchers.equalTo("userapitestTer"));
		                     
//	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	    
//UPDATE USER
		    
		   // JSONObject user = new JSONObject();
		    
		    user.put("user_first_name","updateduser"); 
		    int updateid = response.path("user_id");
		    System.out.println("user id is " + updateid);
		    Response response1 = 
				     RestAssured
				             .given()
				                    .auth().basic("Numpy@gmail.com", "userapi@october")
				                    .contentType(ContentType.JSON)
//				                    .body("{\"user_first_name\": \"updatednewname\"}") 
				                    .body(user.toString())
				                    .baseUri("https://userserviceapp-f5a54828541b.herokuapp.com/uap/updateuser/")
				                    .log().all()
				             .when()
				                    .put("{user_id}",user_id)
				             .then()
				                    .assertThat()
				                    .statusCode(200)
				                    .log().body()
				                    // .body("user.user_first_name", Matchers.equalTo("testuse"))
									//.body("userAddress.state", equalTo("GA"))
				                    .extract().response();
				    
//				    //int update_user_id = response1.path("user_id");
//				  //  String updated_user_first_name = response.path("user_first_name");
//				    
//				    //System.out.println("user id is " + update_user_id );
//				  //  System.out.println("updated firstname is "+updated_user_first_name);
//		
		    //
	 //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++     
	//DELETE REQUEST
		   
		   	     RestAssured
		   	             .given()
		   	                    .auth().basic("Numpy@gmail.com", "userapi@october")
		   	                    .contentType(ContentType.JSON)
		   	                  //  .body(user.toString())
		   	                    .baseUri("https://userserviceapp-f5a54828541b.herokuapp.com/uap/deleteuser/")
		   	                   // .log().body()
		   	             .when()
		   	                    .delete("{user_id}",user_id)
		   	             .then()
		   	                    .assertThat()
		   	                    .statusCode(200)
		   	                     .log().all();
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		   	     
//GET ALL getalluserdetails() {
		  	
		  		RestAssured	
		  		 .given()
		  		       .auth().basic("Numpy@gmail.com", "userapi@october")
		  		       .baseUri("https://userserviceapp-f5a54828541b.herokuapp.com/uap/users")
		  		.when()
		  		       .get()
		  		.then()
		  		       .statusCode(200)
		  		       .header("Content-Type", "application/json");
		                 
		  	
		
	}
}

