package com.example.lab_week_01

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameDisplay = findViewById<TextView>(R.id.name_display)
        val dataSubmit = findViewById<Button>(R.id.data_submit)

        dataSubmit.setOnClickListener {
            val nameInput = findViewById<TextInputEditText>(R.id.name_input)?.text.toString().trim()
            val numberInput = findViewById<TextInputEditText>(R.id.number_input)?.text.toString().trim()

            if (nameInput.isNotEmpty() && numberInput.isNotEmpty()) {
                if(numberInput.length < 11)
                    Toast.makeText(this, getString(R.string.number_error), Toast.LENGTH_LONG).apply {
                        setGravity(Gravity.CENTER, 0, 0)
                        show()
                    }

                nameDisplay?.text = getString(R.string.name_greet).plus(" ").plus(nameInput)
            } else {
                if (nameInput.isEmpty() && numberInput.isEmpty())
                    Toast.makeText(this, getString(R.string.data_empty), Toast.LENGTH_LONG).apply {
                        setGravity(Gravity.CENTER, 0, 0)
                        show()
                    }
                else if (nameInput.isEmpty())
                    Toast.makeText(this, getString(R.string.name_empty), Toast.LENGTH_LONG).apply {
                        setGravity(Gravity.CENTER, 0, 0)
                        show()
                    }
                else if (numberInput.isEmpty())
                    Toast.makeText(this, getString(R.string.number_empty), Toast.LENGTH_LONG).apply {
                        setGravity(Gravity.CENTER, 0, 0)
                        show()
                    }
                else
                    Toast.makeText(this, "An error occurred!", Toast.LENGTH_LONG).apply {
                        setGravity(Gravity.CENTER, 0, 0)
                        show()
                    }
            }
        }
    }
}