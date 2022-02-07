package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.RegistrationClient;
import com.ita.edu.teachua.api.clients.UserClient;
import com.ita.edu.teachua.api.clients.sigin.Authorization;
import com.ita.edu.teachua.api.models.error.BaseErrorBody;
import com.ita.edu.teachua.api.models.registration.RegisterUser;
import com.ita.edu.teachua.api.models.registration.SuccessRegistration;
import com.ita.edu.teachua.api.models.user.SuccessUpdatedUser;
import com.ita.edu.teachua.api.models.user.UserInfo;
import com.ita.edu.teachua.utils.ClientDataTransfer;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class UserTest extends ApiTestRunner {

    static RegisterUser userData = (new ClientDataTransfer()).getRegisterUser();
    static int idUser;
    static UserClient userClientAsAdmin;
    static UserClient userClientAsUser;

    @BeforeClass
    public void createAndActivateUser() throws IOException {
        //register a user
        RegistrationClient regClient = new RegistrationClient();
        SuccessRegistration successRegistration = regClient.registerUser(userData).then().log().all()
                .extract().as(SuccessRegistration.class);
        idUser = successRegistration.getId();

        //Activate account
        Authorization authAdmin = new Authorization(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword());
        userClientAsAdmin = new UserClient(authAdmin.getToken());
        SuccessUpdatedUser updateUserActivation = (new ClientDataTransfer()).getUpdateUser();
        updateUserActivation.setId(idUser);
        userClientAsAdmin.putUserNewInfo(idUser, updateUserActivation).then().log().all();

        //login as user
        Authorization authAsUser = new Authorization(userData.getEmail(), userData.getPassword());
        userClientAsUser = new UserClient(authAsUser.getToken());
    }

    @AfterClass
    public void deleteUser(){
        //Delete user
        userClientAsAdmin.deleteUser(idUser);
    }

    @Test(invocationCount = 0)
    public void testSuiteForUserAPI() throws IOException {
        UserClient userClient = new UserClient();
        Response response = userClient.getUsers();
        response.then().log().all();
        JSONArray userInfos = new JSONArray(response.body().asString());
        //ArrayList<UserInfo> userInfos = new ArrayList<UserInfo>();
        Assert.assertNotNull(userInfos);
    }

    @Description("TUA-375 [API] Verify if registered user can see personal data")
    @Issue("TUA-375")
    @Test(description = "TUA-375")
    public void testUserDataIsAvailableToUser() {
        Response response;
        final int expectedStatus = 200;

        //Check if data is available
        response = userClientAsUser.getUser(idUser);
        UserInfo userInfo = response.then().log().all()
                .extract().as(UserInfo.class);

        Assert.assertEquals(response.statusCode(), expectedStatus);
        Assert.assertNotNull(userInfo);

    }

    @Description("TUA-408 [API] User can edit profile with valid data")
    @Issue("TUA-408")
    @Test(description = "TUA-408")
    public void testUserCanEditProfile() {
        final int expectedStatus = 200;
        final String newFirstName = "Andrii";
        final String newLastName = "Yaya";
        final String newPhone = "0999999999";

        //Check if user can change data

        SuccessUpdatedUser updateUserData = (new ClientDataTransfer()).getUpdateUser();
        updateUserData.setId(idUser);
        updateUserData.setLastName(newLastName);
        updateUserData.setFirstName(newFirstName);
        updateUserData.setPhone(newPhone);
        userClientAsUser.putUserNewInfo(idUser, updateUserData).then().log().all();

        //Check if data is changed
        Response response = userClientAsUser.getUser(idUser);
        UserInfo userInfo = response.then().log().all()
                .extract().as(UserInfo.class);

        Assert.assertEquals(response.statusCode(),expectedStatus);
        Assert.assertEquals(userInfo.getLastName(), newLastName);
        Assert.assertEquals(userInfo.getFirstName(), newFirstName);
        Assert.assertEquals(userInfo.getPhone(), newPhone);

    }

    @Description("TUA-411 [API. Edit profile] Verify that user can not save changes where mandatory fields are empty")
    @Issue("TUA-411")
    @Test(description = "TUA-411")
    public void testUserCanNotEditProfileWithMissingField() {
        BaseErrorBody error;
        final int expectedStatus = 400;
        final String newFirstName = "Andrii";
        final String newLastName = "Yaya";
        final String newPhone = "0999999999";
        SoftAssert softAssert = new SoftAssert();
        SuccessUpdatedUser updateUserData;

        //Check if user can change data

        //No Last name
        updateUserData = (new ClientDataTransfer()).getUpdateUser();
        updateUserData.setId(idUser);
        updateUserData.setLastName(null);
        updateUserData.setFirstName(newFirstName);
        updateUserData.setPhone(newPhone);
        error = userClientAsUser.putUserNewInfo(idUser, updateUserData).then().log().all()
                .extract().as(BaseErrorBody.class);
        softAssert.assertEquals(error.getStatus().intValue(), expectedStatus);
        softAssert.assertEquals(error.getMessage(), "\"lastName\" can`t be null");

        //No First name
        updateUserData = (new ClientDataTransfer()).getUpdateUser();
        updateUserData.setId(idUser);
        updateUserData.setLastName(newLastName);
        updateUserData.setFirstName(null);
        updateUserData.setPhone(newPhone);
        error = userClientAsUser.putUserNewInfo(idUser, updateUserData).then().log().all()
                .extract().as(BaseErrorBody.class);
        softAssert.assertEquals(error.getStatus().intValue(), expectedStatus);
        softAssert.assertEquals(error.getMessage(), "\"firstName\" can`t be null");

        //No Phone
        updateUserData = (new ClientDataTransfer()).getUpdateUser();
        updateUserData.setId(idUser);
        updateUserData.setLastName(newLastName);
        updateUserData.setFirstName(newFirstName);
        updateUserData.setPhone(null);
        error = userClientAsUser.putUserNewInfo(idUser, updateUserData).then().log().all()
                .extract().as(BaseErrorBody.class);
        softAssert.assertEquals(error.getStatus().intValue(), expectedStatus);
        softAssert.assertEquals(error.getMessage(), "phone must not be blank");

        softAssert.assertAll();
    }

    @Description("TUA-415 [API. Edit profile] Verify that user can not save changes with invalid data (fields lastName and firstName)")
    @Issue("TUA-415")
    @Test(description = "TUA-415")
    public void testUserCanNotEditProfileWithInvalidData() {
        BaseErrorBody error;
        final int expectedStatus = 400;
        final String nameWithNumbers = "Andrii25";
        final String nameMoreThan25 = "Veryveryveryveryveryveryverylonglonglonglongname";
        final String nameWithChars = "Andrii&^%$#@";
        SoftAssert softAssert = new SoftAssert();
        SuccessUpdatedUser updateUserData;

        //Check if user can change data

        //first name with number
        updateUserData = (new ClientDataTransfer()).getUpdateUser();
        updateUserData.setId(idUser);
        updateUserData.setFirstName(nameWithNumbers);
        error = userClientAsUser.putUserNewInfo(idUser, updateUserData).then().log().all()
                .extract().as(BaseErrorBody.class);
        softAssert.assertEquals(error.getStatus().intValue(), expectedStatus, "first name with numbers pass");
        softAssert.assertEquals(error.getMessage(), "\"firstName\" can`t contain numbers");

        //first name more than 25
        updateUserData = (new ClientDataTransfer()).getUpdateUser();
        updateUserData.setId(idUser);
        updateUserData.setFirstName(nameMoreThan25);
        error = userClientAsUser.putUserNewInfo(idUser, updateUserData).then().log().all()
                .extract().as(BaseErrorBody.class);
        softAssert.assertEquals(error.getStatus().intValue(), expectedStatus, "first name more than 25 chars pass");
        softAssert.assertEquals(error.getMessage(), "\"firstName\" can contain from 1 to 25 letters");

        //first name with reserved characters
        updateUserData = (new ClientDataTransfer()).getUpdateUser();
        updateUserData.setId(idUser);
        updateUserData.setFirstName(nameWithChars);
        error = userClientAsUser.putUserNewInfo(idUser, updateUserData).then().log().all()
                .extract().as(BaseErrorBody.class);
        softAssert.assertEquals(error.getStatus().intValue(), expectedStatus, "first name with reserved characters pass");
        softAssert.assertEquals(error.getMessage(), "\"firstName\" can contain only ukrainian and english letters");

        //last name with number
        updateUserData = (new ClientDataTransfer()).getUpdateUser();
        updateUserData.setId(idUser);
        updateUserData.setLastName(nameWithNumbers);
        error = userClientAsUser.putUserNewInfo(idUser, updateUserData).then().log().all()
                .extract().as(BaseErrorBody.class);
        softAssert.assertEquals(error.getStatus().intValue(), expectedStatus, "last name with numbers pass");
        softAssert.assertEquals(error.getMessage(), "\"lastName\" can`t contain numbers");

        //last name more than 25
        updateUserData = (new ClientDataTransfer()).getUpdateUser();
        updateUserData.setId(idUser);
        updateUserData.setLastName(nameMoreThan25);
        error = userClientAsUser.putUserNewInfo(idUser, updateUserData).then().log().all()
                .extract().as(BaseErrorBody.class);
        softAssert.assertEquals(error.getStatus().intValue(), expectedStatus, "last name more than 25 chars pass");
        softAssert.assertEquals(error.getMessage(), "\"lastName\" can contain from 1 to 25 letters");

        //last name with reserved characters
        updateUserData = (new ClientDataTransfer()).getUpdateUser();
        updateUserData.setId(idUser);
        updateUserData.setLastName(nameWithChars);
        error = userClientAsUser.putUserNewInfo(idUser, updateUserData).then().log().all()
                .extract().as(BaseErrorBody.class);
        softAssert.assertEquals(error.getStatus().intValue(), expectedStatus, "last name with reserved characters pass");
        softAssert.assertEquals(error.getMessage(), "\"lastName\" can contain only ukrainian and english letters");

        softAssert.assertAll();
    }

    @Description("TUA-416 [API. Edit profile] The user or manager can change their role")
    @Issue("TUA-416")
    @Test(description = "TUA-416")
    public void testUserCanEditRole() {
        final int expectedStatus = 200;
        final String roleManager = "ROLE_MANAGER";
        final String roleUser = "ROLE_USER";
        SoftAssert softAssert = new SoftAssert();
        SuccessUpdatedUser updateUserData;
        Response response;
        UserInfo changedUser;

        //Check if user can change data

        //manager to user
        updateUserData = (new ClientDataTransfer()).getUpdateUser();
        updateUserData.setId(idUser);
        updateUserData.setRoleName(roleUser);
        response = userClientAsUser.putUserNewInfo(idUser, updateUserData);
        changedUser = response.then().log().all()
                .extract().as(UserInfo.class);
        softAssert.assertEquals(response.statusCode(), expectedStatus, "manager to user can not be");
        softAssert.assertEquals(changedUser.getRoleName(), roleUser, "manager to user can not be");

        //user to manager
        updateUserData = (new ClientDataTransfer()).getUpdateUser();
        updateUserData.setId(idUser);
        updateUserData.setRoleName(roleManager);
        response = userClientAsUser.putUserNewInfo(idUser, updateUserData);
        changedUser = response.then().log().all()
                .extract().as(UserInfo.class);
        softAssert.assertEquals(response.statusCode(), expectedStatus, "user to manager can not be");
        softAssert.assertEquals(changedUser.getRoleName(), roleManager, "user to manager can not be");

        softAssert.assertAll();
    }

    @Description("TUA-421 [API. Edit profile] Verify that user can not save changes where enter invalid data in field 'Phone'")
    @Issue("TUA-421")
    @Test(description = "TUA-421")
    public void testUserCanNotEditProfileWithInvalidPhone() {
        BaseErrorBody error;
        SuccessUpdatedUser updateUserData;
        final int expectedStatus = 400;
        SoftAssert softAssert = new SoftAssert();
        final String longPhone= "01234567889012123";
        final String charsPhone = "jdfhalkjfhe";
        final String reservedCharsPhone = "!@#$%^&*()-=+";

        //Check if user can change data

        //long phone
        updateUserData = (new ClientDataTransfer()).getUpdateUser();
        updateUserData.setId(idUser);
        updateUserData.setPhone(longPhone);
        error = userClientAsUser.putUserNewInfo(idUser, updateUserData).then().log().all()
                .extract().as(BaseErrorBody.class);
        softAssert.assertEquals(error.getStatus().intValue(), expectedStatus, "long phone pass");
        softAssert.assertEquals(error.getMessage(), "phone Phone number must contain 10 numbers and can`t contain other symbols");

        //chars in phone
        updateUserData = (new ClientDataTransfer()).getUpdateUser();
        updateUserData.setId(idUser);
        updateUserData.setPhone(charsPhone);
        error = userClientAsUser.putUserNewInfo(idUser, updateUserData).then().log().all()
                .extract().as(BaseErrorBody.class);
        softAssert.assertEquals(error.getStatus().intValue(), expectedStatus, "chars in phone pass");
        softAssert.assertEquals(error.getMessage(), "phone Phone number must contain 10 numbers and can`t contain other symbols");

        //reserved chars in phone
        updateUserData = (new ClientDataTransfer()).getUpdateUser();
        updateUserData.setId(idUser);
        updateUserData.setPhone(reservedCharsPhone);
        error = userClientAsUser.putUserNewInfo(idUser, updateUserData).then().log().all()
                .extract().as(BaseErrorBody.class);
        softAssert.assertEquals(error.getStatus().intValue(), expectedStatus, "reserved chars in phone pass");
        softAssert.assertEquals(error.getMessage(), "phone Phone number must contain 10 numbers and can`t contain other symbols");

        softAssert.assertAll();
    }

}
