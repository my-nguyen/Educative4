package p13_bitwise_xor

fun main() {
    val arrays = arrayOf(intArrayOf(1, 4, 2, 1, 3, 5, 6, 2, 3, 5), intArrayOf(2, 1, 3, 2))
    for (array in arrays) {
        val singles = p132(array)
        println("array: ${array.contentToString()}, single: ${singles.contentToString()}")
    }
}

fun p132(array: IntArray): IntArray {
    val set = mutableSetOf<Int>()
    for (number in array) {
        if (set.contains(number))
            set.remove(number)
        else
            set.add(number)
    }
    return set.toIntArray()
}