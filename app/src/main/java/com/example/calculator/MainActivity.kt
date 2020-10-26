package com.example.calculator

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var ans = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @SuppressLint("SetTextI18n")
    fun calculate(view: View) {
        
        val input = editText.text.toString()

        if ("+" in input) {
            val index = input.indexOf("+")
            ans = getNum1(input, index) + getNum2(input, index)
        } else if ("-" in input) {
            val index = input.indexOf("-")
            ans = getNum1(input, index) - getNum2(input, index)
        } else if ("*" in input) {
            val index = input.indexOf("*")
            ans = getNum1(input, index) * getNum2(input, index)
        } else if ("/" in input) {
            val index = input.indexOf("/")
            ans = getNum1(input, index) / getNum2(input, index)
        } else if ("^" in input) {
            val index = input.indexOf("^")
            ans = Math.pow(getNum1(input, index), getNum2(input, index))
        } else {
            result.text = "Invalid input"
            return
        }
        result.text = "= $ans"
    }

    fun getNum1(input:String, index:Int):Double {
        val num = input.substring(0, index)
        val num1 = if (num.toLowerCase() == "ans") {
            ans
        } else {
            num.toDouble()
        }
        return num1
    }

    fun getNum2(input:String, index:Int):Double {
        val num = input.substring(index + 1, input.length)
        val num2 = if (num.toLowerCase() == "ans") {
            ans
        } else {
            num.toDouble()
        }
        return num2
    }
}