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
            findViewById<TextView>(R.id.result).text = ""
        }
    }

    fun onSelectNextMove(v: View)
    {
        val choice = when(v.id) {
            R.id.rock -> 1
            R.id.paper -> 2
            R.id.scissors -> 3
            else -> -1
        }

        val response = RPSNative.PlayGame(choice);
        val result = Result.values()[response];

        val txt = when(result) {
            Result.DRAW -> "It's a draw!"
            Result.USER -> "You win!"
            Result.CPU -> "You lose!"
        }

        findViewById<TextView>(R.id.result).text = txt
        findViewById<LinearLayout>(R.id.choices_btn).visibility = View.INVISIBLE
        findViewById<Button>(R.id.play_again).visibility = View.VISIBLE
    }
}