package com.example.week4.exercises

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class Exercise1FunctionsTest {

    @Test
    fun greetingAndMathFunctions_workAsExpected() {
        assertEquals("Hello, Student! Welcome to Kotlin.", greet("Student"))
        assertEquals(8, add(5, 3))
        assertEquals(15, multiply(5, 3))
    }

    @Test
    fun defaultAndNamedParameters_workAsExpected() {
        assertEquals(15.0, calculateArea(5.0, 3.0), 0.0)
        assertEquals(5.0, calculateArea(5.0), 0.0)

        val profile = createProfile(age = 25, name = "Alice", city = "Helsinki")
        assertEquals("Name: Alice, Age: 25, City: Helsinki", profile)
    }

    @Test
    fun exercise1Results_containsKeyExamples() {
        val lines = exercise1Results()
        assertEquals(7, lines.size)
        assertTrue(lines.any { it.contains("default height") })
        assertTrue(lines.any { it.contains("default city") })
    }
}

