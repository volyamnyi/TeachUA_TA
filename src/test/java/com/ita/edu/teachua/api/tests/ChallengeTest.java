package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.ChallengeClient;
import com.ita.edu.teachua.api.models.challenge.request.root.Root;
import com.ita.edu.teachua.api.models.error.BaseErrorBody;
import com.ita.edu.teachua.utils.ClientDataTransfer;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class ChallengeTest extends AuthorizedAsAdminApiTestRunner {
    @Test(description = "TUA-429/432/435")
    public void addChallengeTestWithValidData() throws IOException {
        ChallengeClient challengeClient = new ChallengeClient(authorization.getToken());
        Response response = challengeClient.addChallenge();
        Root addChallenge = response.then().log().all()
                .extract()
                .as(Root.class);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(addChallenge.getName(), "Example name");
        softAssert.assertEquals(addChallenge.getTitle(), "Example title");
        softAssert.assertEquals(addChallenge.getDescription(), "Lorem ipsum dolor sit amet, consectetuer adipiscin");
        softAssert.assertEquals(addChallenge.getUser().getFirstName(), "admin");
        softAssert.assertEquals(addChallenge.getUser().getLastName(), "Admin");
        //Get challenge
        Response getChallenge = challengeClient.getChallengeById(addChallenge.getId());
        Root getChallengeById = getChallenge.then().log().all().extract().as(Root.class);
        softAssert.assertEquals(getChallengeById.getName(), "Example name");
        softAssert.assertEquals(getChallengeById.getTitle(), "Example title");
        softAssert.assertEquals(getChallengeById.getDescription(), "Lorem ipsum dolor sit amet, consectetuer adipiscin");
        softAssert.assertEquals(getChallengeById.getUser().getFirstName(), "admin");
        softAssert.assertEquals(getChallengeById.getUser().getLastName(), "Admin");
        Assert.assertEquals(getChallenge.getStatusCode(), 200);
        //Patch challenge
        Response patchChallenge = challengeClient.patchChallenge(addChallenge.getId());
        Response getChallengeByIdAfterPatching = challengeClient.getChallengeById(addChallenge.getId());
        Root getChallengeById2 = getChallengeByIdAfterPatching.then().log().all().extract().as(Root.class);
        softAssert.assertNotEquals(getChallengeById2.getName(), "Example name");
        softAssert.assertNotEquals(getChallengeById2.getTitle(), "Example title");
        softAssert.assertEquals(getChallengeById.getDescription(), "Lorem ipsum dolor sit amet, consectetuer adipiscin");
        softAssert.assertEquals(getChallengeById.getUser().getFirstName(), "admin");
        softAssert.assertEquals(getChallengeById.getUser().getLastName(), "Admin");
        softAssert.assertAll();
        //Delete challenge
        Response delete = challengeClient.deleteChallenge(addChallenge.getId());
        Assert.assertEquals(delete.getStatusCode(), 200);
    }

    @Test(description = "TUA-430/431/433/434")
    public void isNotAbleToCreateChallengeWithInvalidValues() throws IOException {
        ChallengeClient challengeClient = new ChallengeClient(authorization.getToken());
        JSONObject addChallengeJSON = new JSONObject(new ClientDataTransfer().getAddChallenge());
        addChallengeJSON.put("name", "nam");
        addChallengeJSON.put("title", "tit");
        addChallengeJSON.put("description", "des");
        Response response = challengeClient.addChallenge(addChallengeJSON);
        BaseErrorBody errorBody1 = response.then().log().all().extract().as(BaseErrorBody.class);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(!errorBody1.getMessage().isEmpty() && errorBody1.getMessage()!=null);
        softAssert.assertEquals((int) errorBody1.getStatus(), 400);
        addChallengeJSON.put("name","Lorem ipsum dolor sit amet, consect");
        addChallengeJSON.put("title","Lorem ipsum dolor sit amet, consect");
        addChallengeJSON.put("description","Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eu");
        BaseErrorBody errorBody2=response.then().log().all().extract().as(BaseErrorBody.class);
        softAssert.assertTrue(!errorBody2.getMessage().isEmpty() && errorBody2.getMessage()!=null);
        softAssert.assertEquals((int)errorBody2.getStatus(),400);
        addChallengeJSON.put("name", "эЭъЪыЫёЁ");
        addChallengeJSON.put("title", "эЭъЪыЫёЁ");
        addChallengeJSON.put("description", "эЭъЪыЫёЁэЭъЪыЫёЁэЭъЪыЫёЁэЭъЪыЫёЁэЭъЪыЫёЁ");
        BaseErrorBody errorBody3=response.then().log().all().extract().as(BaseErrorBody.class);
        softAssert.assertTrue(!errorBody3.getMessage().isEmpty() && errorBody3.getMessage()!=null);
        softAssert.assertEquals((int)errorBody3.getStatus(),400);
        String name,description,title,picture,sortNumber;
        name=null;description=null;title=null;picture=null;sortNumber=null;
        addChallengeJSON.put("name",name);
        addChallengeJSON.put("title", title);
        addChallengeJSON.put("description", description);
        addChallengeJSON.put("picture",picture);
        addChallengeJSON.put("sortNumber",sortNumber);
        BaseErrorBody errorBody4=response.then().log().all().extract().as(BaseErrorBody.class);
        softAssert.assertTrue(!errorBody4.getMessage().isEmpty() && errorBody4.getMessage()!=null);
        softAssert.assertEquals((int)errorBody4.getStatus(),400);
        addChallengeJSON.put("name"," ");
        addChallengeJSON.put("title", " ");
        addChallengeJSON.put("description", " ");
        addChallengeJSON.put("picture"," ");
        addChallengeJSON.put("sortNumber"," ");
        BaseErrorBody errorBody5=response.then().log().all().extract().as(BaseErrorBody.class);
        softAssert.assertTrue(!errorBody5.getMessage().isEmpty() && errorBody5.getMessage()!=null);
        softAssert.assertEquals((int)errorBody4.getStatus(),400);
        addChallengeJSON.put("name","");
        addChallengeJSON.put("title", "");
        addChallengeJSON.put("description", "");
        addChallengeJSON.put("picture","");
        addChallengeJSON.put("sortNumber","");
        BaseErrorBody errorBody6=response.then().log().all().extract().as(BaseErrorBody.class);
        softAssert.assertTrue(!errorBody6.getMessage().isEmpty() && errorBody6.getMessage()!=null);
        softAssert.assertEquals((int)errorBody6.getStatus(),400);
        softAssert.assertAll();

    }
}
