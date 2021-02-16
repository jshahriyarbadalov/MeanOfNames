package com.shahriyar.meaningofname.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Meaning")
    @Expose
    private String meaning;
    @SerializedName("Gender")
    @Expose
    private String gender;

    public Response() {
    }

    public Response(String name, String meaning, String gender) {
        this.name = name;
        this.meaning = meaning;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
