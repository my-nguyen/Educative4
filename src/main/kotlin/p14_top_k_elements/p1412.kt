package p14_top_k_elements

import java.util.*

fun main() {
    val strings = arrayOf("aappp", "Programming", "aapa")
    for (string in strings) {
        val rearranged = p1412(string)
        println("string: $string, rearranged: $rearranged")
    }
}

// copied from project "educative"
fun p1412(string: String): String {
    val charFrequency = mutableMapOf<Char, Int>()
    for (chr in string)
        charFrequency[chr] = charFrequency.getOrDefault(chr, 0) + 1

    // create a max heap of map entries so we can update entries value while popping entries from the heap
    val maxHeap = PriorityQueue<MutableMap.MutableEntry<Char, Int>> { (_, v1), (_, v2) -> v2 - v1 }

    // add all characters to the max heap
    maxHeap.addAll(charFrequency.entries)

    // use 2 entries, previous and current, to put alternate characters in result string
    var previous: MutableMap.MutableEntry<Char, Int>? = null
    val result = StringBuilder(string.length)
    while (maxHeap.isNotEmpty()) {
        val current = maxHeap.poll()
        // add the previous entry back in the heap if its frequency is greater than zero
        if (previous != null && previous.value > 0)
            maxHeap.offer(previous)

        // append the current character to the result string and decrement its count
        result.append(current.key)
        current.setValue(current.value - 1)
        previous = current
    }

    // if we were successful in appending all the characters to the result string, return it
    return if (result.length == string.length) result.toString() else ""
}