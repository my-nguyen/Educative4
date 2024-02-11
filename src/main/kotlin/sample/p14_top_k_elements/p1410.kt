package p14_top_k_elements

import java.util.PriorityQueue

fun main() {
    val arrays = arrayOf(
        intArrayOf(7,3,5,8,5,3,3), intArrayOf(3,5,12,11,12), intArrayOf(1,2,3,3,3,3,4,4,5,5,5)
    )
    val Ks = arrayOf(2, 3, 2)
    for (i in arrays.indices) {
        val distinct = p1410(arrays[i], Ks[i])
        println("array: ${arrays[i].contentToString()}, k: ${Ks[i]}, distinct: $distinct")
    }
}

fun p1410(array: IntArray, k: Int): Int {
    val map = mutableMapOf<Int, Int>()
    for (number in array)
        map[number] = map.getOrDefault(number, 0) + 1

    var distinct = map.values.count { it == 1 }
    val minHeap = PriorityQueue<Int>() { a, b -> map[a]!! - map[b]!! }
    for ((k, v) in map) {
        if (v == 1)
            continue
        minHeap.add(k)
    }

    for (i in 1..k) {
        if (minHeap.isEmpty())
            break

        val key = minHeap.poll()
        map[key] = map[key]!! - 1
        if (map[key] == 1)
            distinct++
        else
            minHeap.add(key)
    }
    return distinct
}