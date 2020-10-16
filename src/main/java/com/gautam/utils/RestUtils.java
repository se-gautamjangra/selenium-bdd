package com.gautam.utils;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestUtils {
    static RequestSpecification request = null;

    //Sets Base URI
    public static void setBaseURI(String baseURI) {
        RestAssured.baseURI = baseURI;
        request = RestAssured.given();
    }


    public static void setContentType(ContentType Type) {
        request.contentType(Type);
    }

    public static Response postRequest(String body, String uri) {
        return request.body(body).post(uri);
    }

    public static Response putRequest(String body, String uri) {
        return request.body(body).post(uri);
    }

    public static Response getRequest(String key, String value, String uri) {
        return request.queryParam(key, value).get(uri);
    }

    public static Response deleteRequest(String uri) {
        return request.delete(uri);
    }
}