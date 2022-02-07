package com.ita.edu.teachua.api.clients.sigin;
import com.ita.edu.teachua.api.models.singin.SuccessSignIn;
import com.ita.edu.teachua.api.models.user.UserCredentials;

import java.io.IOException;


public class Authorization {
    UserCredentials userSimple;
    SignInClient signInClient;
    SuccessSignIn successSignIn;
    String token;
    Integer currentAuthorizedUserId;

    public Authorization(String email, String password) throws IOException {
        this.userSimple = new UserCredentials(email, password);
        this.signInClient = new SignInClient();
        this.successSignIn = signInClient
                .successSignInRequest(userSimple).then().log().all()
                .extract()
                .as(SuccessSignIn.class);
        this.token = successSignIn.getAccessToken();
        this.currentAuthorizedUserId = successSignIn.getId();
    }

    public String getToken(){
        return token;
    }

    public Integer getCurrentAuthorizedUserID() {
        return currentAuthorizedUserId;
    }
}
