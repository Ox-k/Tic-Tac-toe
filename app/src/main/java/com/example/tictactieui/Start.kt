package com.example.tictactieui

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Start : AppCompatActivity() {
    var btn_start: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

//        removing the status bar
        supportActionBar?.hide()
        window.decorView.systemUiVisibility = SYSTEM_UI_FLAG_FULLSCREEN

//        start game UI activity



    }
    override fun onResume() {
        super.onResume()
        val mediaPlayer = MediaPlayer.create(this, R.raw.sweep)
        btn_start = findViewById<Button>(R.id.start_ui)
        btn_start!!.setOnClickListener(){
            mediaPlayer.start()
            val i = Intent(this, GameUI::class.java)
            startActivity(i)
            finish()
        }

    }
    companion object{
        var mediaPlayer: MediaPlayer? = null
    }
}