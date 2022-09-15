package com.example.tdd

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    @DisplayName("달러 곱셈 테스트")
    fun testMultiplication() {
        val five : Dollar = Dollar(5)
        var product : Dollar = five.times(2)
        assertThat(10,`is`(product.amount))
        product = five.times(3)
        assertThat(15,`is`(product.amount))
    }

    @Test
    @DisplayName("달러 동등성 테스트")
    fun testEquality(){
        assertEquals(Dollar(5),Dollar(5))
        assertNotEquals(Dollar(5),Dollar(6))
    }
}