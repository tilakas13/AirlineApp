package com.tilak.apps.airlineapp.home.presenter;

import com.tilak.apps.airlineapp.model.AirlineItem;

import java.util.List;

public interface IAirlinesListPresenter  {
    void setListAirlines(List<AirlineItem> listAirlines);

    void getListAirlines();

    void onDestroy();
}
