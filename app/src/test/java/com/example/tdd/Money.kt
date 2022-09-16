package com.example.tdd

open class Money(val amount: Int, val currency: String) : Expression {

    companion object {
        fun dollar(amount: Int): Money {
            return Money(amount, "USD")
        }

        fun franc(amount: Int): Money {
            return Money(amount, "CHF")
        }
    }

    override fun equals(other: Any?): Boolean {
        val money: Money = other as Money
        return amount == money.amount && currency() == money.currency()
    }

    fun times(multiplier: Int): Money {
        return Money(amount * multiplier, currency)
    }

    fun currency(): String = currency

    fun plus(addend: Money): Expression {
        return Sum(this, addend)
    }

    override fun reduce(to: String): Money{
        return this
    }
}