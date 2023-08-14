package p5_merge_intervals

fun main() {
    val intervals1 = listOf(
        arrayOf(intArrayOf(1,3), intArrayOf(5,6), intArrayOf(7,9)),
        arrayOf(intArrayOf(1,3), intArrayOf(5,7), intArrayOf(9,12)),
    )
    val intervals2 = listOf(
        arrayOf(intArrayOf(2,3), intArrayOf(5,7)),
        arrayOf(intArrayOf(5,10)),
    )
    for (i in intervals1.indices) {
        print("intervals1: ")
        intervals1[i].forEach { print("${it.contentToString()}, ") }
        println()
        print("intervals2: ")
        intervals2[i].forEach { print("${it.contentToString()}, ") }
        println()
        print("merged: ")
        p54(intervals1[i], intervals2[i]).forEach { print("${it.contentToString()}, ") }
        println()
    }
}

fun p54(intervals1: Array<IntArray>, intervals2: Array<IntArray>): List<IntArray> {
    intervals1.sortWith(compareBy({ it[0] }, { it[1] }))
    intervals2.sortWith(compareBy({ it[0] }, { it[1] }))
    val result = mutableListOf<IntArray>()
    for (i in intervals1.indices) {
        for (j in intervals2.indices) {
            if (intervals2[j][0] <= intervals1[i][1] && intervals2[j][1] >= intervals1[i][0]) {
                val x = maxOf(intervals1[i][0], intervals2[j][0])
                val y = minOf(intervals1[i][1], intervals2[j][1])
                result.add(intArrayOf(x, y))
            }
        }
    }
    return result
}