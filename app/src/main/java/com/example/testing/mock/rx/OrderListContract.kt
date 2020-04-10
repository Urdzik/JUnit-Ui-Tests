package com.example.testing.mock.rx

interface OrderListContract {
    interface View {
        fun showOrders(orders: List<Order>)
        fun showError(message: String?)
        fun showProgress()
        fun hideProgress()
    }

    interface Presenter {
        fun refresh()
    }
}