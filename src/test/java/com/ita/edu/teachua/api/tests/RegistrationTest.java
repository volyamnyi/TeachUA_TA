package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.RegistrationClient;
import com.ita.edu.teachua.api.clients.UserClient;
import com.ita.edu.teachua.api.clients.sigin.Authorization;
import com.ita.edu.teachua.api.models.error.BaseErrorBody;
import com.ita.edu.teachua.api.models.registration.RegisterUser;
import com.ita.edu.teachua.api.models.registration.SuccessRegistration;
import com.ita.edu.teachua.api.models.user.UserInfo;
import com.ita.edu.teachua.utils.ClientDataTransfer;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class RegistrationTest extends ApiTestRunner {

    @Description("TUA-377 [API] Verify that user is not registered if at least one of the mandatory fields is empty")
    @Issue("TUA-377")
    @Test(description = "TUA-377")
    public void testRegisterWithOneEmptyField() throws IOException {
        BaseErrorBody error;
        final int expectedStatus = 400;
        final String expectedErrorMessageEmpty = " can`t be empty";
        final String expectedErrorMessageBlank = " must not be blank";

        SoftAssert softAssert = new SoftAssert();
        RegistrationClient regClient = new RegistrationClient();
        RegisterUser registerUser = (new ClientDataTransfer()).getRegisterUser();

        //No first name
        registerUser.setFirstName("");
        error = regClient.registerUser(registerUser).then().log().all()
                .extract().as(BaseErrorBody.class);
        softAssert.assertEquals(error.getStatus().intValue(), expectedStatus, "No first name responded " + error.getStatus());
        softAssert.assertEquals(error.getMessage(), "\"firstName\"" + expectedErrorMessageEmpty);

        //No last name
        registerUser = (new ClientDataTransfer()).getRegisterUser();
        registerUser.setLastName("");
        error = regClient.registerUser(registerUser).then().log().all()
                .extract().as(BaseErrorBody.class);
        softAssert.assertEquals(error.getStatus().intValue(), expectedStatus, "No last name responded " + error.getStatus());
        softAssert.assertEquals(error.getMessage(), "\"lastName\"" + expectedErrorMessageEmpty);

        //No email
        registerUser = (new ClientDataTransfer()).getRegisterUser();
        registerUser.setEmail("");
        error = regClient.registerUser(registerUser).then().log().all()
                .extract().as(BaseErrorBody.class);
        softAssert.assertEquals(error.getStatus().intValue(), expectedStatus, "No email responded " + error.getStatus());
        softAssert.assertTrue(error.getMessage().contains("email" + expectedErrorMessageBlank));

        //No password
        registerUser = (new ClientDataTransfer()).getRegisterUser();
        registerUser.setPassword("");
        error = regClient.registerUser(registerUser).then().log().all()
                .extract().as(BaseErrorBody.class);
        softAssert.assertEquals(error.getStatus().intValue(), expectedStatus, "No password responded " + error.getStatus());
        softAssert.assertTrue(error.getMessage().contains("password" + expectedErrorMessageBlank));

        //No phone
        registerUser = (new ClientDataTransfer()).getRegisterUser();
        registerUser.setPhone("");
        error = regClient.registerUser(registerUser).then().log().all()
                .extract().as(BaseErrorBody.class);
        softAssert.assertEquals(error.getStatus().intValue(), expectedStatus, "No phone responded " + error.getStatus());
        softAssert.assertTrue(error.getMessage().contains("phone" + expectedErrorMessageBlank));

        //No role name
        registerUser = (new ClientDataTransfer()).getRegisterUser();
        registerUser.setRoleName("");
        error = regClient.registerUser(registerUser).then().log().all()
                .extract().as(BaseErrorBody.class);
        softAssert.assertEquals(error.getStatus().intValue(), expectedStatus, "No role name responded " + error.getStatus());
        softAssert.assertTrue(error.getMessage().contains("roleName" + expectedErrorMessageBlank));

        softAssert.assertAll();
    }

    @Description("TUA-418 [API.Реєстрація] Verify that a user with already existing credentials cannot be created")
    @Issue("TUA-418")
    @Test(description = "TUA-418")
    public void testRegisterWithExistingCredentials() throws IOException {
        BaseErrorBody error;
        final int expectedStatus = 401;
        JSONArray allUsers = (new JSONArray(new UserClient().getUsers().body().asString()));
        JSONObject userInfo = allUsers.getJSONObject(allUsers.length() - 1);
        RegisterUser existingUser = new RegisterUser(
                userInfo.getString("email"),
                userInfo.getString("firstName"),
                userInfo.getString("lastName"),
                "0111111111",
                "jsh^&$@#34627SD",
                userInfo.getString("roleName")
        );

        RegistrationClient regClient = new RegistrationClient();

        error = regClient.registerUser(existingUser).then().log().all()
                .extract().as(BaseErrorBody.class);
        Assert.assertEquals(error.getStatus().intValue(), expectedStatus);
        Assert.assertEquals(error.getMessage(), "Email " + existingUser.getEmail() + " already exist");
    }

    @Description("TUA-419 [API.Реєстрація] Verify that a user with non-existing role can`t be created")
    @Issue("TUA-419")
    @Test(description = "TUA-419")
    public void testRegisterWithNonExistingRole() throws IOException {
        BaseErrorBody error;
        final int expectedStatus = 404;
        RegisterUser registerUser = (new ClientDataTransfer()).getRegisterUser();
        registerUser.setRoleName("SOME_ROLE");

        RegistrationClient regClient = new RegistrationClient();

        error = regClient.registerUser(registerUser).then().log().all()
                .extract().as(BaseErrorBody.class);
        Assert.assertEquals(error.getStatus().intValue(), expectedStatus);
        Assert.assertEquals(error.getMessage(), "Role not found by name: " + registerUser.getRoleName());
    }

    @Description("TUA-420 [API.Реєстрація] Verify that a user with empty mandatory fields can`t be created")
    @Issue("TUA-420")
    @Test(description = "TUA-420")
    public void testRegisterWithAllEmptyFields() throws IOException {
        BaseErrorBody error;
        final int expectedStatus = 400;
        final String emptyString = "";
        RegisterUser registerUser = new RegisterUser(emptyString, emptyString, emptyString, emptyString, emptyString, emptyString);

        RegistrationClient regClient = new RegistrationClient();

        error = regClient.registerUser(registerUser).then().log().all()
                .extract().as(BaseErrorBody.class);
        Assert.assertEquals(error.getStatus().intValue(), expectedStatus);
    }

    @Description("TUA-499 [API.Реєстрація] Verify that a user with invalid data in \"Пароль\" field can`t be created")
    @Issue("TUA-499")
    @Test(description = "TUA-499")
    public void testRegisterWithInvalidPassword() throws IOException {
        BaseErrorBody error;
        Response response;
        final int expectedStatus = 400;
        RegisterUser registerUser = (new ClientDataTransfer()).getRegisterUser();
        registerUser.setPassword("123456");
        RegistrationClient regClient = new RegistrationClient();

        response =regClient.registerUser(registerUser);
        error = response.then().log().all()
                .extract().as(BaseErrorBody.class);
        Assert.assertEquals(error.getStatus().intValue(), expectedStatus);
    }

    @Description("TUA-423 [API.Реєстрація] Verify that a user with invalid data can`t be created.")
    @Issue("TUA-423")
    @Test(description = "TUA-423")
    public void testRegisterWithInvalidData() throws IOException {
        BaseErrorBody error;
        final int expectedStatus = 400;
        RegisterUser registerUser = (new ClientDataTransfer()).getRegisterUser();
        RegistrationClient regClient = new RegistrationClient();
        Response response;
        SoftAssert softAssert = new SoftAssert();

        //Numbers in First name
        registerUser.setFirstName("218934");
        response = regClient.registerUser(registerUser);
        softAssert.assertEquals(response.statusCode(), expectedStatus);
        error = response.then().log().all()
                .extract().as(BaseErrorBody.class);
        softAssert.assertEquals(error.getStatus().intValue(), expectedStatus);
        softAssert.assertEquals(error.getMessage(), "\"firstName\" can`t contain numbers");

        //Special symbols in First name
        registerUser = (new ClientDataTransfer()).getRegisterUser();
        registerUser.setFirstName("&(*#@*$#@^");
        response = regClient.registerUser(registerUser);
        softAssert.assertEquals(response.statusCode(), expectedStatus);
        error = response.then().log().all()
                .extract().as(BaseErrorBody.class);
        softAssert.assertEquals(error.getStatus().intValue(), expectedStatus);
        softAssert.assertEquals(error.getMessage(), "\"firstName\" can contain only ukrainian and english letters");

        //More than 25 symbols in First name
        registerUser = (new ClientDataTransfer()).getRegisterUser();
        registerUser.setFirstName("Kukukukukukukukukukukukukukukuku");
        response = regClient.registerUser(registerUser);
        softAssert.assertEquals(response.statusCode(), expectedStatus);
        error = response.then().log().all()
                .extract().as(BaseErrorBody.class);
        softAssert.assertEquals(error.getStatus().intValue(), expectedStatus);
        softAssert.assertEquals(error.getMessage(), "\"firstName\" can contain from 1 to 25 letters");

        //Numbers in Last name
        registerUser = (new ClientDataTransfer()).getRegisterUser();
        registerUser.setLastName("218934");
        response = regClient.registerUser(registerUser);
        softAssert.assertEquals(response.statusCode(), expectedStatus);
        error = response.then().log().all()
                .extract().as(BaseErrorBody.class);
        softAssert.assertEquals(error.getStatus().intValue(), expectedStatus);
        softAssert.assertEquals(error.getMessage(), "\"lastName\" can`t contain numbers");

        //Special symbols in Last name
        registerUser = (new ClientDataTransfer()).getRegisterUser();
        registerUser.setLastName("&(*#@*$#@^");
        response = regClient.registerUser(registerUser);
        softAssert.assertEquals(response.statusCode(), expectedStatus);
        error = response.then().log().all()
                .extract().as(BaseErrorBody.class);
        softAssert.assertEquals(error.getStatus().intValue(), expectedStatus);
        softAssert.assertEquals(error.getMessage(), "\"lastName\" can contain only ukrainian and english letters");

        //More than 25 symbols in Last name
        registerUser = (new ClientDataTransfer()).getRegisterUser();
        registerUser.setLastName("Kukukukukukukukukukukukukukukuku");
        response = regClient.registerUser(registerUser);
        softAssert.assertEquals(response.statusCode(), expectedStatus);
        error = response.then().log().all()
                .extract().as(BaseErrorBody.class);
        softAssert.assertEquals(error.getStatus().intValue(), expectedStatus);
        softAssert.assertEquals(error.getMessage(), "\"lastName\" can contain from 1 to 25 letters");

        softAssert.assertAll();
    }

    @Description("TUA-457 [API. Реєстрація] Verify that a user with valid data can be created")
    @Issue("TUA-457")
    @Test(description = "TUA-457")
    public void testRegisterWithValidData() throws IOException {
        SuccessRegistration successRegistration;
        Response response;
        final int expectedStatus = 200;
        RegisterUser registerUser = (new ClientDataTransfer()).getRegisterUser();
        RegistrationClient regClient = new RegistrationClient();

        response = regClient.registerUser(registerUser);
        //Assert.assertEquals(response.statusCode(), expectedStatus);

        successRegistration = response.then().log().all()
                .extract().as(SuccessRegistration.class);

        Assert.assertNotNull(successRegistration.getId());
        Assert.assertEquals(successRegistration.getEmail(), registerUser.getEmail());
        Assert.assertEquals(successRegistration.getRoleName(), registerUser.getRoleName());

        //Delete created user
        int id = successRegistration.getId();
        String token = (new Authorization(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword())).getToken();
        new UserClient(token).deleteUser(id).then().log().all()
                .extract().as(UserInfo.class);
    }
}
