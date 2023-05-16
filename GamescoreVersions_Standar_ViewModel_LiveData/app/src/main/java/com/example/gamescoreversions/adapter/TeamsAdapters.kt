package com.example.gamescoreversions.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gamescoreversions.R
import com.example.gamescoreversions.provider.Team

class TeamsAdapters : RecyclerView.Adapter<TeamsAdapters.ViewHolder>() {

    private var teams: List<Team>? = null

    inner class ViewHolder(var itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(team: Team) {
            val nameTextView: TextView = itemView.findViewById(R.id.team_name_table)
            nameTextView.text = team.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_score, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        teams?.let {
            holder.bind(it[position])
        }
    }

    override fun getItemCount() = teams?.size ?: 0

    fun setData(teams: List<Team>) {
        this.teams = teams
        notifyDataSetChanged()
    }
}