package com.ita.edu.teachua.api.clients;

import com.ita.edu.teachua.utils.ClientDataTransfer;
import com.ita.edu.teachua.utils.MainValueProvider;
import io.restassured.response.Response;

import java.io.IOException;

public class ContactClient extends BaseClient {
    private final String contactUrl;
    protected MainValueProvider valueProvider;
    private String token;

    public ContactClient(String token) throws IOException {
        super();
        try {
            valueProvider = new MainValueProvider();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.contactUrl = valueProvider.getContactUrl();
        this.token = token;
    }

    public Response addNewContact() {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .body(new ClientDataTransfer().getAddContact())
                .when()
                .post(contactUrl);
    }

    public Response changeContact(int id) {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .body(new ClientDataTransfer().getChangeContact())
                .when()
                .put(String.format("%s/%d", contactUrl, id));
    }

    public Response deleteContact(int id) {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .delete(String.format("%s/%d", contactUrl, id));
    }

    public Response getContact(int id) {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .get(String.format("%s/%d", contactUrl + "-view", id));
    }

    public Response getContacts() {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .get(contactUrl + "s");
    }
}
