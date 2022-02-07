package com.ita.edu.teachua.api.clients;

import com.ita.edu.teachua.utils.ClientDataTransfer;
import com.ita.edu.teachua.utils.MainValueProvider;
import io.restassured.response.Response;

import java.io.IOException;

public class DistrictClient extends BaseClient {

    private final String clientUrl;
    private final String districtListUrl;
    protected MainValueProvider mainValueProvider;
    private String token;

    public DistrictClient(String token) throws IOException {
        mainValueProvider = new MainValueProvider();
        this.clientUrl = mainValueProvider.getDistrictClientUrl();
        this.districtListUrl = mainValueProvider.getDistrictsListUrl();
        this.token = token;
    }

    public Response addNewDistrict() {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .body(new ClientDataTransfer().getAddDistrict())
                .when()
                .post(clientUrl);
    }

    public Response deleteNewDistrict(int id) {
        return preparedRequest()
                .header("Authorization", "Bearer " + token)
                .delete(clientUrl + "/" + id);
    }

    public Response getNewDistrict(int id) {
        return preparedRequest()
                .header("Authorization", "Bearer " + token)
                .get(clientUrl + "/" + id);
    }

    public Response getDistricts() {
        return preparedRequest()
                .header("Authorization", "Bearer " + token)
                .get(districtListUrl);
    }
}
