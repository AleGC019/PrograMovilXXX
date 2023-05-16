package com.example.gamescoretryrecycler.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.gamescoretryrecycler.Team
import com.example.gamescoretryrecycler.databinding.ItemScoreBinding

class TeamsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemScoreBinding.bind(view)


    fun render(ModelTeam: Team, onClickListener: (Team) -> Unit) {
        binding.teamNameTable.text = ModelTeam.name
        binding.teamScore.text = ModelTeam.score.toString()

        binding.addOneTeamButton.setOnClickListener{
            onClickListener(ModelTeam)
        }
        /*
        binding.addOneTeamButton.setOnClickListener {
            Toast.makeText(
                binding.addOneTeamButton.context,
                "Add 1 to ${ModelTeam.name}",
                Toast.LENGTH_SHORT
            ).show()
            ModelTeam.score = ModelTeam.score + 1
            binding.teamScore.text = ModelTeam.score.toString()

         */
        }
    }
