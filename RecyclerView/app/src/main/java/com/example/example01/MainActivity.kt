package com.example.example01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.example01.adapter.SuperHeroeAdapter
import com.example.example01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    fun initRecyclerView(){

        binding. .layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = SuperHeroeAdapter(SuperHereoProvider.superHereoList)
    }
}