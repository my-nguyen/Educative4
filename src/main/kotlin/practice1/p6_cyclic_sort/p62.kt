package practice1.p6_cyclic_sort

import swap

fun main() {
    val arrays = listOf(intArrayOf(3,1,5,4,2), intArrayOf(2,6,4,3,1,5), intArrayOf(1,5,6,4,3,2))
    for (array in arrays) {
        println("array: ${array.contentToString()} => ${sample.p6_cyclic_sort.p62(array).contentToString()}")
    }
}

fun p62(array: IntArray): IntArray {
    for (i in array.indices) {
        while (array[i]-1 != i)
            swap(array, i, array[i] - 1)
    }
    return array
}