package com.kayak.toulouse.kayak.ui.screens

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.kayak.toulouse.kayak.BuildConfig
import com.kayak.toulouse.kayak.R
import com.kayak.toulouse.kayak.data.api.KayakRetrofit
import com.kayak.toulouse.kayak.data.entities.FlyListItem
import com.kayak.toulouse.kayak.data.entities.FlyListItemFly
import com.kayak.toulouse.kayak.data.entities.ResponseListFlyItem
import com.kayak.toulouse.kayak.ui.adapters.FlyListAdapter
import kotlinx.android.synthetic.main.activity_fly_list.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class FlyListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fly_list)
        rcvFlyList.layoutManager = LinearLayoutManager(this)

    }
    fun getFlyItems() : ArrayList<FlyListItem>{
        val items : ArrayList<FlyListItem> = ArrayList()
        val client = OkHttpClient.Builder().build()
        val retrofit = Retrofit.Builder()
                .client(client)
                .baseUrl(BuildConfig.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val kayakService = retrofit.create(KayakRetrofit::class.java)
        val callable: Call<ResponseListFlyItem> =kayakService.getFly()
        callable.enqueue(object : Callback<ResponseListFlyItem>{
            override fun onFailure(call: Call<ResponseListFlyItem>?, t: Throwable?) {

                Toast.makeText(
                        this@FlyListActivity, t?.message, Toast.LENGTH_SHORT)
                        .show()
            }

            override fun onResponse (call: Call<ResponseListFlyItem>?, response: Response<ResponseListFlyItem>){
                val items : ArrayList<FlyListItem> = ArrayList()
                android.util.Log.i("here", "yes")

                android.util.Log.i("Response Contents", response?.body().toString())
                response?.body()?.results?.iterator()?.forEach {
                    val item = FlyListItemFly(
                            Date.parse("2015-12-12"),"Origin",
                            Date,parse("2015-12-12")
                }
                rcvFlyList.layoutManager = LinearLayoutManager(this@FlyListActivity)

                rcvFlyList.adapter = FlyListAdapter(items, this@FlyListActivity)


            }

        })
        /*
        val origin1 = FlyListItemFly(
        Date("11/12/2010"),
        "Lima",
        Date("12/12/2010"),
        "Madrid",
        R.drawable.ic_launcher_background
        )

        val item1 = FlyListItem(origin1,origin1, 1240.50, "Delta")
        items.add(item1)
        val origin2 = FlyListItemFly(
                Date("11/12/2010"),
                "Lima",
                Date("12/12/2010"),
                "Madrid",
                R.drawable.ic_launcher_background

        )
        val item2 = FlyListItem(origin2,origin2, 1240.50, "Delta")
        items.add(item2)
        */
        return items
    }
}






