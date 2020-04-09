package com.example.testing.calc

import android.util.Log

class Calculator {

    fun add(a: Int, b: Int): Int = a + b

    fun subtract(a: Int, b: Int): Int = a - b

    fun multiply(a: Int, b: Int): Int = a * b

    fun divide(a: Int, b: Int): Int =
        if (b != 0) {
            a / b
        } else {
            Log.e("TAG", "Divide by 0" )
            0
        }

}