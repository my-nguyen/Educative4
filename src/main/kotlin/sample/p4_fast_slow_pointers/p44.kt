package sample.p4_fast_slow_pointers

fun main() {
    val numbers = listOf(23, 12)
    for (number in numbers) {
        println("number: $number => ${p44(number)}")
    }
}

fun p44(number: Int): Boolean {
    var slow = number
    var fast = next(next(number))
    while (next(fast) != 1 && next(next(fast)) != 1) {
        slow = next(slow)
        fast = next(next(fast))
        if (slow == fast)
            return false
    }
    return true
}

private fun next(number: Int): Int {
    var current = number
    var result = 0
    while (current != 0) {
        val mod = current % 10
        result += mod * mod
        current /= 10
    }
    return result
}