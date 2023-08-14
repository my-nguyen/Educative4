package p13_bitwise_xor

fun main() {
    val arrays = arrayOf(intArrayOf(1, 4, 2, 1, 3, 2, 3), intArrayOf(7, 9, 7))
    for (array in arrays) {
        val number = p131a(array)
        println("array: ${array.contentToString()}, single number: $number")
    }
}

fun p131(array: IntArray): Int {
    val set = mutableSetOf<Int>()
    for (number in array) {
        if (set.contains(number))
            set.remove(number)
        else
            set.add(number)
    }
    return set.first()
}

fun p131a(array: IntArray): Int {
    var number = array[0]
    for (i in 1..array.lastIndex)
        number = number xor array[i]
    return number
}