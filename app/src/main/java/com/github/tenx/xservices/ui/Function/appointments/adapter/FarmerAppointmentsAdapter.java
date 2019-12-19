package com.github.tenx.xservices.ui.Function.appointments.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.tenx.xservices.R;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class FarmerAppointmentsAdapter extends RecyclerView.Adapter<FarmerAppointmentsAdapter.CartViewHolder> {

    private List<AppointmentsDataModel> mList;
    private View.OnClickListener onItemClickListener;

    private static final String TAG = "CartAdapter";

    @Inject
    public FarmerAppointmentsAdapter(){
        mList = new ArrayList<>();
    }


    public void setOnItemClickListener(View.OnClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }


    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_appointments,parent,false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        //TODO do the glide part

        holder.name.setText(mList.get(position).getName());
        holder.price.setText(mList.get(position).getName());
        holder.status.setText(mList.get(position).getStatus());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void updateListItems(List<AppointmentsDataModel> mList){
        this.mList.addAll(mList);
        notifyDataSetChanged();
    }



    public class CartViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView price;
        ImageView profilePic;
        TextView status;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setTag(this);

            name = itemView.findViewById(R.id.tv_name);
            price = itemView.findViewById(R.id.tv_notifications_type);
            profilePic = itemView.findViewById(R.id.profile_pic);
            status = itemView.findViewById(R.id.tv_status);


            itemView.setOnClickListener(onItemClickListener);

        }

    }
}
