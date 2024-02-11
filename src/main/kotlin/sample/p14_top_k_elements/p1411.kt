package p14_top_k_elements

import java.util.PriorityQueue

fun main() {
    val arrays = arrayOf(
        intArrayOf(1,3,12,5,15,11), intArrayOf(3,5,8,7)
    )
    val starts = arrayOf(3, 1)
    val ends = arrayOf(6, 4)
    for (i in arrays.indices) {
        val sum = p1411(arrays[i], starts[i], ends[i])
        println("array: ${arrays[i].contentToString()}, start: ${starts[i]}, end: ${ends[i]}, sum: $sum")
    }
}

fun p1411(array: IntArray, start: Int, end: Int): Int {
    val minHeap = PriorityQueue<Int>()
    for (number in array)
        minHeap.add(number)

    for (i in 1..start)
        minHeap.poll()
    var sum = 0
    for (i in start+1 until end)
        sum += minHeap.poll()
    return sum
}