package com.casasmap.retrofit22.controller;

import com.casasmap.retrofit22.model.callback.FlowerService;
import com.casasmap.retrofit22.model.helper.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ramiro on 3/27/16.
 */
public class RestManager {

    private FlowerService mFlowerService;

    public FlowerService getFlowerService(){

        if(mFlowerService == null){

            Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl(Utils.HTTP.BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();

            mFlowerService = retrofit.create(FlowerService.class);

        }
        return mFlowerService;
    }

}
