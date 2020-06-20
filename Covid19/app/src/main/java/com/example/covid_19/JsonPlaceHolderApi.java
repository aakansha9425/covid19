package com.example.covid_19;

import com.example.covid_19.CovidApiPojo.District.StateNameToGetDistrict;
import com.example.covid_19.CovidApiPojo.State;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("data.json")
    Call<State> getstatedetails();
    @GET("data.json")
    Call<State> getTotaltested();
    @GET("state_district_wise.json")
    Call<Object> getdistricts();
}
