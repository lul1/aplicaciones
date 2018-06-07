package com.kayak.toulouse.kayak.ui.adapters

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.kayak.toulouse.kayak.R
import com.kayak.toulouse.kayak.data.entities.FilterListItem
import com.kayak.toulouse.kayak.data.entities.FlyListItem
import kotlinx.android.synthetic.main.list_item_fly.view.*

class FilterListAdapter (
        val items: ArrayList<FilterListItem>,
        val context: Context
)

    : RecyclerView.Adapter<FilterListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_filter,null,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val filterListItem : FilterListItem=items.get(position)
        holder.textFilter.text=filterListItem.text

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textFilter = view.textFilter

    }

