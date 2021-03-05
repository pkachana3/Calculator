package com.example.calculator

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    var ans = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @SuppressLint("SetTextI18n")
    fun calculate(view: View) {
        
        var input = editText.text.toString()
        input = input.replace(" ", "")
        input = input.toLowerCase()
        var inp = input.replace("ans", "")
        var valid = true
        for(i in inp) {
            if(!(i.isDigit() || i == '+'|| i == '-'|| i == '*'|| i == '/'|| i == '^')) {
                valid = false
            }
        }
        if (valid) {
            ans = calc(input)
            result.text = "= $ans"
        } else {
            result.text = "Enter sumn valid"
        }
    }

    fun getNum1(input:String, index:Int):Double {
        var num = input.substring(0, index)
        if ("+" in num || "-" in num|| "*" in num|| "/" in num|| "^" in num) {
            num = calc(num).toString()
        }

        val num1 = if (num.toLowerCase() == "ans") {
            ans
        } else {
            num.toDouble()
        }
        return num1
    }

    fun getNum2(input:String, index:Int):Double {
        var num = input.substring(index + 1, input.length)
        if ("+" in num || "-" in num|| "*" in num|| "/" in num|| "^" in num) {
            num = calc(num).toString()
        }
        val num2 = if (num.toLowerCase() == "ans") {
            ans
        } else {
            num.toDouble()
        }
        return num2
    }

    fun calc(input:String):Double {
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
            ans = getNum1(input, index).pow(getNum2(input, index))
        } else {
            ans = input.toDouble()
        }
        return ans
    }
}