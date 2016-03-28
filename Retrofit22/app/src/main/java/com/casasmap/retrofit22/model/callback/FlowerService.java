package com.casasmap.retrofit22.model.callback;

import com.casasmap.retrofit22.model.Flower;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ramiro on 3/27/16.
 */
public interface FlowerService {
    @GET("/feeds/flowers.json")
    Call<List<Flower>> getAllFlowers();
}
