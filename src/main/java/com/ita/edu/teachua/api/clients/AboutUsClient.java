package com.ita.edu.teachua.api.clients;

import com.ita.edu.teachua.utils.ClientDataTransfer;
import com.ita.edu.teachua.utils.MainValueProvider;
import io.restassured.response.Response;

import java.io.IOException;

public class AboutUsClient extends BaseClient {

    private final String aboutUsUrl;
    protected MainValueProvider valueProvider;
    private String token;

    public AboutUsClient(String token) throws IOException {
        super();
        try {
            valueProvider = new MainValueProvider();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.aboutUsUrl = valueProvider.getAboutUsUrl();
        this.token = token;
    }

    public Response addNewAboutUs() {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .body(new ClientDataTransfer().getAddAboutUs())
                .when()
                .post(aboutUsUrl);
    }

    public Response changeAboutUs(int id) {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .body(new ClientDataTransfer().getChangeAboutUs())
                .when()
                .put(String.format("%s/%d", aboutUsUrl, id));
    }

    public Response deleteAboutUs(int id) {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .delete(String.format("%s/%d", aboutUsUrl, id));
    }

    public Response getAboutUs(int id) {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .get(String.format("%s/%d", aboutUsUrl, id));
    }

    public Response getAllAboutUs(){
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .get(aboutUsUrl);
    }
}
