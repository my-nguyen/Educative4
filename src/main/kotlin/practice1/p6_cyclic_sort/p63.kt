package practice1.p6_cyclic_sort

import swap

fun main() {
    val arrays = listOf(intArrayOf(4,0,3,1), intArrayOf(8,3,5,2,4,6,0,1))
    for (array in arrays) {
        println("array: ${array.contentToString()} => ${sample.p6_cyclic_sort.p63(array)}")
    }
}

fun p63(array: IntArray): Int {
    for (i in array.indices) {
        if (array[i] == array.size)
            continue
        while (array[i] != i)
            swap(array, array[i], i)
    }
    for (i in array.indices) {
        if (array[i] != i)
            return i
    }
    return 0
}