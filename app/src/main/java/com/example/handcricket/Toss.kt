package com.example.handcricket

import android.content.ComponentCallbacks2
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_toss.*

class Toss : AppCompatActivity() {
    private var ultimateChoice: String? = null
    private var computerChoice: String? = setToss()
    private lateinit var usersChoice: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toss)
        choice.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener{ _, checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                usersChoice = radio.text.toString()
                if(usersChoice == computerChoice){
                    val intent = Intent(this,Toss_2::class.java)
                    startActivity(intent)
                }
                else
                {
                    val intent = Intent(this,Innings_1::class.java)
                    startActivity(intent)
                }
            }
        )
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