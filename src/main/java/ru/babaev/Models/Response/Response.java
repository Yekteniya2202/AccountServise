package ru.babaev.Models.Response;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

public abstract class Response {
    @Expose
    protected int status = 0;
    @Expose
    protected String description;

    public Response(){

    }

    public Response(int status, String description){
        this.status = status;
        this.description = description;
    }


    public Response deserialize(String jsonString){
        Gson gson = new Gson();
        return gson.fromJson(jsonString, this.getClass());
    }

    public String serialize(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.excludeFieldsWithoutExposeAnnotation().create();
        return gson.toJson(this, this.getClass());
    }

    public int getStatus() {
        return status;
    }

    public boolean isValid(){
        if (status != 0){
            return true;
        }
        return false;
    }

}