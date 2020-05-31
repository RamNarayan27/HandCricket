package com.example.handcricket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_bat_or_bowl.*

class BatOrBowl : AppCompatActivity() {
    private lateinit var batOrBowl: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bat_or_bowl)
        bat_or_bowl.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { _, checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                batOrBowl = radio.text.toString()
            }
        )
        str.setOnClickListener {
            val intent = Intent(this, Innings_1::class.java)
            intent.putExtra("Value", batOrBowl)
            startActivity(intent)
        }
    }
}