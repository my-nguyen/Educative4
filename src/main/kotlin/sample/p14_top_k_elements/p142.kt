package p14_top_k_elements

import java.util.PriorityQueue

fun main() {
    val arrays = arrayOf(intArrayOf(3, 1, 5, 12, 2, 11), intArrayOf(5, 12, 11, -1, 12))
    val tops = arrayOf(3, 3)
    for (i in arrays.indices) {
        val numbers = p142(arrays[i], tops[i])
        println("array: ${arrays[i].contentToString()}, k: ${tops[i]}, numbers: $numbers")
    }
}

fun p142(array: IntArray, top: Int): List<Int> {
    val minHeap = PriorityQueue<Int>()
    for (i in 0 until top)
        minHeap.add(array[i])
    for (i in top..array.lastIndex) {
        if (array[i] > minHeap.peek()) {
            minHeap.poll()
            minHeap.add(array[i])
        }
    }
    return minHeap.toList()
}