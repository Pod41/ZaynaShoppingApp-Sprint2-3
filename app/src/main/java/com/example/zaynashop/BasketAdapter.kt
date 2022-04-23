package com.example.zaynashop

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BasketAdapter(val context: Context, val baskets: List<Basket>)
    : RecyclerView.Adapter<BasketAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.basket_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: BasketAdapter.ViewHolder, position: Int) {
        val basket = baskets[position]
        holder.bind(basket)
    }

    override fun getItemCount() = baskets.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            var item: TextView
            var quantity: TextView

            init {
                item = itemView.findViewById(R.id.tv_item)
                quantity = itemView.findViewById(R.id.tv_quantity)
            }
            fun bind(basket: Basket) {
                item.text = basket.getItem()
                quantity.text = "Qt: "+basket.getQuantity().toString()
            }
    }
}