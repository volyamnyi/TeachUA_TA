package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.BannerClient;
import com.ita.edu.teachua.api.models.banner.BannerModel;
import com.ita.edu.teachua.api.models.error.BaseErrorBody;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class BannerTest extends AuthorizedAsAdminApiTestRunner {

    @Test(description = "[API banner] Get list of all banners")
    @Description("[API] Get list of all banners")
    public void getListOfBanners() throws IOException {
        BannerClient bannerClient = new BannerClient(authorization.getToken());
        Response response = bannerClient.getBanners();
        List<BannerModel> banners = response
                .then().log().all()
                .extract().body().jsonPath().getList(".", BannerModel.class);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals((long) banners.size(), 4);
    }

    @Test(description = "[API banner] Get banner by ID")
    @Description("[API] Get banner by ID")
    public void getBanner() throws IOException {
        BannerClient bannerClient = new BannerClient(authorization.getToken());
        Response response = bannerClient.getBanner(10);
        BannerModel bannerModel = response
                .then().log().all()
                .extract().as(BannerModel.class);
        Assert.assertEquals(bannerModel.getTitle(), "Навчай українською");
        Assert.assertEquals(bannerModel.getSequenceNumber(), (Integer) 1);
    }

    @Test(description = "[API banner] add new banner with wrong path to picture")
    @Description("[API] add new banner with wrong path to picture")
    public void addNewBannerWithInvalidData() throws IOException{
        BannerClient bannerClient = new BannerClient(authorization.getToken());
        Response response = bannerClient.addBannerWithWrongPath();
        BaseErrorBody errorBody = response.then().log().all().extract().as(BaseErrorBody.class);
        Assert.assertEquals((int) errorBody.getStatus(), 400);
        Assert.assertEquals(errorBody.getMessage(), "picture Incorrect file path. It must be like /upload/*/*.png");
    }

    @Test(description = "[API banner] Add banner successfully and then delete it")
    @Description("[API] add new banner and delete it")
    public void addNewBannerAndDeleteIt() throws IOException{
        BannerClient bannerClient = new BannerClient(authorization.getToken());
        Response response = bannerClient.addNewBanner();
        BannerModel bannerModel = response
                .then().log().all()
                .extract().as(BannerModel.class);
        Assert.assertEquals((int) bannerModel.getSequenceNumber(), 5);
        Assert.assertEquals(bannerModel.getTitle(), "Happy new year");
        Assert.assertEquals(response.getStatusCode(), 200);
        Response deleteBanner = bannerClient.deleteBanner(bannerModel.getId());
        Assert.assertEquals(deleteBanner.getStatusCode(), 200);
    }
}
