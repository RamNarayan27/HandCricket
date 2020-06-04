package com.example.handcricket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_innings_1.*
import kotlinx.android.synthetic.main.activity_innings_2.*

class Innings_2 : AppCompatActivity() {
    private var uRunCounter: Int = 0
    private var cRunCounter: Int = 0
    private var mBallCounter: Int = 0
    private var mOverCounter: Int = 0
    private var mWicketCounter: Int = 0
    private var userInput: Int = 0
    private var computerValue: Int = 0
    private var prevInningsScore: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_innings_2)
        val gameType: String? = intent.getStringExtra("GameType")
        val runsScored: String? = intent.getStringExtra("runs")
        prevInningsScore = runsScored.toString().toInt()
        computerValue = compValue()
        run_2_1.setOnClickListener {
            userInput = 1
        }
        run_2_2.setOnClickListener {
            userInput = 2
        }
        run_2_3.setOnClickListener {
            userInput = 3
        }
        run_2_4.setOnClickListener {
            userInput = 4
        }
        run_2_5.setOnClickListener {
            userInput = 5
        }
        run_2_6.setOnClickListener {
            userInput = 6
        }
        press_two.setOnClickListener {
            game(gameType)
        }
    }

    private fun compValue(): Int {
        return listOf<Int>(1, 2, 3, 4, 5, 6).random()
    }

    private fun game(gameType: String?) {
        computerValue = compValue()
        Comp_Value_two.text = computerValue.toString()
        mBallCounter = mBallCounter.inc()
        ball_no_two.text = mBallCounter.toString()
        if (mBallCounter == 1 || (((mBallCounter - 1) % 6 == 0) && mBallCounter > 6)) {
            mOverCounter = mOverCounter.inc()
            over_no_two.text = mOverCounter.toString()
        }
        if (gameType == "Batting") //Now, we have to Bowl. That means here we need to keep track of the computer's score. Use cRunCounter here
        {
            if (userInput == computerValue) {
                mWicketCounter = mWicketCounter.inc()
                wicket_two.text = mWicketCounter.toString()
            } else {
                cRunCounter = cRunCounter.plus(computerValue)
                score_two.text = cRunCounter.toString()
            }
            if (mWicketCounter == 3 || mBallCounter == 18) {
                startCongratulations(prevInningsScore, cRunCounter, gameType)
            }
        } else if (gameType == "Bowling") //Now, we have to Bat. That means here we need to keep track of the user's score. Use uRunCounter here
        {
            if (userInput == computerValue) {
                mWicketCounter = mWicketCounter.inc()
                wicket_two.text = mWicketCounter.toString()
            } else {
                uRunCounter = uRunCounter.plus(userInput)
                score_two.text = uRunCounter.toString()
            }
            if (mWicketCounter == 3 || mBallCounter == 18) {
                startCongratulations(prevInningsScore, uRunCounter, gameType)
            }
        }
    }

    private fun startCongratulations(
        prevInningsScore: Int,
        curInningsScore: Int,
        gameType: String?
    ) {
        if (gameType == "Batting") {
            if (prevInningsScore > curInningsScore) {
                //user has won
                val intent = Intent(this, Congratulations::class.java)
                intent.putExtra("Result", "User has won!")
                startActivity(intent)
            } else {
                //computer has won
                val intent = Intent(this, Congratulations::class.java)
                intent.putExtra("Result", "Computer has won!")
                startActivity(intent)
            }
        } else if (gameType == "Bowling") {
            if (prevInningsScore > curInningsScore) {
                //computer has won
                val intent = Intent(this, Congratulations::class.java)
                intent.putExtra("Result", "Computer has won!")
                startActivity(intent)
            } else {
                //user has won
                val intent = Intent(this, Congratulations::class.java)
                intent.putExtra("Result", "User has won!")
                startActivity(intent)
            }
        }
    }
}
