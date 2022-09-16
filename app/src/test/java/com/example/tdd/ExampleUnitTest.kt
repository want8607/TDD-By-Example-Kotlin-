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
            val five: Money = Money.dollar(5)
            assertThat(Money.dollar(10), `is`(five.times(2)))
            assertThat(Money.dollar(15), `is`(five.times(3)))
        }

        @Test
        @DisplayName("달러 동등성 테스트")
        fun testEquality() {
            assertThat(Money.dollar(5), `is`(Money.dollar(5)))
            assertThat(Money.dollar(5), not(Money.dollar(6)))
        }
    }

    @Nested
    @DisplayName("프랑")
    inner class FrancTest {
        @Test
        @DisplayName("프랑 곱셈 테스트")
        fun testFrancMultiplication() {
            val five: Money = Money.franc(5)
            assertThat(Money.franc(10), `is`(five.times(2)))
            assertThat(Money.franc(15), `is`(five.times(3)))
        }

        @Test
        @DisplayName("프랑 동등성 테스트")
        fun testFrancEquality() {
            assertThat(Money.franc(5), `is`(Money.franc(5)))
            assertThat(Money.franc(5), not(Money.franc(6)))
        }
    }

    @Test
    @DisplayName("화폐 구분 테스트")
    fun testMoneyEquality() {
        assertThat(Money.franc(5), not(Money.dollar(5)))
    }

    @Test
    @DisplayName("통화 개념 테스트")
    fun testCurrency() {
        assertThat("USD", `is`(Money.dollar(1).currency()))
        assertThat("CHF", `is`(Money.franc(1).currency()))
    }

//    @Test
//    @DisplayName("화폐와 Money 동등성 비교 테스트")
//    fun testDifferentClassEquality() {
//        assertThat(Money(10,"CHF"),`is`(Franc(10,"CHF")))
//        assertThat(Money(10,"USD"),`is`(Dollar(10,"USD")))
//    }
}