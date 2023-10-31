package com.assignment.utspam

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Menu: AppCompatActivity(), MenuAdapter.MyClickListener {

    private lateinit var MenuView: RecyclerView
    private lateinit var menuList: ArrayList<MenuItemModel>
    private lateinit var adapter: MenuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_layout)

        usernameHandler()

        MenuView = findViewById<RecyclerView>(R.id.menuItem)

        menuList = ArrayList()
        menuList.add(MenuItemModel(R.drawable.pizzafood, "Pizza", "Pinapple Pizza"))
        menuList.add(MenuItemModel(R.drawable.burger, "Burger", "Double Burger"))
        menuList.add(MenuItemModel(R.drawable.spaghetti, "Spaghetti", "pasta"))
        menuList.add(MenuItemModel(R.drawable.steak, "Steak", "Steak wa suteki"))

        adapter = MenuAdapter(menuList, this@Menu)

        MenuView.adapter = adapter
        MenuView.setHasFixedSize(true)
        MenuView.layoutManager = LinearLayoutManager(this)
    }

    private fun usernameHandler() {
        val username = intent.getStringExtra("Username")
        Log.d("board", "Username: $username")
        val nameDisplay: TextView = findViewById(R.id.UsernameDisplay2)
        nameDisplay.text = "Hello, $username"
    }

    override fun onClick(title: String) {
        val username = intent.getStringExtra("Username")
        val storename = intent.getStringExtra("Storename")
        val intent = Intent(this, ProductDetail::class.java)
        Log.d("Menu to Details", "$username, $storename :v")
        intent.putExtra("user", username)
        intent.putExtra("store", storename)
        intent.putExtra("product", title)
        startActivity(intent)
    }

}