package p14_top_k_elements

import java.util.PriorityQueue

fun main() {
    val arrays = arrayOf(intArrayOf(1,3,5,12,11,12,11), intArrayOf(5,12,11,3,11), intArrayOf(1,2,3,4,5,2,3,4,3,5,3))
    val tops = arrayOf(2, 2, 2)
    for (i in arrays.indices) {
        val numbers = p146(arrays[i], tops[i])
        println("array: ${arrays[i].contentToString()}, top: ${tops[i]}, frequent numbers: $numbers")
    }
}

fun p146(array: IntArray, top: Int): List<Int> {
    val map = mutableMapOf<Int, Int>()
    for (number in array)
        map[number] = map.getOrDefault(number, 0) + 1

    val minHeap = PriorityQueue<Int>() { a, b -> map[a]!! - map[b]!! }
    for (i in 0 until top)
        minHeap.add(array[i])
    for (key in map.keys) {
        if (key > minHeap.peek()) {
            minHeap.poll()
            minHeap.add(key)
        }
    }
    return minHeap.toList()
}