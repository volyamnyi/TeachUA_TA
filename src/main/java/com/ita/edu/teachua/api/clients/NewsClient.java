package com.ita.edu.teachua.api.clients;

import com.ita.edu.teachua.api.models.news.NewsModel;
import com.ita.edu.teachua.utils.ClientDataTransfer;
import com.ita.edu.teachua.utils.MainValueProvider;
import io.restassured.response.Response;

import java.io.IOException;

public class NewsClient extends BaseClient{
    private final String newsClientUrl;
    private final String newsListClientUrl;
    private final String newsListSearchClientUrl;
    protected MainValueProvider mainValueProvider;
    private final String token;

    public NewsClient(String token) throws IOException {
        try {
            mainValueProvider = new MainValueProvider();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.newsClientUrl = mainValueProvider.getNewsClientUrl();
        this.newsListClientUrl = mainValueProvider.getNewsListClientUrl();
        this.newsListSearchClientUrl = mainValueProvider.getNewsListSearchClientUrl();
        this.token = token;
    }

    public Response getNewsById(Integer id) {
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .log().all()
                .when()
                .get(String.format("%s/%d", newsClientUrl, id));
    }
    public Response getListOfNews() {
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .log().all()
                .when()
                .get(newsListClientUrl);
    }
    public Response getListOfNewsSearch(){
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .log().all()
                .when()
                .get(newsListSearchClientUrl);
    }
    public Response addNews() {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .body(new ClientDataTransfer().getAddNews())
                .log().all()
                .when()
                .post(newsClientUrl);
    }
    public Response changeNewsById(NewsModel newsModel, Integer id) {
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .body(newsModel)
                .log().all()
                .when()
                .put(String.format("%s/%d", newsClientUrl, id));
    }
    public Response deleteNews(Integer id) {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s",token))
                .log().all()
                .when()
                .delete(String.format("%s/%d", newsClientUrl, id));
    }
}
