package com.example.example01.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.example01.R
import com.example.example01.SuperHereoProvider
import com.example.example01.SuperHeroe

class SuperHeroeAdapter(private val superhereoList: List<SuperHeroe>) : RecyclerView.Adapter<SuperHereoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHereoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperHereoViewHolder(layoutInflater.inflate(R.layout.item_superheroe, parent, false))
    }

    override fun onBindViewHolder(holder: SuperHereoViewHolder, position: Int) {
        val item = superhereoList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return superhereoList.size
    }
}