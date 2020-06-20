package com.example.covid_19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_19.CovidApiPojo.District.Delta;
import com.example.covid_19.CovidApiPojo.District.GetDistrictData;

import java.util.ArrayList;
import java.util.List;

public class Districtadapter extends RecyclerView.Adapter<DistrictViewHolder> {

    List<GetDistrictData> districtwise=new ArrayList<>();
    Context context;

    public Districtadapter(List<GetDistrictData> districtwise, Context context) {
        this.districtwise = districtwise;
        this.context = context;
    }

    @NonNull
    @Override
    public DistrictViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_district, null);
        return new DistrictViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DistrictViewHolder holder, int position) {
        for (int i = 0; i < districtwise.size(); i++) {
            holder.confirmedcase.setText(districtwise.get(position).getStateNameToGetDistrict().getDistrictData().getDistrictName().getConfirmed());
           // holder.districtName.setText(districtwise.get(position).getStateNameToGetDistrict().getDistrictData().getDistrictName());
        }
    }

    @Override
    public int getItemCount() {
        return districtwise.size();
    }
}
