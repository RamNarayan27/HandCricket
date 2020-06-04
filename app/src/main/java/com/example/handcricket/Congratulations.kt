package com.example.handcricket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_congratulations.*

class Congratulations : AppCompatActivity() {

    @Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_congratulations)
        val results = intent.getStringExtra("Result")
        val over11 = intent.getStringExtra("over11")
        val over12 = intent.getStringExtra("over12")
        val over13 = intent.getStringExtra("over13")
        val over21 = intent.getStringExtra("over21")
        val over22 = intent.getStringExtra("over22")
        val over23 = intent.getStringExtra("over23")
        val gameType = intent.getStringExtra("GameType")
        val wicket1 = intent.getStringExtra("wicket1")
        val wicket2 = intent.getStringExtra("wicket2")
        val inningsOneScore = intent.getStringExtra("Innings1_Score")
        val inningsTwoScore = intent.getStringExtra("Innings2_Score")
        result.text = results.toString()
        if (gameType == "Batting") {
            P_score.text = inningsOneScore.toString()
            P_wicket.text = wicket1.toString()
            C_score.text = inningsTwoScore.toString()
            C_wicket.text = wicket2.toString()
            P_over_1.text = over11.toString()
            P_over_2.text = over12.toString()
            P_over_3.text = over13.toString()
            C_over_1.text = over21.toString()
            C_over_2.text = over22.toString()
            C_over_3.text = over23.toString()
        } else if (gameType == "Bowling") {
            P_score.text = inningsTwoScore.toString()
            P_wicket.text = wicket2.toString()
            C_score.text = inningsOneScore.toString()
            C_wicket.text = wicket1.toString()
            P_over_1.text = over11.toString()
            P_over_2.text = over12.toString()
            P_over_3.text = over13.toString()
            C_over_1.text = over21.toString()
            C_over_2.text = over22.toString()
            C_over_3.text = over23.toString()
        }
        exit.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
