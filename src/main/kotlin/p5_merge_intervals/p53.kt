package p5_merge_intervals

fun main() {
    val intervals = listOf(
        arrayOf(intArrayOf(1,3), intArrayOf(5,7), intArrayOf(8,12)),
        arrayOf(intArrayOf(1,3), intArrayOf(5,7), intArrayOf(8,12)),
        arrayOf(intArrayOf(2,3), intArrayOf(5,7))
    )
    val interval = listOf(intArrayOf(4,6), intArrayOf(4,10), intArrayOf(1,4))
    for (i in intervals.indices) {
        print("intervals: ")
        intervals[i].forEach { print("${it.contentToString()}, ") }
        print("interval: ${interval[i].contentToString()} => ")
        print("merged: ")
        p53a(intervals[i], interval[i]).forEach { print("${it.contentToString()}, ") }
        println()
    }
}

fun p53(intervals: Array<IntArray>, interval: IntArray): List<IntArray> {
    intervals.sortWith(compareBy({ it[0] }, { it[1] }))
    val results = mutableListOf<IntArray>()
    var added = false
    for (i in intervals.indices) {
        if (interval[0] > intervals[i][1])
            results.add(intervals[i].copyOf())
        else if (interval[1] < intervals[i][0]) {
            if (!added) {
                results.add(interval)
                added = true
            }
            results.add(intervals[i].copyOf())
        } else {
            interval[0] = minOf(interval[0], intervals[i][0])
            interval[1] = maxOf(interval[1], intervals[i][1])
        }
    }
    return results
}

fun p53a(intervals: Array<IntArray>, interval: IntArray): List<IntArray> {
    intervals.sortWith(compareBy({ it[0] }, { it[1] }))
    val results = mutableListOf<IntArray>()
    for (i in intervals.indices) {
        if (interval[0] > intervals[i][1] || interval[1] < intervals[i][0]) {
            results.add(intervals[i].copyOf())
        } else {
            interval[0] = minOf(interval[0], intervals[i][0])
            interval[1] = maxOf(interval[1], intervals[i][1])
        }
    }
    results.add(interval)
    results.sortWith(compareBy({ it[0] }, { it[1] }))
    return results
}