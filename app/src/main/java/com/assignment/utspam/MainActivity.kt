package com.assignment.utspam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        dropdown menu
        val store = listOf("Cihampelas", "Cipadung", "Cibiru")

        val autoComplete : AutoCompleteTextView = findViewById(R.id.store_dropdown)

        val adapter = ArrayAdapter(this, R.layout.list_store, store)
        var dropdownValue : String? = null

        autoComplete.setAdapter(adapter)
        autoComplete.onItemClickListener = AdapterView.OnItemClickListener{
            adapterView, view, i, l ->

            val storeSelected = adapterView.getItemAtPosition(i)
            dropdownValue = storeSelected.toString()
            Toast.makeText(this, "Store: $storeSelected", Toast.LENGTH_SHORT).show()
        }

//        Button
        val submitBtn = findViewById<Button>(R.id.submitButton)

        submitBtn.setOnClickListener{
            //        Username Input
            val usernameInput = findViewById<EditText>(R.id.usernameInput)
            val username = usernameInput.text.toString()

            Log.d("Dashboard", "Username: $username")
            Log.d("Image", "Imagename: $dropdownValue")
            val dashboardIntent = Intent(this, Dashboard::class.java)
            dashboardIntent.putExtra("StoreName", dropdownValue)
            dashboardIntent.putExtra("Username", username)
            startActivity(dashboardIntent)
        }

    }



}