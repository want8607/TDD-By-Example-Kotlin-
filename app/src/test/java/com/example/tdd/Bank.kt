package com.example.tdd

class Bank {

    private var rates = HashMap<Pair<String, String>, Int>()

    fun reduce(source: Expression, to: String): Money {
        return source.reduce(this, to)
    }

    fun rate(from: String, to: String): Int {
        if (from==to) return 1
        return rates[Pair(from,to)] as Int
    }

    fun addRate(from: String, to: String, rate: Int) {
        rates[Pair(from, to)] = rate
    }
}