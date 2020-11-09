package com.tilak.apps.airlineapp.home.view;


import com.tilak.apps.airlineapp.model.AirlineItem;

import java.util.List;

public interface IAirlineListView {
    void showProgress(boolean state);

    void setListAirlines(List<AirlineItem> listAirlines);
}
