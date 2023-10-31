package com.assignment.utspam

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_view)

        usernameHandler()
        imageHandler()
        buttonHandler()
    }

    private fun usernameHandler(){
        val username = intent.getStringExtra("Username")
        Log.d("board", "Username: $username")
        val nameDisplay : TextView = findViewById(R.id.UsernameDisplay)
        nameDisplay.text = "Hello, $username"

        val storeName = intent.getStringExtra("StoreName")
        val storeDisplay : TextView = findViewById(R.id.storetitleName)
        storeDisplay.text= storeName
    }

    private fun imageHandler(){
        val imageName = intent.getStringExtra("StoreName")
        val imageDisplay : ImageView = findViewById(R.id.restaurantImage)
        when(imageName){
            "Cihampelas" -> imageDisplay.setImageResource(R.drawable.res1)
            "Cipadung" -> imageDisplay.setImageResource(R.drawable.res2)
            "Cibiru" -> imageDisplay.setImageResource(R.drawable.res3)
            else -> imageDisplay.setImageResource(R.drawable.res3)
        }
    }

    private fun buttonHandler(){
        val menuBtn : Button = findViewById(R.id.MenuBtn)
        menuBtn.setOnClickListener{
            val username = intent.getStringExtra("Username")
            val storename = intent.getStringExtra("StoreName")
            val menuIntent = Intent(this, Menu::class.java)
            menuIntent.putExtra("Username", username)
            menuIntent.putExtra("Storename", storename)
            startActivity(menuIntent)
        }
    }
}