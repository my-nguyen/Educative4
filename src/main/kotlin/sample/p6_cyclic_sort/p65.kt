package sample.p6_cyclic_sort

import swap

fun main() {
    val arrays = listOf(intArrayOf(1,4,4,3,2), intArrayOf(2,1,3,3,5,4), intArrayOf(2,4,1,4,4))
    for (array in arrays) {
        println("array: ${array.contentToString()} => ${p65(array)}")
    }
}

fun p65(array: IntArray): Int {
    for (i in array.indices) {
        while (array[i]-1 != i && array[array[i]-1] != array[i])
            swap(array, i, array[i] - 1)
    }
    for (i in array.indices) {
        if (array[i]-1 != i)
            return array[i]
    }
    return 0
}