package com.ita.edu.teachua.api.clients;

import com.ita.edu.teachua.api.models.task.CreateTask;
import com.ita.edu.teachua.api.models.task.UpdateTask;
import com.ita.edu.teachua.utils.MainValueProvider;
import io.restassured.response.Response;

import java.io.IOException;

public class TaskClient extends BaseClient{
    private final String challengeUrl;
    private final String taskUrl;
    private final String tasksUrl;
    private String token;

    public TaskClient(String token) throws IOException {
        super();
        this.challengeUrl = mainValueProvider.getChallengeUrl();
        this.taskUrl = mainValueProvider.getTaskUrl();
        this.tasksUrl = mainValueProvider.getTasksUrl();
        this.token = token;
    }

    public Response deleteTaskAsAdmin(int taskId){
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .when()
                .delete(String.format("%s%s/%d", challengeUrl, taskUrl, taskId));
    }

    public Response getInfoOfTask(int taskId){
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .when()
                .get(String.format("%s%s/%d", challengeUrl, taskUrl, taskId));
    }

    public Response getInfoOfAllTasks(){
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .when()
                .get(String.format("%s%s", challengeUrl, tasksUrl));
    }

    public Response getInfoOfAllTasksAsAdmin(int challengeID){
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .when()
                .get(String.format("%s/%id%s", challengeUrl, challengeID, tasksUrl));
    }

    public Response createTaskAsAdmin(int challengeID, CreateTask createTask){
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .body(createTask.toString())
                .when()
                .post(String.format("%s/%id%s", challengeUrl, challengeID, taskUrl));
    }

    public Response editTaskAsAdmin(int taskID, UpdateTask editTask){
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .body(editTask.toString())
                .when()
                .put(String.format("%s%s/%id", challengeUrl, taskUrl, taskID));
    }

}
