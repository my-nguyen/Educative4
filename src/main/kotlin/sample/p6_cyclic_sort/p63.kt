package sample.p6_cyclic_sort

import swap

fun main() {
    val arrays = listOf(intArrayOf(4,0,3,1), intArrayOf(8,3,5,2,4,6,0,1))
    for (array in arrays) {
        println("array: ${array.contentToString()} => ${p63(array)}")
    }
}

fun p63(array: IntArray): Int {
    for (i in array.indices) {
        while (array[i] != 0 && array[i]-1 != i)
            swap(array, i, array[i] - 1)
    }
    for (i in array.indices) {
        if (array[i] == 0)
            return i + 1
    }
    return 0
}