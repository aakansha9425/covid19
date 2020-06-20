package com.example.covid_19.CovidApiPojo.District;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetDistrictData {

@SerializedName("Assam")
@Expose
private StateNameToGetDistrict stateNameToGetDistrict;

public StateNameToGetDistrict getStateNameToGetDistrict() {
return stateNameToGetDistrict;
}

public void setStateNameToGetDistrict(StateNameToGetDistrict stateNameToGetDistrict) {
this.stateNameToGetDistrict = stateNameToGetDistrict;
}

}