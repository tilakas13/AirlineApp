package com.tilak.apps.airlineapp.home.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.tilak.apps.airlineapp.R;
import com.tilak.apps.airlineapp.model.AirlineItem;

import java.util.List;

/**
 * Created by Admin on 26-01-2017.
 */

public class AirlinesListAdapter extends RecyclerView.Adapter<AirlineItemViewHolder> implements AirlineItemViewHolder.ItemClickLister {


    private List<AirlineItem> mListAirlines;
    private OnItemSelectionListener mListener;

    public AirlinesListAdapter(List<AirlineItem> listItems, OnItemSelectionListener listener) {
        mListAirlines = listItems;
        mListener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public AirlineItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_airline, parent, false);
        return new AirlineItemViewHolder(view,this);
    }

    @Override
    public void onBindViewHolder(AirlineItemViewHolder holder, int position) {
        holder.bindViewHolder(mListAirlines.get(position));
    }

    @Override
    public int getItemCount() {
        return mListAirlines != null ? mListAirlines.size() : 0;
    }

    @Override
    public void onItemSelection(int position) {
        mListener.onItemSelectionListener(position);
    }



    interface OnItemSelectionListener {
        void onItemSelectionListener(int position);
    }
}
