package p14_top_k_elements

import java.util.PriorityQueue
import kotlin.math.abs

fun main() {
    val arrays = arrayOf(
        intArrayOf(5,6,7,8,9), intArrayOf(2,4,5,6,9), intArrayOf(2,4,5,6,9)
    )
    val Ks = arrayOf(3, 3, 3)
    val Xs = arrayOf(7, 6, 10)
    for (i in arrays.indices) {
        val closest = p149(arrays[i], Ks[i], Xs[i])
        println("array: ${arrays[i].contentToString()}, K: ${Ks[i]}, X: ${Xs[i]}, closest elements: $closest")
    }
}

fun p149(array: IntArray, K: Int, X: Int): List<Int> {
    val maxHeap = PriorityQueue<Int>() { a, b -> abs(b-X) - abs(a-X) }
    for (i in 0 until K)
        maxHeap.add(array[i])
    for (i in K..array.lastIndex) {
        if (abs(array[i] - X) < abs(maxHeap.peek() - X)) {
            maxHeap.poll()
            maxHeap.add(array[i])
        }
    }
    return maxHeap.toList()
}