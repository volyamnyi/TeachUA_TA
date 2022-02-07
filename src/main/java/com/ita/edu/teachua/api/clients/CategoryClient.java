package com.ita.edu.teachua.api.clients;

import com.ita.edu.teachua.api.models.category.Category;
import com.ita.edu.teachua.utils.ClientDataTransfer;
import com.ita.edu.teachua.utils.MainValueProvider;
import io.restassured.response.Response;
import java.io.IOException;

public class CategoryClient extends BaseClient{

    private final String categoryUrl;
    private final String categoryListUrl;
    private final String categoryListUrlSearch;
    protected MainValueProvider valueProvider;
    private String token;

    public CategoryClient(String token) throws IOException {
        super();
        try {
            valueProvider = new MainValueProvider();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.categoryUrl = valueProvider.getCategoryClientUrl();
        this.categoryListUrl=valueProvider.getCategoriesClientUrl();
        this.categoryListUrlSearch=valueProvider.getCategoriesSearchClientUrl();
        this.token = token;
    }

    public Response addNewCategory(){
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .body(new ClientDataTransfer().getAddCategory())
                .when()
                .post(categoryUrl);
    }

    public Response changeNewCategory(Category category, Integer id){
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .body(category)
                .when()
                .put(String.format("%s/%d", categoryUrl, id));
    }

    public Response deleteNewCategory(Integer id){
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .delete(String.format("%s/%d", categoryUrl, id));
    }

    public Response getNewCategory(Integer id){
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .get(String.format("%s/%d", categoryUrl, id));
    }

    public Response getCategories(){
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .get(categoryListUrl);
    }

    public Response getCategoriesSearch(){
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .get(categoryListUrlSearch);
    }

}
