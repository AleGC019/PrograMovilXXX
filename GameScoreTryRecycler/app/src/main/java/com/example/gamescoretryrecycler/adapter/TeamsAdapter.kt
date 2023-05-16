package com.example.gamescoretryrecycler.adapter

import android.content.DialogInterface.OnClickListener
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamescoretryrecycler.R
import com.example.gamescoretryrecycler.Team
import com.example.gamescoretryrecycler.TeamsProvider

class TeamsAdapter(private val teamsList: List<Team>, private val onClickListener:(Team) -> Unit) : RecyclerView.Adapter<TeamsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsViewHolder {
        val view = LayoutInflater.from(parent.context)
        return TeamsViewHolder(view.inflate(R.layout.item_score, parent, false))
    }

    override fun onBindViewHolder(holder: TeamsViewHolder, position: Int) {
        val team = teamsList[position]
        holder.render(team, onClickListener)
    }

    override fun getItemCount(): Int {
        return teamsList.size
    }
}