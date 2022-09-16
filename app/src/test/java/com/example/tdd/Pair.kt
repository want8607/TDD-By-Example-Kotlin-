package com.example.tdd

private class Pair(private val from: String,private val to: String) {
    override fun hashCode(): Int {
        return 0
    }

    override fun equals(other: Any?): Boolean {
        val pair: Pair = other as Pair
        return from == pair.from && to == pair.to
    }
}
