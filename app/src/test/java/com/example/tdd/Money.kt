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

    fun times(multiplier: Int): Expression {
        return Money(amount * multiplier, currency)
    }

    fun currency(): String = currency

    override fun plus(addend: Expression): Expression {
        return Sum(this, addend)
    }

    override fun reduce(bank: Bank, to: String): Money {
        val rate: Int = bank.rate(currency, to)
        return Money(amount / rate, to)
    }

    override fun toString(): String {
       return "$amount$currency"
    }
}