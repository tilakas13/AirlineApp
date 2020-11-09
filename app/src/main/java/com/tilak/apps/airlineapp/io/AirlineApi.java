package com.tilak.apps.airlineapp.io;


import com.tilak.apps.airlineapp.Constants.AppConstants;
import com.tilak.apps.airlineapp.model.AirlineItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Admin on 21-06-2016.
 */
public interface AirlineApi {

    @GET("h/mobileapis/directory/airlines")
    Call<List<AirlineItem>> getAirlineListFromService();

     Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(AppConstants.BASR_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
