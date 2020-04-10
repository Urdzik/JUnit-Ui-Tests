package com.example.testing.mock.rx.presenter

import androidx.annotation.NonNull
import com.example.testing.mock.rx.Order
import com.example.testing.mock.rx.OrderListContract
import com.example.testing.mock.rx.OrderListContract.Presenter
import com.example.testing.mock.rx.OrderRepository
import io.reactivex.Scheduler
import io.reactivex.observers.DisposableObserver


class OrderListPresenter(
    private val orderRepository: OrderRepository,
    private val workScheduler: Scheduler,
    private val resultScheduler: Scheduler
) :
    BasePresenter<OrderListContract.View>(), Presenter {
    override fun refresh() {
        if (view == null) return
        view!!.showProgress()
        orderRepository.getOrders()
            .subscribeOn(workScheduler)
            .observeOn(resultScheduler)
            .subscribe(object : DisposableObserver<List<Order>>() {
                override fun onNext(@NonNull orders: List<Order>) {
                    if (view == null) return
                    view!!.hideProgress()
                    view!!.showOrders(orders)
                }

                override fun onError(@NonNull e: Throwable) {
                    if (view == null) return
                    view!!.hideProgress()
                    view!!.showError(e.message)
                }

                override fun onComplete() {}
            })
    }

}