package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var name1 : EditText
    private lateinit var name2 : EditText
    private lateinit var start : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name1 = findViewById(R.id.name1)
        name2 = findViewById(R.id.name2)
        start = findViewById(R.id.start)

        start.setOnClickListener {

            val player1 = name1.text.toString()
            val player2 = name2.text.toString()
            val intent = Intent(this, MainActivity2::class.java)

            intent.putExtra("player1", player1)
            intent.putExtra("player2", player2)

            if (player1.isEmpty() || player2.isEmpty()){
                Toast.makeText(this, "please enter your names", Toast.LENGTH_SHORT).show()
            }else {
                startActivity(intent)
            }

        }

    }
}
