package com.tilak.apps.airlineapp.home.view;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tilak.apps.airlineapp.Constants.AppConstants;
import com.tilak.apps.airlineapp.R;
import com.tilak.apps.airlineapp.databinding.ItemListAirlineBinding;
import com.tilak.apps.airlineapp.model.AirlineItem;


public class AirlineItemViewHolder extends RecyclerView.ViewHolder {

    private final Context mContext;
    private final ItemListAirlineBinding itemBinding;


    public AirlineItemViewHolder(ItemListAirlineBinding itemBinding, AirlinesListAdapter itemClickLister) {
        super(itemBinding.getRoot());

       this. itemBinding  = itemBinding;
        itemBinding.imageAirlineList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickLister.onItemSelection(getAdapterPosition());
            }
        });
        mContext = itemView.getContext();
    }

    public void bindData(AirlineItem airlineItem) {
        itemBinding.textViewDefaultName.setText(airlineItem.getDefaultName());
        itemBinding.textViewPhoneNumber.setText(airlineItem.getPhoneNumber());
        Glide.with(mContext).
                load(AppConstants.BASR_URL + airlineItem.getLogoUrl()).
                thumbnail(0.3f).
                placeholder(R.drawable.ic_placeholder).
                error(R.drawable.ic_placeholder).
                into(itemBinding.imageAirlineList);
    }

    interface ItemClickLister {
        void onItemSelection(int position);
    }

}
