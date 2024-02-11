package sample.p6_cyclic_sort

import swap

fun main() {
    val arrays = listOf(intArrayOf(-3,1,5,4,2), intArrayOf(3,-2,0,1,2), intArrayOf(3,2,5,1))
    for (array in arrays) {
        println("array: ${array.contentToString()} => ${p69(array)}")
    }
}

fun p69(array: IntArray): Int {
    for (i in array.indices) {
        while (array[i] > 0 && array[i] < array.size && array[i]-1 != i)
            swap(array, i, array[i] - 1)
    }
    for (i in array.indices) {
        if (array[i] <= 0 || array[i] >= array.size)
            return i + 1
    }
    return 0
}