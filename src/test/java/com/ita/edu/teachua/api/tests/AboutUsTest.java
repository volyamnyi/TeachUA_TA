package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.AboutUsClient;
import com.ita.edu.teachua.api.clients.sigin.Authorization;
import com.ita.edu.teachua.api.models.about_us.AboutUsResponseModel;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

public class AboutUsTest extends AuthorizedAsAdminApiTestRunner {

    @Test(description = "Create, change and delete About Us by ID")
    @Description("[API] Create, change and delete About Us by ID")
    public void createChangeAndDeleteAboutUs() throws IOException {
        AboutUsClient aboutUsClient = new AboutUsClient(authorization.getToken());
        Response addAboutUsResponse = aboutUsClient.addNewAboutUs();
        AboutUsResponseModel addAboutUs = addAboutUsResponse.then().log().all().extract().as(AboutUsResponseModel.class);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(addAboutUs.getText(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
        softAssert.assertEquals(addAboutUs.getType(), Integer.valueOf(5));

        Response changeAboutUsResponse = aboutUsClient.changeAboutUs(addAboutUs.getId());
        AboutUsResponseModel changedAboutUs = changeAboutUsResponse.then().log().all().extract().as(AboutUsResponseModel.class);
        softAssert.assertEquals(changedAboutUs.getText(), "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        softAssert.assertEquals(changedAboutUs.getType(), Integer.valueOf(4));
        softAssert.assertAll();

        Response delete = aboutUsClient.deleteAboutUs(addAboutUs.getId());
        Assert.assertEquals(delete.getStatusCode(), 200);
    }

    @Test(description = "Get About Us by ID")
    @Description("[API] Get About Us by ID")
    public void getAboutUs() throws IOException {
        authorization = new Authorization(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword());
        SoftAssert softAssert = new SoftAssert();
        AboutUsClient aboutUsClient = new AboutUsClient(authorization.getToken());
        Response get = aboutUsClient.getAboutUs(17);
        AboutUsResponseModel aboutUsResponseModel = get.then().log().all()
                .extract().as(AboutUsResponseModel.class);
        Assert.assertEquals(get.getStatusCode(), 200);
        softAssert.assertEquals(aboutUsResponseModel.getText(), "<p>Тенісист Сергій Стаховський закликав освітян викладати дітям українською: «З 2014 року я всі свої інтерв’ю даю українською мовою, бо вважаю, що ми маємо нею пишатися. Українська мова є нашою ідентичністю. Мені хотілося б, щоб результатом цього челенджу було те, що діти, які займаються в гуртках і, в тому числі, спортивних секціях у майбутньому представляли свою країну в світі українською мовою, бо це майбутні чемпіони».</p>");
        softAssert.assertEquals(aboutUsResponseModel.getPicture(), "/upload/aboutUs/2021-12-19_19-40-44_about_img_33.png");
        softAssert.assertEquals(aboutUsResponseModel.getType(),Integer.valueOf(4));
    }

    @Test(description = "Get all About Us by ID")
    @Description("[API] Get all About Us by ID")
    public void getAllAboutUs() throws IOException {
        AboutUsClient aboutUsClient = new AboutUsClient(authorization.getToken());
        Response response = aboutUsClient.getAllAboutUs();
        List<AboutUsResponseModel> aboutUsResponseModelList = response
                .then().log().all()
                .extract().body().jsonPath().getList(".", AboutUsResponseModel.class);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
