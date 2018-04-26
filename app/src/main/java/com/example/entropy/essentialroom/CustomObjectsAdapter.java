package com.example.entropy.essentialroom;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.entropy.essentialroom.CustomObject;
import com.example.entropy.essentialroom.R;

import java.util.List;

public class CustomObjectsAdapter extends RecyclerView.Adapter<CustomObjectsViewHolder> {
    private List<CustomObject> data;

    public CustomObjectsAdapter(List<CustomObject> data) {

        this.data = data;
    }

    @Override
    public CustomObjectsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.object_item_layout,parent,false);
        CustomObjectsViewHolder viewHolder= new CustomObjectsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomObjectsViewHolder holder, int position) {
        CustomObject item=data.get(position);

        holder.fieldOneValue.setText(item.getFieldOne());
        holder.fieldTwoValue.setText(item.getFieldTwo());
        holder.fieldThreeValue.setText(item.getFieldThree());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
