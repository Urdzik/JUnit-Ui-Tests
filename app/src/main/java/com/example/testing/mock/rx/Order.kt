package com.example.testing.mock.rx

import java.time.temporal.TemporalAmount

data class Order(
    private val id: Long,
    private val amount: Float,
    private val description: String
)