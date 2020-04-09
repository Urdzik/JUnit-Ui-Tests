package com.example.testing.utils

import org.junit.Test

import org.junit.Assert.*

class ConvertUtilsTest {


    @Test
    fun stringToInteger() {
        assertEquals(2, ConvertUtils().stringToInteger("2"));
        assertEquals(-2, ConvertUtils().stringToInteger("-2"));
        assertEquals(0, ConvertUtils().stringToInteger(""));
        assertEquals(0, ConvertUtils().stringToInteger("a"));
    }
}