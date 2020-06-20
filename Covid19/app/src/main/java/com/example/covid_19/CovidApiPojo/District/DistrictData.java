package com.example.covid_19.CovidApiPojo.District;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DistrictData {

    @Expose
    private DistrictName districtName;

    public DistrictName getDistrictName() {
        return districtName;
    }

    public void setDistrictName(DistrictName districtName) {
        this.districtName = districtName;
    }

}