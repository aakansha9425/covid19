package com.example.covid_19.ApiManager;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.covid_19.CovidApiPojo.CasesTimeSeries;
import com.example.covid_19.CovidApiPojo.State;
import com.example.covid_19.CovidApiPojo.Statewise;
import com.example.covid_19.CovidApiPojo.Tested;
import com.example.covid_19.JsonPlaceHolderApi;
import com.example.covid_19.RetrofitClient.RetroClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManageApi extends ViewModel {

    private MutableLiveData<List<Statewise>> stateLiveData;
    private MutableLiveData<List<Tested>> getLiveTotal;
    private MutableLiveData<Object> getDistrictJson;


    public void getStateDetails() {
        final JsonPlaceHolderApi jsonPlaceHolderApi = RetroClient.getRetroCient("https://api.covid19india.org/").create(JsonPlaceHolderApi.class);
        final Call<State> stateDetailsCall = jsonPlaceHolderApi.getstatedetails();

        stateDetailsCall.enqueue(new Callback<State>() {
            @Override
            public void onResponse(@NonNull Call<State> call, @NonNull Response<State> response) {
                assert response.body() != null;
                //stateDetails = response.body().getStatewise();
                stateLiveData.postValue(response.body().getStatewise());
                // getLiveTotal.postValue(response.body().getTested());


            }

            @Override
            public void onFailure(Call<State> call, Throwable t) {
            }
        });
    }

    public void getDistricWiseData() {
        final JsonPlaceHolderApi jsonPlaceHolderApi = RetroClient.getRetroCient("https://api.covid19india.org/").create(JsonPlaceHolderApi.class);
        final Call<Object> stateDetailsCall = jsonPlaceHolderApi.getdistricts();

        stateDetailsCall.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(@NonNull Call<Object> call, @NonNull Response<Object> response) {
                assert response.body() != null;
                //stateDetails = response.body().getStatewise();
                Log.e("ERRORCHECK" , response.body().toString());
                getDistrictJson.postValue(response.body());
                // getLiveTotal.postValue(response.body().getTested());


            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.e("ERRORCHECK" , t.toString());
            }
        });
    }

       public void getTotalDetails()
       {
           final JsonPlaceHolderApi jsonPlaceHolderApi = RetroClient.getRetroCient("https://api.covid19india.org/").create(JsonPlaceHolderApi.class);

           final Call<State> getTotalcall = jsonPlaceHolderApi.getTotaltested();
           getTotalcall.enqueue(new Callback<State>() {
               @Override
               public void onResponse(Call<State> call, Response<State> response) {

                   //stateDetails = response.body().getStatewise();
                   // stateLiveData.postValue(response.body().getStatewise());
                   if(response.body() == null)
                   {
                       return;
                   }
                   else {
                       getLiveTotal.postValue(response.body().getTested());
                   }
               }

               @Override
               public void onFailure(Call<State> call, Throwable t) {

               }
           });
       }



    public MutableLiveData<List<Statewise>> getStateLiveData() {
        if (stateLiveData == null) {
            stateLiveData = new MutableLiveData<List<Statewise>>();
        }
        return stateLiveData;
    }
    public MutableLiveData<List<Tested>> GetLiveTotal() {
        if (getLiveTotal == null) {
            getLiveTotal = new MutableLiveData<List<Tested>>();
        }
        return getLiveTotal;
    }

    public MutableLiveData<Object> GetDistrictJson() {
        if (getDistrictJson == null) {
            getDistrictJson = new MutableLiveData<Object>();
        }
        return getDistrictJson;
    }
}
