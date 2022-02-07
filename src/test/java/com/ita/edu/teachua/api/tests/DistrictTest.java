package com.ita.edu.teachua.api.tests;


import com.ita.edu.teachua.api.clients.DistrictClient;
import com.ita.edu.teachua.api.models.district.SuccessDistrictModel;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class DistrictTest extends AuthorizedAsAdminApiTestRunner {
    @Test
    public void createDistrict() throws IOException {
        DistrictClient districtClient = new DistrictClient(authorization.getToken());
        Response response = districtClient.addNewDistrict();

        SuccessDistrictModel successDistrictModel = response
                .then().log().all()
                .extract().as(SuccessDistrictModel.class);

        Response delete = districtClient.deleteNewDistrict(successDistrictModel.getId());
        Assert.assertEquals(delete.getStatusCode(), 200);
    }

    @Test
    public void getListOfDistricts() throws IOException {
        DistrictClient districtClient = new DistrictClient(authorization.getToken());
        Response response = districtClient.getDistricts();
        List<SuccessDistrictModel> districts = response.then().log()
                .all().extract().jsonPath()
                .getList(".", SuccessDistrictModel.class);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
