package com.example.testing.mock.rx


import io.reactivex.Observable
import kotlin.collections.ArrayList

interface OrderRepository {
    fun getOrders(): Observable<List<Order>>
}