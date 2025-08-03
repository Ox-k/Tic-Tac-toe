package com.example.tictactieui

import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
/*
* Name: NOEL KODO
* Student n0: 002232042
* ASSIGNMENT: #1
* CS330 FALL
* Prof: R. Butler
* */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//start another activity
        Handler().postDelayed({
            val intent = Intent(this@MainActivity,Start::class.java)
            startActivity(intent)
            finish()
        },2000)
    }
}