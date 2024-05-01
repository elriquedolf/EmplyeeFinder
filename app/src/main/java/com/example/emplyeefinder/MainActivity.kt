package com.example.emplyeefinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    // declare variables
    private lateinit var searchButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var ageEditText: EditText
    private lateinit var descriptionTextView: TextView
    private lateinit var titleTextView: TextView

    // array to store age and employees names
    private val employeeNames = arrayOf(
        Pair(23, "Monique"),
        Pair(21, "Elrique"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initialize
        searchButton = findViewById(R.id.searchButton)
        resultTextView = findViewById(R.id.resultTextView)
        ageEditText = findViewById(R.id.ageEditText)
        descriptionTextView = findViewById(R.id.descriptionTextView)
        titleTextView = findViewById(R.id.titleTextView)

        searchButton.setOnClickListener {
            val age = ageEditText.text.toString().toIntOrNull()
            if (age != null && age in 20..50) {
                val employeeName = findeEployeeName(age)
                val message = if (employeeName != null) "The employee's name is $employeeName."
                else "No employee found with the entered age."
                resultTextView.text = message
            } else {
                resultTextView.text = "Invalid Input. Please enter a valid age between 20 and 50."
            }
        }
    }

    // function to find employee name based on age (I did not want to make a new empty views activity for this because the last app did not run)
    private fun findeEployeeName(age:Int): String? {
        for (pair in employeeNames) {
            if (pair.first == age) {
                return pair.second
            }
        }
        return null
    }
}