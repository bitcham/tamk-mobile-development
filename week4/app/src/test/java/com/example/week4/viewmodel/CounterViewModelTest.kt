package com.example.week4.viewmodel

import org.junit.Assert.assertEquals
import org.junit.Test

class CounterViewModelTest {

    @Test
    fun counter_startsAtZero() {
        val viewModel = CounterViewModel()
        assertEquals(0, viewModel.count.value)
    }

    @Test
    fun incrementAndDecrement_updateStateFlowValue() {
        val viewModel = CounterViewModel()

        viewModel.increment()
        viewModel.increment()
        viewModel.decrement()

        assertEquals(1, viewModel.count.value)
    }
}

