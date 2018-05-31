package com.kayak.toulouse.kayak.ui.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.kayak.toulouse.kayak.R
import com.kayak.toulouse.kayak.data.entities.FlyListItem
import kotlinx.android.synthetic.main.list_item_fly.view.*

class FlyListAdapter (
        val items: ArrayList<FlyListItem>,
        val context: Context
        )

    : RecyclerView.Adapter<FlyListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_fly,null,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val flyListItem : FlyListItem=items.get(position)
        holder.imgAirline.setImageDrawable(context.getDrawable(flyListItem.origin.airlineLogo))
        holder.textAirlines.text=flyListItem.airlines
        holder.textCityDestination.text=flyListItem.origin.destinationCity
        holder.textCityOrigin.text=flyListItem.origin.originCity
        holder.textFlightTime.text=flyListItem.origin.getFlyLongerThanDay().toString()
        holder.textPrice.text=flyListItem.price.toDouble().toString()
        holder.textTimeDestination.text=flyListItem.origin.originDate.toString()
        holder.textTimeOrigin.text=flyListItem.origin.destinationDate.toString()




    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgAirline : ImageView = view.imgAirline;
        val textAirlines : TextView = view.textAirlines;
        val textCityDestination = view.textCityDestination;
        val textCityOrigin = view.textCityOrigin;
        val textFlightTime = view.textFlightTime;
        val textPrice = view.textPrice;
        val textTimeDestination = view.textTimeDestination;
        val textTimeOrigin = view.textTimeOrigin;

        }
    }