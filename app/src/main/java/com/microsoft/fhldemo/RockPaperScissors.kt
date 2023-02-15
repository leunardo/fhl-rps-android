package com.microsoft.fhldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.microsoft.rpsnative.Result
import com.microsoft.rpsnative.Move

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
            R.id.rock -> Move.ROCK.ordinal
            R.id.paper -> Move.PAPER.ordinal
            R.id.scissors -> Move.SCISSOR.ordinal
            else -> -1
        }

        val response = RPSNative.PlayGame(choice);
        val winner = Result.values()[response];
        val cpuLastPlay = RPSNative.GetLastCPUPlay();

        val resultPlay = when(winner) {
            Result.DRAW -> "\nIt's a draw!"
            Result.USER -> "\nYou win!"
            Result.CPU -> "\nYou lose!"
        }

        val userChoice = Move.values()[choice]
        val cpuPlay = Move.values()[cpuLastPlay]

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