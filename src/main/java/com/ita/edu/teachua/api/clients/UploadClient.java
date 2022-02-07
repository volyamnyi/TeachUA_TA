package com.ita.edu.teachua.api.clients;

import com.ita.edu.teachua.api.models.upload.UploadImage;
import com.ita.edu.teachua.utils.MainValueProvider;
import io.restassured.response.Response;

import java.io.IOException;

public class UploadClient extends BaseClient{
    private final String uploadUrl;
    private final String deleteUrl;
    private String token;

    public UploadClient(String token) throws IOException {
        super();
        this.uploadUrl = mainValueProvider.getUploadImageUrl();
        this.deleteUrl = mainValueProvider.getDeleteFileUrl();
        this.token = token;
    }

    public Response uploadImage(String folder, UploadImage image){
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .body(image.toString())
                .queryParam("folder", folder)
                .when()
                .post(uploadUrl);
    }

    public Response deleteImage(String filePath){
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .queryParam("filePath", filePath)
                .when()
                .delete(deleteUrl);
    }
}
