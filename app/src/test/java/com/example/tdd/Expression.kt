package com.example.tdd

interface Expression {
    fun reduce(bank: Bank, to: String): Money
}