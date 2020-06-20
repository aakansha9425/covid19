package com.example.covid_19;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DistrictViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView districtName,confirmedcase;

    public DistrictViewHolder(@NonNull View itemView) {
        super(itemView);
        this.districtName=itemView.findViewById(R.id.district_name);
        this.confirmedcase=itemView.findViewById(R.id.confirmedindistrict);
    }

    @Override
    public void onClick(View v) {

    }
}
