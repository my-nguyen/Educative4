package p14_top_k_elements

import java.util.PriorityQueue

fun main() {
    val arrays = arrayOf(intArrayOf(1,5,12,2,11,5), intArrayOf(1,5,12,2,11,5), intArrayOf(5,12,11,-1,12))
    val bottoms = arrayOf(3,4,3)
    for (i in arrays.indices) {
        val smallest = p143(arrays[i], bottoms[i])
        println("array: ${arrays[i].contentToString()}, bottom: ${bottoms[i]}, smallest: $smallest")
    }
}

fun p143(array: IntArray, bottom: Int): Int {
    val maxHeap = PriorityQueue<Int>(Comparator.reverseOrder())
    for (i in 0 until bottom)
        maxHeap.add(array[i])
    for (i in bottom..array.lastIndex) {
        if (array[i] < maxHeap.peek()) {
            maxHeap.poll()
            maxHeap.add(array[i])
        }
    }
    return maxHeap.peek()
}