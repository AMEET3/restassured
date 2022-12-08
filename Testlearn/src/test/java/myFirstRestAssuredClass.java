
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.*;
import  io.restassured.path.json.JsonPath;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers.*;

import com.jayway.jsonpath.*;

import groovy.json.JsonSlurper;


public class myFirstRestAssuredClass {

   final static String url="http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1";

   public static void main(String args[]) {

   //  getResponseBody();
     //getResponseStatus();
   //  getResponseHeaders();
	   getResponseTim();
	   
; }

 
   public static void getResponseBody(){
       given().when().get(url).then().log()
      .all();

  given().queryParam("CUSTOMER_ID","68195")
               .queryParam("PASSWORD","1234!")
               .queryParam("Account_No","1") .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log().body();
   }

public static void getResponseStatus(){
   int statusCode= given().queryParam("CUSTOMER_ID","68195")
           .queryParam("PASSWORD","1234!")
           .queryParam("Account_No","1")
           .when().get("http://demo.guru99.com/V4/sinkministatement.php").getStatusCode();
   System.out.println("The response status is "+statusCode);

   given().when().get(url).then().assertThat().statusCode(200);
}
   
public static void getResponseHeaders(){
	   System.out.println("The headers in the response "+
	                   get(url).then().extract()
	           .headers().getValue("Expires"));
	}  
   
public static void getResponseTime(){
	  System.out.println("The time taken to fetch the response "+get(url)
	         .timeIn(TimeUnit.MILLISECONDS) + " milliseconds");
	  System.out.println("Content type"+get(url).then().extract().contentType());
	  int i=0;
	  ArrayList<Integer> amt=when().get("https://dummy.restapiexample.com/api/v1/employees").then().extract().path("data.employee_age");
	  for(Integer a:amt)
	  {
		 System.out.println(a);
		  i=i+Integer.valueOf(a); 
	  }
	  System.out.println("sum "+i);
	} 
   
public static  void getResponseTim(){
	String id1="221";
	RestAssured.baseURI="https://reqres.in/";
	RestAssured.basePath="api/users";
	/*	System.out.println(given().pathParam("id",id1).get("{id}").prettyPrint());
	System.out.println(given().get().prettyPrint());
	//get with querry parametrs
	
		Response rs=given().header("","").body("{\r\n"
			+ "name : Tarun Goswmi\r\n"
			+ "\r\n"
			+ "job : QA\r\n"
			+ "\r\n"
			+ "}").post().then().statusCode(201).extract().response();
	System.out.println(rs.body().prettyPrint());
	System.out.println();
	
	given().delete("/2").then().statusCode(777);*/
	Response rs=given().log().all().queryParam("page", "2").get().then().extract().response();
	 JsonPath js= new JsonPath(rs.asString());
	 System.out.println();
	System.out.println( js.get("data.id"));


}
   
   
   
   
   /* //This will fetch the response body as is and log it. given and when are optional here
   public static void getResponseBody(){
   Response rs=RestAssured.get(url);
   ValidatableResponse valres=rs.then();
   valres.statusCode(200);
   System.out.println(valres.statusCode(200));
   given().
   }

*/

}