package com.example.week4.exercises

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class Exercise3ClassesTest {

    @Test
    fun extensionFunctions_workAsExpected() {
        val person = Person("Alice", 25, "alice@email.com")
        assertTrue(person.isAdult())
        assertEquals("Alice (25) - alice@email.com", person.profileSummary())
    }

    @Test
    fun dataClass_supportsStructuralEqualityAndCopy() {
        val data1 = PersonData("Bob", 30, "bob@email.com")
        val data2 = PersonData("Bob", 30, "bob@email.com")
        val data3 = data1.copy(age = 31)

        assertTrue(data1 == data2)
        assertEquals(31, data3.age)
        assertEquals("Bob", data3.name)
    }

    @Test
    fun normalClass_keepsReferenceEqualityByDefault() {
        val p1 = Person("Carol", 28, "carol@email.com")
        val p2 = Person("Carol", 28, "carol@email.com")
        assertFalse(p1 == p2)
    }
}

