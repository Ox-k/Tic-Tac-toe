package com.example.tictactieui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_settings.*

class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)


        val settings: Button = findViewById<Button>(R.id.btn_back)


        switch1.setOnClickListener{
            if (switch1.isChecked){
                Toast.makeText(this@Settings, "Reset Completed! press BACK to continue", Toast.LENGTH_SHORT).show()
                settings.isEnabled = true
                settings.setOnClickListener() {
                    val i = Intent(this, GameUI::class.java)
                    startActivity(i)
                    finish()
                }
            }
    }
    }

}