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

    /**
     * reduced => Expression에 환율을 적용한 것.
     *
     * Expression이란, ($2 + 3CHF) * 5 와 같이 축약되지 않은 표현이다.
     */
    @Test
    @DisplayName("덧셈 테스트")
    fun testSimpleAddition() {
        val five : Money = Money.dollar(5)
        val sum: Expression = five.plus(five)
        val bank: Bank = Bank()
        val reduced: Money = bank.reduce(sum, "USD")
        assertThat(Money.dollar(10), `is`(reduced))
    }

}