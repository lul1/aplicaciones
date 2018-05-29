package com.kayak.toulouse.kayak.ui.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kayak.toulouse.kayak.R
import com.kayak.toulouse.kayak.data.entities.FlyListItem

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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        }
    }