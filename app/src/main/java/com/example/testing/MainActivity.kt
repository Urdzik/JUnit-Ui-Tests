package com.example.testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testing.mock.rx.Order
import com.example.testing.mock.rx.OrderListContract

class MainActivity : AppCompatActivity(), OrderListContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun showOrders(orders: List<Order>) {
        TODO("Not yet implemented")
    }

    override fun showError(message: String?) {
        TODO("Not yet implemented")
    }

    override fun showProgress() {
        TODO("Not yet implemented")
    }

    override fun hideProgress() {
        TODO("Not yet implemented")
    }
}
