package practice1.p5_merge_intervals

fun main() {
    val list = listOf(
        arrayOf(intArrayOf(1,4), intArrayOf(2,5), intArrayOf(7,9)),
        arrayOf(intArrayOf(6,7), intArrayOf(2,4), intArrayOf(8,12)),
        arrayOf(intArrayOf(4,5), intArrayOf(2,3), intArrayOf(3,6)),
    )
    for (intervals in list) {
        print("intervals: ")
        intervals.forEach { print("${it.contentToString()}, ") }
        println(" can attend all appointments? ${sample.p5_merge_intervals.p55(intervals)}")
    }
}

fun p55(intervals: Array<IntArray>): Boolean {
    intervals.sortWith(compareBy({ it[0] }, { it[1] }))
    for (i in 0..intervals.lastIndex-1) {
        val left = intervals[i]
        val right = intervals[i+1]
        if (left[0] <= right[0] && right[0] <= left[1] || left[0] <= right[1] && right[1] <= left[1])
            return false
    }
    return true
}