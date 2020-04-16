package com.example.testing.mock.rx.presenter

import com.example.testing.mock.rx.Order
import com.example.testing.mock.rx.OrderListContract
import com.example.testing.mock.rx.OrderRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.util.*


@RunWith(MockitoJUnitRunner::class)
class OrderListPresenterTest {

    lateinit var presenter: OrderListPresenter

    @Mock
    lateinit var orderRepository: OrderRepository
    @Mock
    lateinit var mockView: OrderListContract.View

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = OrderListPresenter(orderRepository, Schedulers.trampoline(), Schedulers.trampoline())
        presenter.attachView(mockView)
    }

    @Test
    fun refresh() {
        val fakeOrders :List<Order> = getFakeOrderList()
        `when`(orderRepository.getOrders()).thenReturn(Observable.just(fakeOrders))
        presenter.refresh()

        verify(mockView).showProgress()
        verify(mockView).hideProgress()
        verify(mockView).showOrders(fakeOrders);
        verify(mockView, never()).showError(anyString())
    }

    @Test
    fun refreshFailed(){
        val error = "Network error"
        `when`(orderRepository.getOrders()).thenReturn(Observable.error(Exception(error)))

        presenter.refresh()

        verify(mockView).showProgress()
        verify(mockView).hideProgress()
        verify(mockView).showError(error)
        verify(mockView, never()).showOrders(ArgumentMatchers.anyList())

    }

    @After
    fun tearDown() {
    }

    private fun getFakeOrderList(): List<Order> {
        val orders: MutableList<Order> = LinkedList()
        orders.add(Order(1, 100.2f, "Order 1"))
        orders.add(Order(2, 200.7f, "Order 2"))
        return orders
    }
}