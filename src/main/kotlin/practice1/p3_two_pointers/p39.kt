package practice1.p3_two_pointers

import swap

fun main() {
    val arrays = listOf(intArrayOf(1,0,2,1,0), intArrayOf(2,2,0,1,2,0))
    for (array in arrays) {
        println("array: ${array.contentToString()} => ${p39(array).contentToString()}")
    }
}

fun p39(array: IntArray): IntArray {
    var i = 0
    var j = 0
    var k = array.lastIndex
    while (i <= k) {
        when (array[i]) {
            0 -> {
                swap(array, i, j)
                i++
                j++
            }
            1 -> i++
            2 -> {
                swap(array, i, k)
                // i++
                k--
            }
        }
    }
    return array
}