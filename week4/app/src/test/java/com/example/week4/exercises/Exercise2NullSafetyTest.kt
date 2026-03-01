package com.example.week4.exercises

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class Exercise2NullSafetyTest {

    @Test
    fun getCustomerEmail_returnsFallbackForNullCases() {
        val orderWithoutCustomer = Order(null)
        val orderWithNullEmail = Order(Customer(null))

        assertEquals("no-email@unknown.com", getCustomerEmail(null))
        assertEquals("no-email@unknown.com", getCustomerEmail(orderWithoutCustomer))
        assertEquals("no-email@unknown.com", getCustomerEmail(orderWithNullEmail))
    }

    @Test
    fun getCustomerEmail_returnsEmailWhenPresent() {
        val order = Order(Customer("alice@example.com"))
        assertEquals("alice@example.com", getCustomerEmail(order))
    }

    @Test
    fun exercise2Results_containsElvisFallbackLine() {
        val lines = exercise2Results()
        assertTrue(lines.any { it.contains("?: 0") })
        assertTrue(lines.any { it.contains("getCustomerEmail(null) -> no-email@unknown.com") })
    }
}
