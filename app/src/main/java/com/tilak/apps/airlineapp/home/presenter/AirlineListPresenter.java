package com.tilak.apps.airlineapp.home.presenter;

import com.tilak.apps.airlineapp.home.interactor.AirlineListInteractor;
import com.tilak.apps.airlineapp.home.view.IAirlineListView;
import com.tilak.apps.airlineapp.model.AirlineItem;

import java.util.List;

public class AirlineListPresenter implements IAirlinesListPresenter {
    private final AirlineListInteractor mInteractorAirlines;
    private IAirlineListView mAirlineListView;

    public AirlineListPresenter(IAirlineListView view) {
        mAirlineListView = view;
        mInteractorAirlines = new AirlineListInteractor(this);
    }

    @Override
    public void setListAirlines(List<AirlineItem> listAirlines) {
        if (mAirlineListView != null) {
            mAirlineListView.showProgress(false);
            mAirlineListView.setListAirlines(listAirlines);
        }
    }

    @Override
    public void getListAirlines() {
        mAirlineListView.showProgress(true);
        mInteractorAirlines.getListAirlinesItems();
    }

    @Override
    public void onDestroy() {
        mAirlineListView = null;
    }
}
