package practice1.p4_fast_slow_pointers

fun main() {
    val numbers = listOf(23, 12)
    for (number in numbers) {
        println("number: $number => ${p44(number)}")
    }
}

fun p44(number: Int): Boolean {
    var slow = next(number)
    var fast = next(slow)
    while (slow != fast) {
        if (fast == 1)
            return true
        slow = next(slow)
        fast = next(next(fast))
    }
    return false
}

fun next(number: Int): Int {
    var current = number
    var sum = 0
    while (current > 0) {
        val mod = current % 10
        sum += mod * mod
        current /= 10
    }
    return sum
}