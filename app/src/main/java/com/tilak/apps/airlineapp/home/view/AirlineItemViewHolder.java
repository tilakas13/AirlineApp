package com.tilak.apps.airlineapp.home.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tilak.apps.airlineapp.Constants.AppConstants;
import com.tilak.apps.airlineapp.R;
import com.tilak.apps.airlineapp.model.AirlineItem;


public class AirlineItemViewHolder extends RecyclerView.ViewHolder {

    private final Context mContext;

    private ImageView logoUrl;
    private final TextView textviewDefaultName;
    private final TextView textviewPhoneNUmber;



    public AirlineItemViewHolder(@NonNull View itemView, @NonNull ItemClickLister itemClickLister) {

        super(itemView);


        logoUrl = itemView.findViewById(R.id.image_airline_list);
        logoUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickLister.onItemSelection(getAdapterPosition());
            }
        });
        textviewDefaultName = itemView.findViewById(R.id.text_view_default_name);
        textviewPhoneNUmber = itemView.findViewById(R.id.text_view_phone_number);
        logoUrl = itemView.findViewById(R.id.image_airline_list);
        mContext = itemView.getContext();
    }

    public void bindData(AirlineItem airlineItem) {
        textviewDefaultName.setText(airlineItem.getDefaultName());
        textviewPhoneNUmber.setText(airlineItem.getPhoneNumber());
        Glide.with(mContext).
                load(AppConstants.BASR_URL + airlineItem.getLogoUrl()).
                thumbnail(0.3f).
                placeholder(R.drawable.ic_placeholder).
                error(R.drawable.ic_placeholder).
                into(logoUrl);
    }

    interface ItemClickLister {
        void onItemSelection(int position);
    }


}
