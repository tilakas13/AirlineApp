package com.tilak.apps.airlineapp.home.view;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tilak.apps.airlineapp.databinding.FragmentAirlineListBinding;
import com.tilak.apps.airlineapp.home.presenter.AirlineListPresenter;
import com.tilak.apps.airlineapp.model.AirlineItem;
import com.tilak.apps.airlineapp.utils.Logger;

import java.util.ArrayList;
import java.util.List;


public class AirlineListFragment extends Fragment implements IAirlineListView, AirlinesListAdapter.OnItemSelectionListener {

    private static final String TAG = "AirlineListFragment";

    private OnAirlinesListItemSelection mListener;

    private AirlinesListAdapter mAdapterAirlineList;
    private AirlineListPresenter mPresenter;
    private List<AirlineItem> mListAirlines;

    @NonNull
    FragmentAirlineListBinding fragmentAirlineListBinding;


    public static AirlineListFragment newInstance() {
        return new AirlineListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentAirlineListBinding = FragmentAirlineListBinding.inflate(getActivity().getLayoutInflater());
        return fragmentAirlineListBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = new AirlineListPresenter(this);
        setupRecyclerViewAirlines();
        mPresenter.getListAirlines();
    }

    private void setupRecyclerViewAirlines() {
        Logger.logInfo(TAG, "In  setupRecyclerViewAirlines");
        mListAirlines = new ArrayList<>();
        mAdapterAirlineList = new AirlinesListAdapter(mListAirlines, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        fragmentAirlineListBinding.listAirlines.setLayoutManager(mLayoutManager);
        fragmentAirlineListBinding.listAirlines.setHasFixedSize(true);
        fragmentAirlineListBinding.listAirlines.setAdapter(mAdapterAirlineList);
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(int position) {
        if (mListener != null) {
            mListener.onAirlineListItemSelection(position);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnAirlinesListItemSelection) {
            mListener = (OnAirlinesListItemSelection) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnAirlinesListItemSelection");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDestroy() {
        if (mPresenter != null) mPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress(boolean state) {
        fragmentAirlineListBinding.progressIndicator.setVisibility(state ? View.VISIBLE : View.GONE);
    }


    @Override
    public void setListAirlines(List<AirlineItem> listAirlines) {
        mListAirlines.addAll(listAirlines);
        mAdapterAirlineList.notifyDataSetChanged();
    }

    @Override
    public void onItemSelectionListener(int position) {

    }


    public interface OnAirlinesListItemSelection {
        // TODO: Update argument type and name
        void onAirlineListItemSelection(int position);
    }


}
