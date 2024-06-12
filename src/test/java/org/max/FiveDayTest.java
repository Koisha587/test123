package org.max;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.max.AccuweatherAbstractTest;
import Weather.Weather;


import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class FiveDayTest extends AccuweatherAbstractTest {


    @Test
    void test5dayForecast(){
        given()
                .queryParam("apikey",getApiKey())
                .when()
                .get(getBaseUrl()+"/forecasts/v1/daily/5day/290396")
                .then()
                .statusCode(200)
                .body("DailyForecasts.size()", is(5))
                .body("DailyForecasts[0].Temperature.Minimum.Value", greaterThan(-50))
                .body("DailyForecasts[0].Temperature.Maximum.Value", lessThan(50));
    }

    @Test
    void getWeatherFiveDay_shouldReturn() {

        Weather response = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"/forecasts/v1/daily/5day/290396")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000l))
                .extract()
                .response()
                .body().as(Weather.class);

        Assertions.assertEquals(5,response.getDailyForecasts().size());
    }
}

