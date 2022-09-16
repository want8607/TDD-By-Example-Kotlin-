package com.example.tdd

open class Money(protected val amount: Int, protected val currency: String ) {

    companion object {
        fun dollar(amount: Int): Dollar {
            return Dollar(amount,"USD")
        }

        fun franc(amount: Int): Franc {
            return Franc(amount,"CHF")
        }
    }

    override fun equals(other: Any?): Boolean {
        val money: Money = other as Money
        return amount == money.amount && currency() == money.currency()
    }

    open fun times(multiplier: Int): Money {
        return Money(amount * multiplier,currency)
    }

    open fun currency(): String = currency
}