package com.example.gamescoreversions.viewModel

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var score = 0

    fun getscore() =
        if(score == 0){
            "0"
        }else{
            "$score"
        }
}