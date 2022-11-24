package com.example.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.tictactoe.R

class MainActivity2 : AppCompatActivity(), View.OnClickListener {
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var reset: Button
    private lateinit var score1: TextView
    private lateinit var score2: TextView
    private lateinit var player1: TextView
    private lateinit var player2: TextView

    private var activePlayer = 1
    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()
    private var scoreOne = 0
    private var scoreTwo = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        init()

        player1.text = intent.extras?.getString("player1", "name")
        player2.text = intent.extras?.getString("player2", "name2")

    }

    private fun init() {
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        reset = findViewById(R.id.reset)
        score1 = findViewById(R.id.score1)
        score2 = findViewById(R.id.score2)
        player1 = findViewById(R.id.player1)
        player2 = findViewById(R.id.player2)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        reset.setOnClickListener {
            button1.isEnabled = true
            button2.isEnabled = true
            button3.isEnabled = true
            button4.isEnabled = true
            button5.isEnabled = true
            button6.isEnabled = true
            button7.isEnabled = true
            button8.isEnabled = true
            button9.isEnabled = true
            reset.isEnabled = true
            button1.text = ""
            button2.text = ""
            button3.text = ""
            button4.text = ""
            button5.text = ""
            button6.text = ""
            button7.text = ""
            button8.text = ""
            button9.text = ""
            activePlayer = 1

            firstPlayer.clear()
            secondPlayer.clear()

        }

    }

    override fun onClick(clickedView: View?) {
        if (clickedView is Button) {
            var buttonNumber = 0
            when (clickedView.id) {
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9

            }

            if (buttonNumber !=0){
                playGame(clickedView,buttonNumber)
            }

        }

    }

    private fun playGame(clickedView: Button, buttonNumber: Int) {
        if (activePlayer == 1){
            clickedView.text = "X"
            clickedView.setTextColor(Color.CYAN)
            activePlayer = 2
            firstPlayer.add(buttonNumber)
        } else if (activePlayer == 2) {
            clickedView.text = "O"
            clickedView.setTextColor(Color.MAGENTA)
            activePlayer = 1
            secondPlayer.add(buttonNumber)
        }
        clickedView.isEnabled = false
        check()

    }
    private fun check(){
        var winner = 0

        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)){
            winner = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)){
            winner = 2
        }

        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)){
            winner = 1
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)){
            winner = 2
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)){
            winner = 1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)){
            winner = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)){
            winner = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)){
            winner = 2
        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)){
            winner = 1
        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)){
            winner = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)){
            winner = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)){
            winner = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)){
            winner = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)){
            winner = 2
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(5) && firstPlayer.contains(3)){
            winner = 1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(5) && secondPlayer.contains(3)){
            winner = 2
        }
        if (winner == 1){
            Toast.makeText(this,"გილოცავ, ${player1.text} ",Toast.LENGTH_SHORT).show()
            scoreOne += 1
            score1.text = scoreOne.toString()
        }
        if (winner == 2){
            Toast.makeText(this,"ყოჩაღ, ${player2.text} ",Toast.LENGTH_SHORT).show()
            scoreTwo += 1
            score2.text = scoreTwo.toString()
        }
        if (firstPlayer.size + secondPlayer.size == 9 && winner == 0){
            Toast.makeText(this,"ფრე",Toast.LENGTH_SHORT).show()

        }
        if(winner !=0 ){
            button1.isEnabled = false
            button2.isEnabled = false
            button3.isEnabled = false
            button4.isEnabled = false
            button5.isEnabled = false
            button6.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false
        }
    }

}
