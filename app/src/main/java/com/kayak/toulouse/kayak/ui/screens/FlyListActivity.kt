package com.kayak.toulouse.kayak.ui.screens

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.kayak.toulouse.kayak.R
import com.kayak.toulouse.kayak.data.entities.FlyListItem
import com.kayak.toulouse.kayak.data.entities.FlyListItemFly
import com.kayak.toulouse.kayak.ui.adapters.FlyListAdapter
import kotlinx.android.synthetic.main.activity_fly_list.*
import java.util.*

class FlyListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fly_list)
        rcvFlyList.layoutManager = LinearLayoutManager(this)
        rcvFlyList.adapter = FlyListAdapter(getFlyItems(),this)

    }
    fun getFlyItems() : ArrayList<FlyListItem>{
        val items : ArrayList<FlyListItem> = ArrayList()

        //
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
        //
        return items
    }
}






