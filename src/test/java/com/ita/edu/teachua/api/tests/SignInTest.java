package com.ita.edu.teachua.api.tests;
import com.ita.edu.teachua.api.clients.sigin.SignInClient;
import com.ita.edu.teachua.api.models.singin.SuccessSignIn;
import com.ita.edu.teachua.api.models.user.UserCredentials;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SignInTest extends ApiTestRunner {

    @Test(description="TUA-406")
    public void successSignInTest() throws IOException {
        SignInClient signInClient = new SignInClient();

        SuccessSignIn successSignIn = signInClient
                .successSignInRequest(new UserCredentials("admin@gmail.com","admin"))
                .then().log().all()
                .extract()
                .as(SuccessSignIn.class);

        Assert.assertNotNull(successSignIn.getAccessToken());
    }
}
