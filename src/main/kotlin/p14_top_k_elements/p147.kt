package p14_top_k_elements

import java.lang.StringBuilder
import java.util.PriorityQueue

fun main() {
    val strings = arrayOf("Programming", "abcbab")
    for (string in strings) {
        val sorted = p147(string)
        println("input: $string, output: $sorted")
    }
}

fun p147(string: String): String {
    val map = mutableMapOf<Char, Int>()
    for (c in string)
        map[c] = map.getOrDefault(c, 0) + 1

    val maxHeap = PriorityQueue<Char>() { a, b -> map[b]!! - map[a]!! }
    for (c in map.keys)
        maxHeap.add(c)

    val builder = StringBuilder()
    while (maxHeap.isNotEmpty()) {
        val c = maxHeap.poll()
        builder.append(c.toString().repeat(map[c]!!))
    }

    return builder.toString()
}