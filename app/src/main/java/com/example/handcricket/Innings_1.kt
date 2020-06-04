package com.example.handcricket

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_innings_1.*

class Innings_1 : AppCompatActivity() {
    private var uRunCounter: Int = 0
    private var cRunCounter: Int = 0
    private var mBallCounter: Int = 0
    private var mOverCounter: Int = 0
    private var mWicketCounter: Int = 0
    private var userInput: Int = 0
    private var computerValue: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_innings_1)
        val gameType: String? = intent.getStringExtra("Value")
        if (gameType != null)
            game_play.text = gameType.toString()
        else
            game_play.text = "Bowling"
        computerValue = compValue()
        run_1_1.setOnClickListener {
            userInput = 1
        }
        run_1_2.setOnClickListener {
            userInput = 2
        }
        run_1_3.setOnClickListener {
            userInput = 3
        }
        run_1_4.setOnClickListener {
            userInput = 4
        }
        run_1_5.setOnClickListener {
            userInput = 5
        }
        run_1_6.setOnClickListener {
            userInput = 6
        }
        press_one.setOnClickListener {
            game(gameType)
        }
    }

    private fun compValue(): Int {
        return listOf<Int>(1, 2, 3, 4, 5, 6).random()
    }

    private fun game(gameType: String?) {
        computerValue = compValue()
        Comp_Value.text = computerValue.toString()
        mBallCounter = mBallCounter.inc()
        ball_no_one.text = mBallCounter.toString()
        if (mBallCounter == 1 || (((mBallCounter - 1) % 6 == 0) && mBallCounter > 6)) {
            mOverCounter = mOverCounter.inc()
            over_no_one.text = mOverCounter.toString()
        }
        if (gameType == "Batting") {
            if (userInput == computerValue) {
                mWicketCounter = mWicketCounter.inc()
                wicket_one.text = mWicketCounter.toString()
            } else {
                uRunCounter = uRunCounter.plus(userInput)
                score_one.text = uRunCounter.toString()
            }
            if (mWicketCounter == 3 || mBallCounter == 18) {
                startNextInnings(gameType)
            }
        } else if (gameType == "Bowling" || gameType == null) {
            if (userInput == computerValue) {
                mWicketCounter = mWicketCounter.inc()
                wicket_one.text = mWicketCounter.toString()
            } else {
                cRunCounter = cRunCounter.plus(computerValue)
                score_one.text = cRunCounter.toString()
            }
            if (mWicketCounter == 3 || mBallCounter == 18) {
                startNextInnings(gameType)
            }
        }
    }

    private fun startNextInnings(gameType: String?) {
        if (gameType == "Batting") {
            val intent = Intent(this, Innings_2::class.java)
            intent.putExtra("runs", uRunCounter.toString())
            intent.putExtra("GameType", gameType)
            Toast.makeText(this, "Score is: $uRunCounter", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        } else {
            val intent = Intent(this, Innings_2::class.java)
            intent.putExtra("runs", cRunCounter.toString())
            intent.putExtra("GameType", "Bowling")
            Toast.makeText(this, "Score is: $cRunCounter", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
    }
}
