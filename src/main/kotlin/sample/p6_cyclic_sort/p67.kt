package sample.p6_cyclic_sort

import swap

fun main() {
    val arrays = listOf(intArrayOf(3,1,2,5,2), intArrayOf(3,1,2,3,6,4))
    for (array in arrays) {
        println("array: ${array.contentToString()} => ${p67(array)}")
    }
}

fun p67(array: IntArray): Pair<Int, Int> {
    for (i in array.indices) {
        while (array[i]-1 != i && array[array[i]-1] != array[i])
            swap(array, i, array[i] - 1)
    }
    println("sorted ${array.contentToString()}")
    var k = 0
    for (i in array.indices) {
        if (array[i]-1 != i)
            // array[i] is a duplicate and i+1 is the missing number
            return Pair(array[i], i+1)
    }
    return Pair(0, 0)
}