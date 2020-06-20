package com.example.covid_19;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covid_19.ApiManager.ManageApi;
import com.example.covid_19.CovidApiPojo.District.Delta;
import com.example.covid_19.CovidApiPojo.District.DistrictData;
import com.example.covid_19.CovidApiPojo.District.DistrictName;
import com.example.covid_19.CovidApiPojo.District.DistrictPojo;
import com.example.covid_19.CovidApiPojo.District.GetDistrictData;
import com.example.covid_19.CovidApiPojo.District.StateNameToGetDistrict;
import com.example.covid_19.CovidApiPojo.State;
import com.example.covid_19.CovidApiPojo.Statewise;
import com.example.covid_19.CovidApiPojo.Tested;
import com.example.covid_19.RetrofitClient.RetroClient;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DistrictActivity extends AppCompatActivity {
    TextView statename;
    StatewiseAdapter statewiseAdapter;
    RecyclerView district_recycler_view;
    private ManageApi modelview;
    DistrictData districtData=new DistrictData();
    private Object objectOfDistricts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district);
        statename = findViewById(R.id.statename2);
        district_recycler_view=findViewById(R.id.district_recycler_view);
        final String name = getIntent().getStringExtra(Intent.EXTRA_TEXT);
        //statename.setText(name);
        //Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
      /*  DistrictName districtName = new DistrictName();
        Delta delta;
        delta=districtName.getDelta();*/
   /*   GetDistrictData getDistrictData= new GetDistrictData();
        DistrictName districtName = getDistrictData.getStateNameToGetDistrict().getDistrictData().getDistrictName();*/

        modelview = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(ManageApi.class);
        modelview.getDistricWiseData();
        ObserverNew();








    }


    private void ObserverNew() {
        final Observer<Object> nameObserver = new Observer<Object>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onChanged(@Nullable Object stateDetails) {
                //Toast.makeText(DistrictActivity.this, stateDetails.toString(), Toast.LENGTH_SHORT).show();
                try {

                    String replaceSpace = stateDetails.toString().replaceAll(" " , "");
                    String replaceNotes  = replaceSpace.replaceAll("notes=," , "");
                    JSONObject jsonObject = new JSONObject(replaceNotes);

                    Iterator<String> iter = jsonObject.keys();
                    List<DistrictPojo> districtNames = new ArrayList<>();
                    while (iter.hasNext()) {
                        DistrictPojo districtName = new DistrictPojo();
                        districtName.setDistrictName(iter.toString());
                        districtNames.add(districtName);


                    }
                    Toast.makeText(DistrictActivity.this, jsonObject.toString() , Toast.LENGTH_SHORT).show();
                    Toast.makeText(DistrictActivity.this, districtNames.toString(), Toast.LENGTH_SHORT).show();



                }
                catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(DistrictActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        };
        modelview.GetDistrictJson().observe(this , nameObserver);

    }
}
