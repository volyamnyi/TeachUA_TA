package com.ita.edu.teachua.api.clients;

import com.ita.edu.teachua.api.models.roles.RoleModel;
import com.ita.edu.teachua.utils.ClientDataTransfer;
import com.ita.edu.teachua.utils.MainValueProvider;
import io.restassured.response.Response;

import java.io.IOException;

public class RoleClient extends BaseClient{
    private final String roleClientUrl;
    private final String rolesClientUrl;
    protected MainValueProvider mainValueProvider;
    private final String token;

    public RoleClient(String token) throws IOException {
        super();
        try {
            mainValueProvider = new MainValueProvider();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.roleClientUrl = mainValueProvider.getRoleClientUrl();
        this.rolesClientUrl = mainValueProvider.getRolesClientUrl();
        this.token = token;
    }
    public Response addNewRole() {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .body(new ClientDataTransfer().getAddRole())
                .log().all()
                .when()
                .post(roleClientUrl);
    }
    public Response deleteRole(Integer id) {
        return preparedRequest()
                .when().log().all()
                .header("Authorization", String.format("Bearer %s",token))
                .delete(String.format("%s/%d", roleClientUrl, id));
    }
    public Response getRoleById(Integer id) {
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .log().all()
                .when()
                .get(String.format("%s/%d",roleClientUrl, id));
    }
    public Response getListOfRoles() {
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .log().all()
                .when()
                .get(rolesClientUrl);
    }
    public Response changeRoleById(RoleModel role, Integer id) {
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .body(role)
                .log().all()
                .when()
                .put(String.format("%s/%d", roleClientUrl, id));
    }
}
