package p14_top_k_elements

import java.util.PriorityQueue

fun main() {
    val arrays = arrayOf(
        intArrayOf(1,3,11,5), intArrayOf(3,4,5,6), intArrayOf(1,3,11,5,2)
    )
    for (lengths in arrays) {
        val cost = p145(lengths)
        println("lengths: ${lengths.contentToString()}, minimum cost: $cost")
    }
}

fun p145(lengths: IntArray): Int {
    val minHeap = PriorityQueue<Int>()
    for (length in lengths)
        minHeap.add(length)
    var result = 0
    while (minHeap.size >= 2) {
        val sum = minHeap.poll() + minHeap.poll()
        minHeap.add(sum)
        result += sum
    }
    return result
}