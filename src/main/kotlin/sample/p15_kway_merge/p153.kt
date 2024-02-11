package p15_kway_merge

import java.util.PriorityQueue

fun main() {
    val arrays = arrayOf(
        arrayOf(arrayOf(2,6,8), arrayOf(3,6,7), arrayOf(1,3,4)),
        arrayOf(arrayOf(5,8,9), arrayOf(1,7))
    )
    val Ks = arrayOf(5, 3)
    for (i in arrays.indices) {
        val lists = mutableListOf<Array<Int>>()
        for (array in arrays[i]) {
            lists.add(array)
        }
        val smallest = p153(lists, Ks[i])
        println("smallest: $smallest")
    }
}

data class Entry(val i: Int, val j: Int)

fun p153(lists: List<Array<Int>>, k: Int): Int {
    val minHeap = PriorityQueue<Entry>() { a, b -> lists[a.i][a.j] - lists[b.i][b.j] }
    for (i in lists.indices)
        minHeap.add(Entry(i, 0))

    var i = 0
    // arrayOf(arrayOf(2,6,8), arrayOf(3,6,7), arrayOf(1,3,4)),
    while (minHeap.isNotEmpty()) {
        val entry = minHeap.poll()
        i++
        if (i == k)
            return lists[entry.i][entry.j]

        if (entry.j < lists[entry.i].lastIndex)
            minHeap.add(Entry(entry.i, entry.j+1))
    }
    return 0
}