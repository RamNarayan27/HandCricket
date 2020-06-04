package com.example.handcricket

import android.content.ComponentCallbacks2
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_toss.*

class Toss : AppCompatActivity() {
    private var computerChoice: String? = setToss()
    private lateinit var usersChoice: String
    private var res: Boolean? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toss)
        choice.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { _, checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                usersChoice = radio.text.toString()
                if (usersChoice == computerChoice) {
                    val tv: TextView = findViewById(R.id.display_result)
                    tv.setText(R.string.win)
                    res = true
                } else {
                    val tv: TextView = findViewById(R.id.display_result)
                    tv.setText(R.string.lost)
                    res = false
                }
            }
        )
        toss.setOnClickListener {
            if (res == true) {
                val intent = Intent(this, BatOrBowl::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, Innings_1::class.java)
                intent.putExtra("Value", R.string.bowling)
                startActivity(intent)
            }
        }
    }
    private fun randomNumber(): Int
    {
        val list = listOf(0,1)
        return list.random()
    }
    private fun setToss(): String?
    {
        val randInt = randomNumber()
        var valueOfTheCoin: String? = null
        when(randInt)
        {
            0 -> {valueOfTheCoin = "Heads"}
            1 -> {valueOfTheCoin = "Tails"}
        }
        return valueOfTheCoin
    }
}