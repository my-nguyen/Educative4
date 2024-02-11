package practice1.p5_merge_intervals

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
        val left = intervals1[i]
        for (j in intervals2.indices) {
            val right = intervals2[j]
            if (left[0] <= right[0] && right[0] <= left[1] || left[0] <= right[1] && right[1] <= left[1]) {
                val tmp = IntArray(2)
                tmp[0] = maxOf(left[0], right[0])
                tmp[1] = minOf(left[1], right[1])
                result.add(tmp)
            }
        }
    }
    return result
}