package com.example.testing.mock.rx.presenter

import android.annotation.SuppressLint
import com.example.testing.mock.rx.OrderListContract
import com.example.testing.mock.rx.OrderListContract.Presenter
import com.example.testing.mock.rx.OrderRepository
import io.reactivex.Scheduler


class OrderListPresenter(
    private val orderRepository: OrderRepository,
    private val workScheduler: Scheduler,
    private val resultScheduler: Scheduler
) : BasePresenter<OrderListContract.View>(), Presenter {


    @SuppressLint("CheckResult")
    override fun refresh() {
        if (view == null) return
        view!!.showProgress()
        orderRepository.getOrders()
            .subscribeOn(workScheduler)
            .observeOn(resultScheduler)
            .subscribe({
                if (view == null)

                view!!.hideProgress()
                view!!.showOrders(it)
            },
            {
                    if (view == null)

                    view!!.hideProgress()
                    view!!.showError(it.message)
            })
    }
}