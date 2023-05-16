package com.example.gamescoreversions.views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.gamescoreversions.R

class GameOverActivity: AppCompatActivity() {

    private lateinit var backbutton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gameover_activity)
        bind()
        fieldTextView()
        addListener()

    }

    private fun fieldTextView(){
        if(intent != null){
            intent.extras?.apply {
                val scoreTeamA = getInt(MainActivity.TEAM_A_SCORE)
                val scoreTeamB = getInt(MainActivity.TEAM_B_SCORE)
                findViewById<TextView>(R.id.display_result_text_view).apply {
                    text = getString(R.string.result_text_display, scoreTeamA, scoreTeamB)
                }

                winnerResult(scoreTeamA, scoreTeamB)

            }

        }


    }

    private fun winnerResult(scoreTeamA: Int, scoreTeamB: Int){
        when{
            scoreTeamA > scoreTeamB -> {
                findViewById<TextView>(R.id.display_winner_text_view).apply {
                    text = getString(R.string.winner_team_a)
                }
            }
            scoreTeamA < scoreTeamB -> {
                findViewById<TextView>(R.id.display_winner_text_view).apply {
                    text = getString(R.string.winner_team_b)
                }
            }
            else -> {
                findViewById<TextView>(R.id.display_winner_text_view).apply {
                    text = getString(R.string.draw)
                }
            }
        }
    }

    private fun addListener(){
        backbutton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(MainActivity.TEAM_A_SCORE, 0)
            intent.putExtra(MainActivity.TEAM_B_SCORE, 0)
            startActivity(intent)
        }
    }

    private fun bind(){
        backbutton = findViewById(R.id.restart_button)
    }
}