package com.ita.edu.teachua.api.clients;

import com.ita.edu.teachua.utils.ClientDataTransfer;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.io.IOException;

public class ComplaintClient extends BaseClient{
    private final String clientUrl;
    private final String token;
    public ComplaintClient(String token) throws IOException {
        super();
        this.clientUrl=mainValueProvider.getComplaintClientUrl();
        this.token=token;
    }
    public Response postComplaint(JSONObject postComplaint){
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s",token))
                .body(postComplaint.toString())
                .when()
                .post(clientUrl);
    }
    public Response postComplaint(){
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s",token))
                .body(new ClientDataTransfer().getAddComplaint())
                .when()
                .post(clientUrl);
    }
    public Response getComplaintById(int id) {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s",token))
                .get(clientUrl + "/" + id);
    }
    public Response deleteComplaintById(int id) {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s",token))
                .delete(clientUrl + "/" + id);
    }
    public Response putComplaintById(int id,JSONObject putComplaint){
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s",token))
                .body(putComplaint.toString())
                .when()
                .put(clientUrl+"/"+id);

    }
}
