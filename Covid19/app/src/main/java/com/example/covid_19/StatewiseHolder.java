package com.example.covid_19;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class StatewiseHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView activecases,confirmedcases,deathcase,recoveredcase,statename;
     public RelativeLayout state;
     RecyclerViewitemClickListner recyclerViewitemClickListner;

    public StatewiseHolder(@NonNull View itemView) {
        super(itemView);
        this.state=itemView.findViewById(R.id.state_cardview);
        this.statename=itemView.findViewById(R.id.state_name);

        this.activecases=itemView.findViewById(R.id.activecasenumber);
        this.confirmedcases=itemView.findViewById(R.id.confirmedcasenumber);
        this.recoveredcase=itemView.findViewById(R.id.recoveredcasenumber);
        this.deathcase=itemView.findViewById(R.id.deathcasenumber);
        itemView.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        this.recyclerViewitemClickListner.onItemClick(v,getLayoutPosition());


    }


}
