package com.example.gamescoreversions.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import com.example.gamescoreversions.viewModel.MainViewModel
import com.example.gamescoreversions.R


class MainActivity : AppCompatActivity() {

    private lateinit var scoreTeamA: TextView
    private lateinit var scoreTeamB: TextView

    private lateinit var buttonTeamA: Button
    private lateinit var buttonTeamB: Button

    private lateinit var buttonGameOver: Button
    private lateinit var buttonResults: Button

    private var teamA = 0
    private var teamB = 0

    private val viewModel: MainViewModel by viewModels()
    // private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // setContentView(R.layout.activity_main_recycler)

        bind()

        if(savedInstanceState != null){
            scoreTeamA.text = savedInstanceState.getInt(TEAM_A_SCORE).toString()
            scoreTeamB.text = savedInstanceState.getInt(TEAM_B_SCORE).toString()
        }else{
            scoreTeamA.text = teamA.toString()
            scoreTeamB.text = teamB.toString()
        }


        /*
            Ni perra idea como reciclar, volver a estudiar

            val adapter = TeamsAdapters()
            adapter.setData(teams)

            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this)
         */

        addListener()
    }



    private fun addListener(){
        buttonTeamA.setOnClickListener {
            teamA++
            viewModel.score = teamA
            updateScoreA()
        }

        buttonTeamB.setOnClickListener {
            teamB++
            viewModel.score = teamB
            updateScoreB()
        }

        buttonGameOver.setOnClickListener {
            var intent = Intent(this, GameOverActivity::class.java)
            intent.putExtra(TEAM_A_SCORE, teamA)
            intent.putExtra(TEAM_B_SCORE, teamB)
            startActivity(intent)
        }

    }

    private fun updateScoreA(){
        scoreTeamA.text = viewModel.getscore()
    }

    private fun updateScoreB(){
        scoreTeamB.text = viewModel.getscore()
    }


    private fun bind(){

        scoreTeamA = findViewById(R.id.team_a_score)
        scoreTeamB = findViewById(R.id.team_b_score)

        buttonTeamA = findViewById(R.id.add_one_team_a_button)
        buttonTeamB = findViewById(R.id.add_one_team_b_button)

        buttonGameOver = findViewById(R.id.game_over_action)

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.apply {
            outState.putInt(TEAM_A_SCORE, teamA)
            outState.putInt(TEAM_B_SCORE, teamB)
        }

    }

    companion object{
        const val TEAM_A_SCORE = "TEAM_A_SCORE"
        const val TEAM_B_SCORE = "TEAM_B_SCORE"
    }
}