package com.example.rorders.admin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rorders.R
import com.example.rorders.admin.model.ItemListModel
import com.example.rorders.admin.model.MenuDetailModel

class ItemsAdapter (
    private var mContext: Context,
    private var itemsArrayList: ArrayList<ItemListModel>
) :

    RecyclerView.Adapter<ItemsAdapter.MyViewHolder>() {
    var isArrowClicked:Boolean=false

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemName: TextView = view.findViewById(R.id.itemname)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_item_list, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.itemName.text = itemsArrayList[position].itemName


    }


    override fun getItemCount(): Int {
        return itemsArrayList.size
    }


}