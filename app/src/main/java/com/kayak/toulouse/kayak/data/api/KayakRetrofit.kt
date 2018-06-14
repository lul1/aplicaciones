package com.kayak.toulouse.kayak.data.api

import retrofit2.Call
import com.kayak.toulouse.kayak.data.entities.FlyListItem
import com.kayak.toulouse.kayak.data.entities.ResponseListFlyItem
import retrofit2.http.GET

interface KayakRetrofit {
    @GET("kayak")
    fun getFly() : Call<ResponseListFlyItem>


}