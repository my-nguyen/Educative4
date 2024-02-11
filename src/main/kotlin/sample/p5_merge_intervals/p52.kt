package sample.p5_merge_intervals

fun main() {
    val list = listOf(
        arrayOf(intArrayOf(1,4), intArrayOf(2,5), intArrayOf(7,9)),
        arrayOf(intArrayOf(6,7), intArrayOf(2,4), intArrayOf(5,9)),
        arrayOf(intArrayOf(1,4), intArrayOf(2,6), intArrayOf(3,5))
    )
    for (intervals in list) {
        print("intervals: ")
        intervals.forEach { print("${it.contentToString()}, ") }
        print("merged: ")
        p52(intervals).forEach { print("${it.contentToString()}, ") }
        println()
    }
}

fun p52(intervals: Array<IntArray>): List<IntArray> {
    val result = mutableListOf<IntArray>()
    intervals.sortWith(compareBy({ it[0] }, { it[1] }))
    var pair = intervals[0].copyOf()
    for (i in 1..intervals.lastIndex) {
        if (intervals[i][0] <= pair[1])
            pair[1] = maxOf(pair[1], intervals[i][1])
        else {
            result.add(pair)
            pair = intervals[i].copyOf()
        }
    }
    result.add(pair)
    return result
}