package com.assignment.utspam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProductDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_detail)

        textViewHandler()
        btnHandler()
    }

    private fun textViewHandler(){
        val product : TextView = findViewById(R.id.productName2)
        val price : TextView = findViewById(R.id.productPrice)
        val desc : TextView = findViewById(R.id.productDesc2)
        val image : ImageView = findViewById(R.id.productImage2)

        product.text = intent.getStringExtra("product")

        when(intent.getStringExtra("product")){
            "Pizza" -> price.text = "Price: Rp. 56.000.00-"
            "Burger" -> price.text = "Price: Rp. 66.000.00-"
            "Spaghetti" -> price.text = "Price: Rp. 66.000.00-"
            "Steak" -> price.text = "Price: Rp. 66.000.00-"
        }
        when(intent.getStringExtra("product")){
            "Pizza" -> desc.text = "Enjoy the fullest of Pineapple Pizza"
            "Burger" -> desc.text = "Enjoy the sensation of Joker and Cyclone"
            "Spaghetti" -> desc.text = "Enjoy the sensation of Joker and Cyclone"
            "Steak" -> desc.text = "Enjoy the sensation of Joker and Cyclone"
        }
        when(intent.getStringExtra("product")){
            "Pizza" -> image.setImageResource(R.drawable.pizzafood)
            "Burger" -> image.setImageResource(R.drawable.burger)
            "Spaghetti" -> image.setImageResource(R.drawable.spaghetti)
            "Steak" -> image.setImageResource(R.drawable.steak)
        }
    }

    private fun btnHandler(){
        val orderBtn : Button = findViewById(R.id.orderBtn)
        val backBtn : Button = findViewById(R.id.backBtn)
        val user = intent.getStringExtra("user")
        val store = intent.getStringExtra("store")
        orderBtn.setOnClickListener{
            val orderDetail = Intent(this, OrderDetails::class.java)
            orderDetail.putExtra("customer", user)
            orderDetail.putExtra("store", store)
            orderDetail.putExtra("product", intent.getStringExtra("product"))
            startActivity(orderDetail)
        }

        backBtn.setOnClickListener{

        }

    }

}