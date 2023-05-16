package com.example.gamescoreversions.provider

data class Team(var name:String, var score:Int)

val teams = listOf(
    Team("Team A", 0),
    Team("Team B", 0),
)