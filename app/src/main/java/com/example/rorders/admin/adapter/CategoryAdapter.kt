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
import org.checkerframework.checker.nullness.qual.NonNull

class CategoryAdapter (
    private var mContext: Context,
    private var categoryArrayList: ArrayList<MenuDetailModel>,
) :

    RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {
    var isArrowClicked:Boolean=false
    lateinit var itemList:ArrayList<ItemListModel>
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
       var categoryNameTxt: TextView = view.findViewById(R.id.cat_name)
        var linearMain:LinearLayout=view.findViewById(R.id.linear_main)
        var arrowUp:ImageView=view.findViewById(R.id.arrow_up)
        var arrowDown:ImageView=view.findViewById(R.id.arrow_down)
        var itemsRecycler:RecyclerView=view.findViewById(R.id.items_rec)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_category_list, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        itemList= ArrayList()
        holder.categoryNameTxt.text = categoryArrayList[position].type


        holder.linearMain.setOnClickListener {
            if (isArrowClicked==false){
                isArrowClicked=true
                holder.arrowDown.visibility=View.GONE
                holder.arrowUp.visibility=View.VISIBLE
                holder.itemsRecycler.visibility=View.VISIBLE
                holder.itemsRecycler.layoutManager=LinearLayoutManager(mContext)
                var adapter=ItemsAdapter(mContext,categoryArrayList[position].detailList)
                holder.itemsRecycler.adapter=adapter
            }else{
                isArrowClicked=false
                holder.arrowDown.visibility=View.VISIBLE
                holder.arrowUp.visibility=View.GONE
                holder.itemsRecycler.visibility=View.GONE
            }


        }

    }


    override fun getItemCount(): Int {
        return categoryArrayList.size
    }


}