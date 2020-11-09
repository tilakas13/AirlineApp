package com.tilak.apps.airlineapp.home.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tilak.apps.airlineapp.BR;
import com.tilak.apps.airlineapp.Constants.AppConstants;
import com.tilak.apps.airlineapp.R;
import com.tilak.apps.airlineapp.model.AirlineItem;


public class AirlineItemViewHolder extends RecyclerView.ViewHolder {

    private final Context mContext;

    ImageView logoUrl;
    TextView textviewDefaultName;
    TextView textviewPhoneNUmber;

    private ItemClickLister listener;
    private ViewDataBinding mViewDataBinding;

    public ViewDataBinding getViewDataBinding() {
        return mViewDataBinding;
    }

    interface ItemClickLister {
        void onItemSelection(int position);
    }


    public AirlineItemViewHolder(View itemView, ItemClickLister listener) {
        super(itemView);
        logoUrl = itemView.findViewById(R.id.image_airline_list);
        logoUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemSelection(getAdapterPosition());
            }
        });
        textviewDefaultName = itemView.findViewById(R.id.text_view_default_name);
        textviewPhoneNUmber = itemView.findViewById(R.id.text_view_phone_number);
        logoUrl = itemView.findViewById(R.id.image_airline_list);
        mContext = itemView.getContext();
        this.mViewDataBinding = DataBindingUtil.bind(itemView);
        this.listener = listener;
    }


    void bindViewHolder(AirlineItem item) {
        mViewDataBinding.setVariable(BR.itemAirlines, item);
        mViewDataBinding.executePendingBindings();
    }

    @BindingAdapter({"bind:image_url"})
    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).
                load(AppConstants.BASR_URL + url).
                thumbnail(0.3f).
                placeholder(R.drawable.ic_placeholder).
                error(R.drawable.ic_placeholder).
                into(imageView);
    }

}
