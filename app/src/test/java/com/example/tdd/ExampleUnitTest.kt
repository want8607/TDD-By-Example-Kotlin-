package com.example.tdd

import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class ExampleUnitTest {
    @Nested
    @DisplayName("달러")
    inner class DollarTest {
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
            assertThat(Dollar(5), `is`(Dollar(5)))
            assertThat(Dollar(5), not(Dollar(6)))
        }
    }

    @Nested
    @DisplayName("프랑")
    inner class FrancTest {
        @Test
        @DisplayName("프랑 곱셈 테스트")
        fun testFrancMultiplication() {
            val five: Franc = Franc(5)
            assertThat(Franc(10), `is`(five.times(2)))
            assertThat(Franc(15), `is`(five.times(3)))
        }

        @Test
        @DisplayName("프랑 동등성 테스트")
        fun testFrancEquality() {
            assertThat(Franc(5), `is`(Franc(5)))
            assertThat(Franc(5), not(Franc(6)))
        }
    }

    @Test
    @DisplayName("화폐 구분 테스트")
    fun testMoneyEquality(){
        assertThat(Franc(5), not(Dollar(5)))
    }
}