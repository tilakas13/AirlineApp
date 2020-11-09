package com.tilak.apps.airlineapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 25-08-2016.
 */
public class AirlineItem {

    @SerializedName("__clazz")
    private String clazzName;
    @SerializedName("code")
    private String code;
    @SerializedName("defaultName")
    private String defaultName;
    @SerializedName("logoURL")
    private String logoUrl;
    @SerializedName("name")
    private String name;
    @SerializedName("phone")
    private String phoneNumber;
    @SerializedName("site")
    private String siteUrl;
    @SerializedName("usName")
    private String airlinesName;



    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDefaultName() {
        return defaultName;
    }

    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getAirlinesName() {
        return airlinesName;
    }

    public void setAirlinesName(String airlinesName) {
        this.airlinesName = airlinesName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
