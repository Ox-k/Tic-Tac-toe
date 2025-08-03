package com.example.tictactieui

import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_game_ui.*
import kotlinx.android.synthetic.main.activity_game_ui.textView
import kotlinx.android.synthetic.main.activity_settings.*

open class GameUI : AppCompatActivity(){
    var player = 1
    //handling config changes
    val model: ViewModelGameUI by viewModels()
    private lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_ui)

        //handling config changes
        //val model: ViewModelGameUI by viewModels()
        val settings: Button = findViewById<Button>(R.id.settings_btn)

        //getting clicks
        settings.setOnClickListener() {
            val i = Intent(this, Settings::class.java)
            startActivity(i)
            finish()
        }
        b1.text = model.first
        b1.setOnClickListener{
            click(b1)
            model.first = b1.text.toString()
        }
        b2.text = model.second
        b2.setOnClickListener{
            click(b2)
            model.second = b2.text.toString()
        }
        b3.text = model.third
        b3.setOnClickListener{
            click(b3)
            model.third = b3.text.toString()
        }
        b4.text = model.fourth
        b4.setOnClickListener{
            click(b4)
            model.fourth = b4.text.toString()
        }
        b5.text = model.fifth
        b5.setOnClickListener{
            click(b5)
            model.fifth = b5.text.toString()
        }
        b6.text = model.sixth
        b6.setOnClickListener{
            click(b6)
            model.sixth = b6.text.toString()
        }
        b7.text = model.seventh
        b7.setOnClickListener{
            click(b7)
            model.seventh = b7.text.toString()
        }
        b8.text = model.eigth
        b8.setOnClickListener{
            click(b8)
            model.eigth = b8.text.toString()
        }
        b9.text = model.ninth
        b9.setOnClickListener{
            click(b9)
            model.ninth = b9.text.toString()
        }
        model.resetGameUI()
        b10.setOnClickListener{
            resetGame()
        }
        textView.setText("START PLAYING")

    }

    //validating clicks
    private fun click(btn: AppCompatButton) {
        if (btn.text == "Click"){
            if (player == 1){
                2.also { player = it }
                btn.text = "X"
                btn.setTextColor(Color.GREEN)
                settings_btn.isVisible = true
                settings_btn.setTextColor(Color.WHITE)
                textView.setText("Player O's Turn")
                xClick()
            }else{
                1.also { player = it }
                btn.text = "O"
                settings_btn.isVisible = true
                textView.setText("Player X's Turn")
                oClick()
            }
        }
/*calling to check the winner*/
        checkWinner()
    }

    //checking for the winner
    private fun checkWinner() {
        if((b1.text == "X" && b2.text == "X" && b3.text == "X")
            ||(b4.text == "X" && b5.text == "X" && b6.text == "X")
            ||(b7.text == "X" && b8.text == "X" && b9.text == "X")
            ||(b1.text == "X" && b5.text == "X" && b9.text == "X")
            ||(b1.text == "X" && b4.text == "X" && b7.text == "X")
            ||(b2.text == "X" && b5.text == "X" && b8.text == "X")
            ||(b3.text == "X" && b6.text == "X" && b9.text == "X")
            ||(b3.text == "X" && b5.text == "X" && b7.text == "X")){
            Toast.makeText(this@GameUI, "X wins!", Toast.LENGTH_SHORT).show()
            win()
            textView.setText("Click RESTART GAME to start over :)")
            b10.isVisible = true
            settings_btn.isVisible = false
            disableButtons()
        }else if((b1.text == "O" && b2.text == "O" && b3.text == "O")
            ||(b4.text == "O" && b5.text == "O" && b6.text == "O")
            ||(b7.text == "O" && b8.text == "O" && b9.text == "O")
            ||(b1.text == "O" && b5.text == "O" && b9.text == "O")
            ||(b1.text == "O" && b4.text == "O" && b7.text == "O")
            ||(b2.text == "O" && b5.text == "O" && b8.text == "O")
            ||(b3.text == "O" && b6.text == "O" && b9.text == "O")
            ||(b3.text == "O" && b5.text == "O" && b7.text == "O")){
            Toast.makeText(this@GameUI, "O wins!", Toast.LENGTH_SHORT).show()
            lose()
            textView.setText("Click RESTART GAME to start over :)")
            b10.isVisible = true
            settings_btn.isVisible = false
            b10.setBackgroundResource(R.drawable.restart)
            disableButtons()
        }else{
            if (
                (b1.text != "Click")
                && (b2.text != "Click")
                && (b3.text != "Click")
                && (b4.text != "Click")
                && (b5.text != "Click")
                && (b6.text != "Click")
                && (b7.text != "Click")
                && (b8.text != "Click")
                && (b9.text != "Click")
            ){
                Toast.makeText(this@GameUI, "Its a Tie!", Toast.LENGTH_SHORT).show()
                tie()
                textView.setText("Click RESTART GAME to start over :)")
                b10.isVisible = true
                settings_btn.isVisible = false
                disableButtons()

            }
        }
    }

    //d-sabling a button after a win

    private fun disableButtons() {
        b1.isEnabled = false
        b2.isEnabled = false
        b3.isEnabled = false
        b4.isEnabled = false
        b5.isEnabled = false
        b6.isEnabled = false
        b7.isEnabled = false
        b8.isEnabled = false
        b9.isEnabled = false
        //resetGame()
    }

    //checking the winner

    private fun resetGame() {
        textView.setText("start Game")
        b1.text = "Click"
        model.first= b1.text as String
        b2.text = "Click"
        model.second= b2.text as String
        b3.text = "Click"
        model.third= b3.text as String
        b4.text = "Click"
        model.fourth= b4.text as String
        b5.text = "Click"
        model.fifth= b5.text as String
        b6.text = "Click"
        model.sixth= b6.text as String
        b7.text = "Click"
        model.seventh= b7.text as String
        b8.text = "Click"
        model.eigth= b8.text as String
        b9.text = "Click"
        model.ninth= b9.text as String
        b1.isEnabled = true
        b2.isEnabled = true
        b3.isEnabled = true
        b4.isEnabled = true
        b5.isEnabled = true
        b6.isEnabled = true
        b7.isEnabled = true
        b8.isEnabled = true
        b9.isEnabled = true
        b10.isVisible = false
        //reset colors
        b1.setTextColor(Color.WHITE)
        b2.setTextColor(Color.WHITE)
        b3.setTextColor(Color.WHITE)
        b4.setTextColor(Color.WHITE)
        b5.setTextColor(Color.WHITE)
        b6.setTextColor(Color.WHITE)
        b7.setTextColor(Color.WHITE)
        b8.setTextColor(Color.WHITE)
        b9.setTextColor(Color.WHITE)
        settings_btn.isVisible = true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    //Sound effects
    private fun win() {
        //super.onResume()
        val mediaPlayer = MediaPlayer.create(this, R.raw.win)
            mediaPlayer.start()
    }

    private fun lose() {
        //super.onResume()
        val mediaPlayer = MediaPlayer.create(this, R.raw.buzzer)
            mediaPlayer.start()
    }

    private fun tie() {
        //super.onResume()
        val mediaPlayer = MediaPlayer.create(this, R.raw.tie)
            mediaPlayer.start()
    }
    private fun xClick() {
        //super.onResume()
        val mediaPlayer = MediaPlayer.create(this, R.raw.xclick)
            mediaPlayer.start()
    }
    private fun oClick() {
        //super.onResume()
        val mediaPlayer = MediaPlayer.create(this, R.raw.oclick)
            mediaPlayer.start()
    }

    /*handling media player so that it does not crash the app*/
    companion object{
        var mediaPlayer: MediaPlayer? = null
    }
}
