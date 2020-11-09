package com.tilak.apps.airlineapp.home.interactor;

import com.tilak.apps.airlineapp.home.presenter.IAirlinesListPresenter;
import com.tilak.apps.airlineapp.io.AirlineApi;
import com.tilak.apps.airlineapp.model.AirlineItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Admin on 28-01-2017.
 */

public class AirlineListInteractor {


    private IAirlinesListPresenter mPresenter;

    public AirlineListInteractor(IAirlinesListPresenter presenter) {
        mPresenter = presenter;
    }

    public void getListAirlinesItems() {

        AirlineApi gitHubService = AirlineApi.retrofit.create(AirlineApi.class);
        Call<List<AirlineItem>> apiCall = gitHubService.getAirlineListFromService();

        apiCall.enqueue(new Callback<List<AirlineItem>>() {
            @Override
            public void onResponse(Call<List<AirlineItem>> call, Response<List<AirlineItem>> response) {
                List<AirlineItem> listAirlines = response.body();
                if (mPresenter != null) mPresenter.setListAirlines(listAirlines);
            }

            @Override
            public void onFailure(Call<List<AirlineItem>> call, Throwable t) {

            }
        });


    }
}
