package p11_subsets

import java.util.*

fun main() {
    val arrays = arrayOf(intArrayOf(1,3), intArrayOf(1,5,3)/*, intArrayOf(1,3,3)*/)
    for (array in arrays) {
        val subsets = p112a(array)
        print("array: ${array.contentToString()}, subsets: ")
        for (subset in subsets) {
            print("$subset, ")
        }
        println()
    }
}

fun p112(array: IntArray): List<List<Int>> {
    val queue = LinkedList<List<Int>>()
    queue.add(emptyList())
    for (number in array) {
        val size = queue.size
        for (i in 1..size) {
            val current = queue.remove()
            queue.add(current)
            val next = current.toMutableList()
            next.add(number)
            queue.add(next)
        }
    }
    return queue
}

// copied from project "educative"
fun p112a(array: IntArray): List<List<Int>> {
    val subsets = mutableListOf<List<Int>>()
    subsets.add(listOf())
    for (number in array) {
        val size = subsets.size
        for (i in 0..<size) {
            val subset = subsets[i].toMutableList()
            subset.add(number)
            subsets.add(subset)
        }
    }
    return subsets
}