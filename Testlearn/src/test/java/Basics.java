import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import POJO.Address;
import POJO.location;
import files.ReUsableMethods;
import files.payload;

public class Basics {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		// TODO Auto-generated method stub
// validate if Add Place API is workimg as expected 
		//Add place-> Update Place with New Address -> Get Place to validate if New address is present in response
		
		//given - all input details 
		//when - Submit the API -resource,http method
		//Then - validate the response

		Address a1=new Address();
		location l1=new location();
		l1.setLat(32.23);
		l1.setLng(33.44);
		a1.setLocation(l1);
		a1.setAccuracy("49");
		a1.setAddress("asd, asd");
		a1.setLanguage("Eng");
		a1.setName("Ameet");
		a1.setPhone_number("213132");
		a1.setTypes(" shoes,bas");
		a1.setWebsite("www.dfd.com");
		RestAssured.baseURI= "https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(a1).when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		JsonPath js=new JsonPath(response); //for parsing Json
		String placeId=js.getString("place_id");
		
		System.out.println(placeId);
		
		//Update Place
		String newAddress = "Summer Walk, Africa";
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n" + 
				"\"place_id\":\""+placeId+"\",\r\n" + 
				"\"address\":\""+newAddress+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}").
		when().put("maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		//Get Place
		
	String getPlaceResponse=	given().log().all().queryParam("key", "qaclick123")
		.queryParam("place_id",placeId)
		.when().get("maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
	JsonPath js1=ReUsableMethods.rawToJson(getPlaceResponse);
	String actualAddress =js1.getString("address");
	System.out.println(actualAddress);
	Assert.assertEquals(actualAddress, "Summer Walk, Africa");
	//Cucumber Junit, Testng
	
	ObjectMapper objectMapper = new ObjectMapper();
	 
	objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	  
	Address A = objectMapper.readValue(given().log().all().queryParam("key", "qaclick123")
			.queryParam("place_id",placeId).expect().defaultParser(Parser.JSON)
			.when().get("maps/api/place/get/json")
			.then().assertThat().log().all().statusCode(200).extract().asString(),Address.class);
	
	System.out.println(A.getAccuracy()+" LAt  "+A.getLocation().getLat());
	
	   
	
	
	
	

		
		
		
		
		
		
		
		
		
		
		
	}

}
