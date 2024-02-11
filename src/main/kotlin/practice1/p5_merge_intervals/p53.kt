package practice1.p5_merge_intervals

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
        p53(intervals[i], interval[i]).forEach { print("${it.contentToString()}, ") }
        println()
    }
}

fun p53(intervals: Array<IntArray>, interval: IntArray): List<IntArray> {
    intervals.sortWith(compareBy({ it[0] }, { it[1] }))
    val result = mutableListOf<IntArray>()
    if (interval[1] < intervals.first()[0]) {
        result.add(interval.copyOf())
        result.addAll(intervals)
    } else if (interval[0] > intervals.last()[1]) {
        result.addAll(intervals)
        result.add(interval.copyOf())
    } else {
        val tmp = IntArray(2)
        for (i in intervals.indices) {
            if (intervals[i][1] < interval[0] || intervals[i][0] > interval[1])
                result.add(intervals[i].copyOf())
            else {
                tmp[0] = minOf(interval[0], intervals[i][0])
                tmp[1] = maxOf(interval[1], intervals[i][1])
            }
        }
        result.add(tmp)
    }
    return result
}