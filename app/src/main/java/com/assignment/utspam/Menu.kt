package com.assignment.utspam

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Menu: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_layout)

        usernameHandler()

        val MenuView = findViewById<RecyclerView>(R.id.menuItem)

        MenuView.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<MenuItemModel>()

        data.add(MenuItemModel("Pizza", "pizza for everyone"))
        data.add(MenuItemModel("Burger", "Burger for Everyone"))
        data.add(MenuItemModel("Spaghetti", "Spaghetti for Everyone"))
        data.add(MenuItemModel("Steak", "Steak for Everyone"))

        val adapter = MenuAdapter(data)
        MenuView.adapter = adapter

    }

    private fun usernameHandler() {
        val username = intent.getStringExtra("Username")
        Log.d("board", "Username: $username")
        val nameDisplay: TextView = findViewById(R.id.UsernameDisplay2)
        nameDisplay.text = "Hello, $username"
    }

}