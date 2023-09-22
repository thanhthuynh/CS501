package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    private lateinit var displayEditText: EditText
    private var num1: Double? = null
    private var num2: Double? = null
    private var operation: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayEditText = findViewById(R.id.displayEditText)

        val button0: Button = findViewById(R.id.button0)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val button7: Button = findViewById(R.id.button7)
        val button8: Button = findViewById(R.id.button8)
        val button9: Button = findViewById(R.id.button9)
        val buttonPeriod: Button = findViewById(R.id.buttonPeriod)

        val buttonAdd: Button = findViewById(R.id.buttonAdd)
        val buttonSubtract: Button = findViewById(R.id.buttonSubtract)
        val buttonMultiply: Button = findViewById(R.id.buttonMultiply)
        val buttonDivide: Button = findViewById(R.id.buttonDivide)
        val buttonSqrt: Button = findViewById(R.id.buttonSqrt)

        button0.setOnClickListener { appendNumber("0") }
        button1.setOnClickListener { appendNumber("1") }
        button2.setOnClickListener { appendNumber("2") }
        button3.setOnClickListener { appendNumber("3") }
        button4.setOnClickListener { appendNumber("4") }
        button5.setOnClickListener { appendNumber("5") }
        button6.setOnClickListener { appendNumber("6") }
        button7.setOnClickListener { appendNumber("7") }
        button8.setOnClickListener { appendNumber("8") }
        button9.setOnClickListener { appendNumber("9") }
        buttonPeriod.setOnClickListener { appendNumber(".") }

        buttonAdd.setOnClickListener { performOperation("+") }
        buttonSubtract.setOnClickListener { performOperation("-") }
        buttonMultiply.setOnClickListener { performOperation("*") }
        buttonDivide.setOnClickListener { performOperation("/") }
        buttonSqrt.setOnClickListener { performSqrt() }

        val buttonEquals: Button = findViewById(R.id.buttonEquals)
        buttonEquals.setOnClickListener { calculate() }
    }

    private fun performSqrt() {
        num1 = displayEditText.text.toString().toDoubleOrNull()
        if (num1 == null || num1!! < 0) {
            displayEditText.setText("Invalid input")
            return
        }
        val result = sqrt(num1!!)
        displayEditText.setText(result.toString())
        num1 = null
    }

    private fun appendNumber(number: String) {
        displayEditText.append(number)
    }

    private fun performOperation(op: String) {
        num1 = displayEditText.text.toString().toDoubleOrNull()
        if (num1 == null) {
            displayEditText.setText("Invalid input")
            return
        }
        operation = op
        displayEditText.text.clear()
    }

    private fun calculate() {
        num2 = displayEditText.text.toString().toDoubleOrNull()
        if (num2 == null) {
            displayEditText.setText("Invalid input")
            return
        }

        val result = when (operation) {
            "+" -> num1!! + num2!!
            "-" -> num1!! - num2!!
            "*" -> num1!! * num2!!
            "/" -> {
                if (num2 == 0.0) {
                    "Cannot divide by zero"
                } else {
                    num1!! / num2!!
                }
            }
            else -> "Invalid operation"
        }

        displayEditText.setText(result.toString())
    }
}