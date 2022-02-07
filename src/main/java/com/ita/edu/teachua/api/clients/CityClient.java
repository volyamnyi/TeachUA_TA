package com.ita.edu.teachua.api.clients;

import com.ita.edu.teachua.api.models.city.city_request.City;
import com.ita.edu.teachua.utils.MainValueProvider;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.io.IOException;

public class CityClient extends BaseClient {
    protected MainValueProvider valueProvider;
    private final String cityUrl;
    private final String citiesUrl;
    private String token;


    public CityClient(String token) throws IOException {
        super();
        try {
            valueProvider = new MainValueProvider();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.cityUrl = mainValueProvider.getCityUrl();
        this.citiesUrl = mainValueProvider.getCitiesUrl();
        this.token = token;
    }

    @Step("Add new city")
    public Response addNewCity(City city) {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .body(city)
                .log().all()
                .when()
                .post(cityUrl);
    }

    @Step("Delete city with id = '{id}'")
    public Response deleteCityById(int id) {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .log().all()
                .when()
                .delete(String.format("%s/%d", cityUrl, id));
    }

    @Step("Get list of all cities")
    public Response getCities() {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .log().all()
                .when()
                .get(citiesUrl);
    }

    @Step("Update city with id = '{id}'")
    public Response updateCityById(City city, int id) {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .body(city)
                .log().all()
                .when()
                .put(String.format("%s/%d", cityUrl, id));
    }

}