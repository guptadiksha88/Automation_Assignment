package com.api.test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.qa.api.utils.ExcelUtils;
import com.qa.api.utils.TestUtils;
import com.relevantcodes.extentreports.ExtentReports;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetRequestTest extends TestUtils {
	ExcelUtils ex= new ExcelUtils();
	

	@BeforeTest
	public void	testdatasetup() throws IOException
	{
	initialization();
	}
@Test(dataProvider="testdataforcall", dataProviderClass = ExcelUtils.class, description= "To fetch the List of Hotels")
	public void gethotellist(String placeid,String token)
	{
	
	String endpoint = pro.getProperty("endpoint");
		RestAssured.baseURI= pro.getProperty("baseURI");
		String response= given().queryParam("placeId", placeid).header("token", token)
		.when().get(endpoint)
		.then().assertThat().statusCode(200).contentType(ContentType.JSON)		
		.body("pagination.totalResultsCount",notNullValue())
		.extract().response().asString();
		
		//Validations
	     JsonPath js= new JsonPath(response);
	     String countrycode = js.getString("countryCode");
	     Assert.assertEquals(countrycode, "AE");
	     int numberofhotels= js.getInt("pagination.totalResultsCount");
	     System.out.println("Number of Hotels " + numberofhotels);
	     
 
}
}
