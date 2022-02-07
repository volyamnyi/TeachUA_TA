package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.CenterClient;
import com.ita.edu.teachua.api.models.center.change_response.Root;
import com.ita.edu.teachua.api.models.center.pageable_response.Root2;
import com.ita.edu.teachua.api.models.center.resprose_swagger.CenterRoot2;
import com.ita.edu.teachua.api.models.center.total.Content;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

public class CenterTests extends AuthorizedApiTestRunner {

    @Description("[API]Test verifies if we can get a center by id")
    @Test(description = "get center by id")
    public void getCenter2() throws IOException {
        CenterClient centerClient = new CenterClient(authorization.getToken());
        Response response = centerClient.getNewCenter(267);
        Content centerRoot2 = response.then().log().all()
                .extract().as(Content.class);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.body().path("name"), centerRoot2.getName());
        Assert.assertEquals(response.body().path("description"), centerRoot2.getDescription());
    }

    @Description("[API]Test verifies if we can delete a center by id")
    @Test(description = "deleted center")
    //response swagger
    public void deleteCenter() throws IOException {
        CenterClient centerClient = new CenterClient(authorization.getToken());
        Response crateResponse = centerClient.addNewCenter();

        int id = crateResponse.path("id");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(crateResponse.getStatusCode(), 200);
        softAssert.assertEquals(crateResponse.path("name"), "Java center");

        Response response = centerClient.deleteNewCenter(id);
        softAssert.assertEquals(response.getStatusCode(), 200);
    }


    @Description("API]Test verifies if we can update a center by id")
    @Test(description = "change center")
    public void changeCenter() throws IOException {
        CenterClient centerClient = new CenterClient(authorization.getToken());
        Response crateResponse = centerClient.addNewCenter();
        Root centerRoot = crateResponse.then().log().all()
                .extract().as(Root.class);
        int id = crateResponse.path("id");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(crateResponse.getStatusCode(), 200);
        softAssert.assertEquals(crateResponse.path("name"), "Java center");

        centerRoot.setName(".NET center");
        Response updateResponse = centerClient.changeCenter(id);

        softAssert.assertEquals(updateResponse.getStatusCode(), 200);
        softAssert.assertEquals(updateResponse.path("name"), ".NET center");

        Response deleteResponse = centerClient.deleteNewCenter(id);
        Assert.assertEquals(deleteResponse.getStatusCode(), 200);
    }

    @Description("[API]Test verifies if we can get list of center")
    @Test(description = "get list of center")
    //response swagger
    public void getListOfCenters() throws IOException {
        CenterClient centerClient = new CenterClient(authorization.getToken());
        Response response = centerClient.getCenters();
        List<CenterRoot2> centers = response.then().log().all()
                .extract().jsonPath().getList(".", CenterRoot2.class);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(centers.get(0).getId(), (Integer) 4);
        Assert.assertEquals(centers.get(1).getId(), (Integer) 29);
        Assert.assertEquals(centers.get(2).getId(), (Integer) 11);
    }


    @Description("[API]Test verifies if we can get list of centers by id")
    @Test(description = "get list of centers by id")
    public void getListOfCentersById() throws IOException {
        CenterClient centerClient = new CenterClient(authorization.getToken());
        Response get = centerClient.getCentersById(29);
        Root2 centers = get.then().log().all()
                .extract().as(Root2.class);

        Assert.assertEquals(get.getStatusCode(), 200);
        Assert.assertEquals(centers.getSize(), 9);
    }

}