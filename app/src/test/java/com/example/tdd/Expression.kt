package com.example.tdd

interface Expression {
    fun reduce(to: String): Money
}