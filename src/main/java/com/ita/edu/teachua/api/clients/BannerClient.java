package com.ita.edu.teachua.api.clients;

import com.ita.edu.teachua.utils.ClientDataTransfer;
import com.ita.edu.teachua.utils.MainValueProvider;
import io.restassured.response.Response;

import java.io.IOException;

public class BannerClient extends BaseClient {
    private final String bannerUrl;
    private final String bannersUrl;
    protected MainValueProvider valueProvider;
    private final String token;

    public BannerClient(String token) throws IOException{
        super();
        try {
            valueProvider = new MainValueProvider();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.bannersUrl = mainValueProvider.getBannersClientUrl();
        this.bannerUrl = mainValueProvider.getBannerClientUrl();
        this.token = token;
    }
    public Response addNewBanner(){
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .body(new ClientDataTransfer().getAddBanner())
                .log().all()
                .when()
                .post(bannerUrl);
    }
    public Response addBannerWithWrongPath(){
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .body(new ClientDataTransfer().getAddBannerWithWrongPath())
                .log().all()
                .when()
                .post(bannerUrl);
    }

    public Response getBanner(Integer id){
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .get(String.format("%s/%d", bannerUrl, id));
    }
    public Response getBanners(){
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .get(bannersUrl);
    }

    public Response changeBanner(Integer id){
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .body(new ClientDataTransfer().getAddBanner())
                .when()
                .put(String.format("%s/%d", bannerUrl, id));
    }
    public Response deleteBanner(Integer id){
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s",token))
                .delete(String.format("%s/%d",bannerUrl,id));
    }
}

