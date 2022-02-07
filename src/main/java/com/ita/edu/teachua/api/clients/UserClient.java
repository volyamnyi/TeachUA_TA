package com.ita.edu.teachua.api.clients;

import com.ita.edu.teachua.api.models.user.SuccessUpdatedUser;
import com.ita.edu.teachua.api.models.user.UserChangePassword;
import com.ita.edu.teachua.utils.MainValueProvider;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.io.IOException;

public class UserClient extends BaseClient {
    private final String clientUrl;
    private String token;

    public UserClient() throws IOException {
        super();
        this.clientUrl = mainValueProvider.getUserUrl();
    }

    public UserClient(String token) throws IOException {
        super();
        mainValueProvider = new MainValueProvider();
        this.clientUrl = mainValueProvider.getUserUrl();
        this.token = token;
    }

    public Response deleteUser(int id) {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .when()
                .delete(String.format("%s/%d", clientUrl, id));
    }

    public Response getUser(int id) {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .when()
                .get(String.format("%s/%d", clientUrl, id));
    }

    public Response getUsers() {
        return preparedRequest()
                .when()
                .get(String.format("%s%s", clientUrl, "s"));
    }

    public Response patchUserPassword(int id, UserChangePassword userChangePassword) {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .body(userChangePassword)
                .when()
                .patch(String.format("%s/%d", clientUrl, id));
    }

    public Response putUserNewInfo(int id, SuccessUpdatedUser updatedUserData) {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .body(updatedUserData)
                .when()
                .put(String.format("%s/%d", clientUrl, id));
    }


}
