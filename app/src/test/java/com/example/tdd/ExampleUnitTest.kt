package com.example.tdd

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class ExampleUnitTest {
    @Nested
    @DisplayName("달러")
    class DollarTest {
        @Test
        @DisplayName("달러 곱셈 테스트")
        fun testMultiplication() {
            val five: Dollar = Dollar(5)
            assertThat(Dollar(10), `is`(five.times(2)))
            assertThat(Dollar(15), `is`(five.times(3)))
        }

        @Test
        @DisplayName("달러 동등성 테스트")
        fun testEquality() {
            assertEquals(Dollar(5), Dollar(5))
            assertNotEquals(Dollar(5), Dollar(6))
        }
    }

    @Nested
    @DisplayName("프랑")
    class FrancTest{
        @Test
        @DisplayName("프랑 곱셈 테스트")
        fun testFrancMultiplication() {
            val five: Franc = Franc(5)
            assertThat(Franc(10), `is`(five.times(2)))
            assertThat(Franc(15), `is`(five.times(3)))
        }
    }
}