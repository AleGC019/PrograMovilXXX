package com.example.testlabo04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testlabo04.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textButton.setOnClickListener {
            val intent = Intent(this, SecondActivity2::class.java)
            intent.putExtra(NAME_USER,  binding.nfield.text.toString())
            intent.putExtra(EMAIL_USER,  binding.mfield.text.toString())
            intent.putExtra(PHONE_USER,  binding.pfield.text.toString())
            startActivity(intent)
        }

    }



    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.apply {
            outState.putString(NAME_USER, binding.nfield.text.toString())
            outState.putString(EMAIL_USER, binding.mfield.text.toString())
            outState.putString(PHONE_USER, binding.pfield.text.toString())
        }

    }

    companion object{
        const val NAME_USER = "NAME_USER"
        const val EMAIL_USER = "EMAIL_USER"
        const val PHONE_USER = "PHONE_USER"
    }
}