package com.example.handcricket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instructions.setOnClickListener {
            val intent = Intent(this,Instructions::class.java)
            startActivity(intent)
        }
        play.setOnClickListener{
            val intent = Intent(this,Toss::class.java)
            startActivity(intent)
        }
    }
}
