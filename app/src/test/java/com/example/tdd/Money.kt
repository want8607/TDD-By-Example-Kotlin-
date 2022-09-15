package com.example.tdd

open class Money(protected open var amount: Int) {
    override fun equals(other: Any?): Boolean {
        val money: Money = other as Money
        return amount == money.amount
    }
}