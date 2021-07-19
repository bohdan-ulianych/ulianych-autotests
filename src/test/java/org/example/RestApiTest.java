package org.example;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;


public class RestApiTest
{
    public final String BASE_URL = "http://dummy.restapiexample.com/api/v1";
    @Test
    public void getFindEmloyeeById() {
        int empId = 1;
        RequestSpecification request  = RestAssured.given();
        RestAssured
                .when().get(BASE_URL + "/employee/" + empId)
                .then().assertThat().statusCode(200)
                .and().body("data.id", is(empId));
    }

    @Test
    public void postCreateNewEmployee(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Dima");
        requestBody.put("salary", 2500);
        requestBody.put("age", 21);
        RequestSpecification request  = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestBody.toJSONString());
        Response response = request.post(BASE_URL + "/create");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
        System.out.println("Status code: " + statusCode);
        System.out.println(response.asString());
    }

    @Test
    public void putUpdateEmployee(){
        int empId = 21;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Ivan");
        requestBody.put("salary", 12558);
        requestBody.put("age", 42);
        request.body(requestBody.toJSONString());
        Response response = request.put(BASE_URL + "/update/"+ empId);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        System.out.println("Status code: " + statusCode);
        System.out.println(response.asString());
    }
    @Test
    public void deleteDeleteEmployee() {
        int empId = 25;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        Response response = request.delete(BASE_URL + "/delete/" + empId);
        int statusCode = response.getStatusCode();
        System.out.println("Status code: " + statusCode);
        System.out.println(response.asString());
        Assert.assertEquals(statusCode, 200);
    }




}