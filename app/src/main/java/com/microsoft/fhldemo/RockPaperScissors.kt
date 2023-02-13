package com.microsoft.fhldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class RockPaperScissors : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rock_paper_scissors)

        findViewById<Button>(R.id.rock).setOnClickListener {v -> onSelectNextMove(v)}
        findViewById<Button>(R.id.paper).setOnClickListener {v -> onSelectNextMove(v)}
        findViewById<Button>(R.id.scissors).setOnClickListener {v -> onSelectNextMove(v)}
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
    }
}