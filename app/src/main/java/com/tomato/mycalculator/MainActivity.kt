package com.tomato.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.tomato.mycalculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var lastNumeric = false
    var lastDot = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun onDigit(view: View) {
        binding.tvInput.append((view as Button).text)
        lastNumeric = true

        if (binding.tvInput.text.contains(other = "1")) {
            binding.tvInput.text = "Haha"
        }
    }

    fun onClear(view: View) {
        binding.tvInput.text = ""
        lastNumeric = false
        lastDot = false

    }

    fun onDecimalPoint(view: View) {
        if (lastNumeric && !lastDot) {
            binding.tvInput.append(".")
            lastNumeric = false
            lastDot = true

        }
    }

    fun onOperator(view:View) {
        if (lastNumeric && !isOperatorAdded(binding.tvInput.text.toString())) {
            binding.tvInput.append((view as Button).text)
            lastNumeric = false
            lastDot = false
        }
    }

    private fun isOperatorAdded(value: String): Boolean {

        return if (value.startsWith("-")) {
            false
        } else {
            (value.contains("/")
                    || value.contains("*")
                    || value.contains("-")
                    || value.contains("+"))
        }
    }


}