package p15_kway_merge

import java.util.PriorityQueue

fun main() {
    val matrix = arrayOf(
        intArrayOf(2,6,8), intArrayOf(3,7,10), intArrayOf(5,8,11)
    )
    val k = 5
    val smallest = p154(matrix, k)
    println("matrix:")
    for (row in matrix) {
        println("${row.contentToString()}")
    }
    println("k: $k, smallest: $smallest")
}

data class Record(val i: Int, val j: Int)

fun p154(matrix: Array<IntArray>, k: Int): Int {
    val minHeap = PriorityQueue<Record> { a, b -> matrix[a.i][a.j] - matrix[b.i][b.j] }
    for (i in matrix.indices)
        minHeap.add(Record(i, 0))

    var i = 0
    while (minHeap.isNotEmpty()) {
        val record = minHeap.poll()
        i++
        if (i == k)
            return matrix[record.i][record.j]

        if (record.j < matrix[record.i].lastIndex)
            minHeap.add(Record(record.i, record.j+1))
    }
    return 0
}