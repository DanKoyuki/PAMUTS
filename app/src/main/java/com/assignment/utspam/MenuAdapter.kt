package com.assignment.utspam

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(private val mList:List<MenuItemModel>): RecyclerView.Adapter<MenuAdapter.ViewHolder>() {
    class ViewHolder (ItemView: View): RecyclerView.ViewHolder(ItemView) {
        val titleView: TextView = itemView.findViewById(R.id.productName)
        val descView: TextView = itemView.findViewById(R.id.productDesc)
        val pImage: ImageView = itemView.findViewById(R.id.productimage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.menudesign, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuAdapter.ViewHolder, position: Int) {
        val MenuModel = mList[position]

        holder.titleView.text = MenuModel.title
        holder.descView.text = MenuModel.desc
        when(MenuModel.title){
            "Pizza" -> holder.pImage.setImageResource(R.drawable.pizzafood)
            "Spaghetti" -> holder.pImage.setImageResource(R.drawable.spaghetti)
            "Burger" -> holder.pImage.setImageResource(R.drawable.burger)
            "Steak" -> holder.pImage.setImageResource(R.drawable.steak)
        }

        holder.itemView.setOnClickListener{
            val detailIntent = Intent(this, ProductDetail::class.java)
            val productTitle = holder.titleView.text.toString()
            detailIntent.putExtra("productTitle", productTitle)
            startActivity(detailIntent)
        }

    }

    override fun getItemCount(): Int {
        return mList.size
    }

}