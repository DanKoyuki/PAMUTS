package com.assignment.utspam

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(private val mList:ArrayList<MenuItemModel>, val listener: MyClickListener): RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    inner class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
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
        val menuModel = mList[position]

        holder.titleView.text = menuModel.title
        holder.descView.text = menuModel.desc
        holder.pImage.setImageResource(menuModel.image)

        holder.itemView.setOnClickListener{
            listener.onClick(menuModel.title)
        }

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    interface MyClickListener{
        fun onClick(title: String)
    }

}