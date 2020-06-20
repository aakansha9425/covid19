package com.example.covid_19.CovidApiPojo.District;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StateNameToGetDistrict {
    //example assam

@SerializedName("districtData")
@Expose
private DistrictData districtData;

public DistrictData getDistrictData() {
return districtData;
}

public void setDistrictData(DistrictData districtData) {
this.districtData = districtData;
}

}