package com.microsoft.fhldemo

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class RockPaperScissors : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rock_paper_scissors)

        findViewById<Button>(R.id.rock).setOnClickListener {v -> onSelectNextMove(v)}
        findViewById<Button>(R.id.paper).setOnClickListener {v -> onSelectNextMove(v)}
        findViewById<Button>(R.id.scissors).setOnClickListener {v -> onSelectNextMove(v)}
        findViewById<Button>(R.id.play_again).setOnClickListener {
            findViewById<LinearLayout>(R.id.choices_btn).visibility = View.VISIBLE
            findViewById<Button>(R.id.play_again).visibility = View.INVISIBLE
            with(findViewById<TextView>(R.id.result)){
                text = ""
                visibility = View.INVISIBLE
            }
        }
    }

    private fun onSelectNextMove(v: View)
    {
        val choice = when(v.id) {
            R.id.rock -> 1
            R.id.paper -> 2
            R.id.scissors -> 3
            else -> -1
        }

        val response = RPSNative.PlayGame(choice);
        val result = Result.values()[response];
        val cpuLastPlay = RPSNative.GetLastCPUPlay();

        val resultPlay = when(result) {
            Result.DRAW -> "\nIt's a draw!"
            Result.USER -> "\nYou win!"
            Result.CPU -> "\nYou lose!"
        }

        val userChoice = when(choice){
            1 -> "ROCK"
            2 -> "PAPER"
            3 -> "SCISSOR"
            else -> {"INVALID"}
        }

        val cpuPlay = when(cpuLastPlay){
            1 -> "ROCK"
            2 -> "PAPER"
            3 -> "SCISSOR"
            else -> {"INVALID"}
        }

        val txt = "You played: $userChoice \n The CPU played: $cpuPlay $resultPlay"

        with(findViewById<TextView>(R.id.result)){
            text = txt
            visibility = View.VISIBLE
        }

        findViewById<TextView>(R.id.result).text = txt
        findViewById<LinearLayout>(R.id.choices_btn).visibility = View.INVISIBLE
        findViewById<Button>(R.id.play_again).visibility = View.VISIBLE
    }
}