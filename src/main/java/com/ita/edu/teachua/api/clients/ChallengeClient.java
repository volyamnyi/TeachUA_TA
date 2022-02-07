package com.ita.edu.teachua.api.clients;

import com.ita.edu.teachua.utils.ClientDataTransfer;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.io.IOException;

public class ChallengeClient extends BaseClient {
    private final String clientUrl;
    private final String token;


    public ChallengeClient(String token) throws IOException {
        super();
        this.clientUrl = mainValueProvider.getChallengeUrl();
        this.token = token;
    }
    public Response addChallenge(JSONObject addChallenge){
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s",token))
                .body(addChallenge.toString())
                .when()
                .post(clientUrl);
    }
    public Response addChallenge() {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .body(new ClientDataTransfer().getAddChallenge())
                .when()
                .post(clientUrl);
    }

    public Response patchChallenge(int id) {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .body(new ClientDataTransfer().getPatchChallenge())
                .when()
                .patch(clientUrl + "/" + id);
    }

    public Response getChallengeById(int id) {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .get(clientUrl + "/" + id);
    }

    public Response deleteChallenge(int id) {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .delete(clientUrl + "/" + id);
    }


}
