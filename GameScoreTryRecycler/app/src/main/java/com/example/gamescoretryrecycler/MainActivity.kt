package com.example.gamescoretryrecycler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gamescoretryrecycler.adapter.TeamsAdapter
import com.example.gamescoretryrecycler.databinding.ActivityMainBinding
import com.example.gamescoretryrecycler.GameOverActivity

class MainActivity : AppCompatActivity() {

    private lateinit var Result: Button
    private lateinit var binding: ActivityMainBinding

    private var scoreA = 0
    private var scoreB = 0


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bind()
        initRecyclerView()

    }

    private fun initRecyclerView() {

        binding.recyclerTableScore.layoutManager = LinearLayoutManager(this)
        binding.recyclerTableScore.adapter =
            TeamsAdapter(TeamsProvider.TeamsList) { team ->
                onItemSelected(
                    team
                )
                Result.setOnClickListener {
                    val intent = Intent(this, GameOverActivity::class.java)
                    intent.putExtra(TEAM_A_SCORE, scoreA)
                    intent.putExtra(TEAM_B_SCORE, scoreB)
                    startActivity(intent)
                }
            }
    }

    private fun onItemSelected(TeamReference: Team) {
        Toast.makeText(this, "Add 1 point to ${TeamReference.name}", Toast.LENGTH_SHORT).show()
        TeamReference.score = TeamReference.score + 1
        binding.recyclerTableScore.adapter?.notifyDataSetChanged()

        if (TeamReference.name == "Team A"){
            scoreA = TeamReference.score
        } else {
            scoreB = TeamReference.score
        }


    }

    private fun bind() {
        Result = findViewById(R.id.btnSeeResults)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.apply {
            outState.putInt(TEAM_A_SCORE, scoreA)
            outState.putInt(TEAM_B_SCORE, scoreB)
        }

    }

    companion object{
        const val TEAM_A_SCORE = "TEAM_A_SCORE"
        const val TEAM_B_SCORE = "TEAM_B_SCORE"
    }
}