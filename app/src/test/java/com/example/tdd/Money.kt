package com.example.tdd

abstract class Money(protected open var amount: Int) {

    companion object {
        fun dollar(amount: Int): Dollar {
            return Dollar(amount)
        }

        fun franc(amount: Int): Franc {
            return Franc(amount)
        }
    }

    override fun equals(other: Any?): Boolean {
        val money: Money = other as Money
        return amount == money.amount && javaClass.equals(money.javaClass)
    }

    abstract fun times(multiplier: Int): Money
}