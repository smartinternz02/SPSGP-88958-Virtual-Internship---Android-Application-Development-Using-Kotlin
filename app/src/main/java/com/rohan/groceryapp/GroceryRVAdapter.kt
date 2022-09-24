package com.rohan.groceryapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GroceryRVAdapter(var list: List<GroceryItems>,
                       val groceryItemClickInterface: GroceryItemClickInterface
                       ) : RecyclerView.Adapter<GroceryRVAdapter.GroceryViewHolder>() {


    inner class GroceryViewHolder(itemview:View): RecyclerView.ViewHolder(itemview){
        val NameTV = itemview.findViewById<TextView>(R.id.idTVItemName)
        val QuantityTV = itemview.findViewById<TextView>(R.id.idTVQuantity)
        val rateTV = itemview.findViewById<TextView>(R.id.idTvRate)
        val amountTV = itemview.findViewById<TextView>(R.id.idTVTotalAmt)
        val deleteTV = itemview.findViewById<ImageView>(R.id.idTVDelete)
    }




    interface GroceryItemClickInterface{
        fun onItemClick(groceryItems: GroceryItems)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grocery_rv_items,parent,false)
        return GroceryViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {
        holder.NameTV.text = list.get(position).itemName
        holder.QuantityTV.text = list.get(position).ItemQuantity.toString()
        holder.rateTV.text = "Rs. "+ list.get(position).ItemPrice.toString()
        val itemTotal : Int = list.get(position).ItemPrice + list.get(position).ItemQuantity
        holder.amountTV.text = "Rs. "+ itemTotal.toString()
        holder.deleteTV.setOnClickListener {
            groceryItemClickInterface.onItemClick(list.get(position))
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }
}