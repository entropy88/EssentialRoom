package com.example.entropy.essentialroom;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.entropy.essentialroom.R;

import org.w3c.dom.Text;

public class CustomObjectsViewHolder extends RecyclerView.ViewHolder{
    TextView fieldOneValue;
    TextView fieldTwoValue;
    TextView fieldThreeValue;




    public CustomObjectsViewHolder(View itemView) {
        super(itemView);
        fieldOneValue= (TextView)itemView.findViewById(R.id.tv_fieldOne_value);
        fieldTwoValue= (TextView)itemView.findViewById(R.id.tv_fieldTwo_value);
        fieldThreeValue= (TextView)itemView.findViewById(R.id.tv_fieldThree_value);

    }
}
