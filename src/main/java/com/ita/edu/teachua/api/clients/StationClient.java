package com.ita.edu.teachua.api.clients;

import com.ita.edu.teachua.utils.ClientDataTransfer;
import com.ita.edu.teachua.utils.MainValueProvider;
import io.restassured.response.Response;

import java.io.IOException;

public class StationClient extends BaseClient{
    private final String stationUrl;
    protected MainValueProvider valueProvider;
    private String token;

    public StationClient(String token) throws IOException {
        super();
        try {
            valueProvider = new MainValueProvider();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.stationUrl = valueProvider.getStationUrl();
        this.token = token;
    }

    public Response addNewStation() {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .body(new ClientDataTransfer().getAddStation())
                .when()
                .post(stationUrl);
    }

    public Response changeStation(int id) {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .body(new ClientDataTransfer().getChangeStation())
                .when()
                .put(String.format("%s/%d", stationUrl, id));
    }

    public Response deleteStation(int id) {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .delete(String.format("%s/%d", stationUrl, id));
    }

    public Response getStation(int id) {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .get(String.format("%s/%d", stationUrl, id));
    }

    public Response getStationsByCityName(String name) {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .get(String.format("%s/%s", stationUrl + "s", name));
    }

    public Response getStations() {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .get( stationUrl + "s");
    }
}
