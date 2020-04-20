package com.example.testing

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testing.mock.rx.Order
import com.example.testing.mock.rx.OrderListContract
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OrderListContract.View {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RxView.clicks(button).subscribe {
            if (edit.text.isNullOrEmpty()) {
                text.text = "Парень, это поле пустое. Ты идеот! А я просто не могу нажать точку"
            }else{
                text.text = edit.text
            }

        }

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
