package com.assignment.utspam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast

class OrderDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_details)

        textHandler()
        btnDone()
    }

    private fun textHandler(){
        val details : TextView = findViewById(R.id.details)
        val customer = intent.getStringExtra("customer")
        val store = intent.getStringExtra("store")
        val product = intent.getStringExtra("product")

        val display = "$customer\nStore: $store\n$product telah dipesan"

        details.text = display
    }

    private fun btnDone(){
        val done : Button = findViewById(R.id.doneBtn)
        val ambil : CheckBox = findViewById(R.id.ambil)
        val fast : CheckBox = findViewById(R.id.fastdelivery)

        done.setOnClickListener{
            val customer = intent.getStringExtra("customer")
            val store = intent.getStringExtra("store")
            val dashIntent = Intent(this, Dashboard::class.java)
            dashIntent.putExtra("Username", customer)
            dashIntent.putExtra("StoreName", store)
            if (ambil.isChecked){
                Toast.makeText(this, "Thank you for your order $customer, please take your order at ...", Toast.LENGTH_SHORT).show()
            } else if (fast.isChecked){
                Toast.makeText(this, "Thank you for your order $customer, your order will be delivered soon", Toast.LENGTH_SHORT).show()
            }
            startActivity(dashIntent)
        }
    }

}