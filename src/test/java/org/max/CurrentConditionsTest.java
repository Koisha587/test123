package org.max;

import io.restassured.RestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CurrentConditionsTest {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "http://dataservice.accuweather.com";
    }

    @Test
    public void testCurrentConditions() {
        String apiKey = "ulcDIs4FlYoLyKfauH9Y16s43CRrS8TI";
        String locationKey = "290396";

        given()
                .queryParam("apikey", apiKey)
                .queryParam("details", "true")
                .when()
                .get("/currentconditions/v1/" + locationKey)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("[0].WeatherText", notNullValue())
                .body("[0].Temperature.Metric.Value", greaterThan(-50));
    }
}
