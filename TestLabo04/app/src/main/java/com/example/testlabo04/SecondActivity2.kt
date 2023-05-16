package com.example.testlabo04

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.testlabo04.databinding.ActivitySecond2Binding

class SecondActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivitySecond2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_second2)
        binding = ActivitySecond2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        fieldTextView()

        binding.shareButton.setOnClickListener {
            val sendInt = Intent(Intent.ACTION_SEND)

        }

    }

    private fun fieldTextView(){
        if(intent != null){
            intent.extras?.apply {
                val name = getString(MainActivity.NAME_USER)
                val email = getString(MainActivity.EMAIL_USER)
                val phone = getString(MainActivity.PHONE_USER)
                Toast.makeText(applicationContext, "name", Toast.LENGTH_SHORT).show()

                binding.namefield.apply {
                    text = getString(R.string.nombre_field, name)
                }

                binding.emailfield.apply {
                    text = getString(R.string.email_field, email)
                }


                binding.numberfield.apply {
                    text = getString(R.string.phone_number_field, phone)
                }

            }
        }
    }
}