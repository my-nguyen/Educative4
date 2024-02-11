package sample.p5_merge_intervals

fun main() {
    val list = listOf(
        arrayOf(intArrayOf(1,4), intArrayOf(2,5), intArrayOf(7,9)),
        arrayOf(intArrayOf(6,7), intArrayOf(2,4), intArrayOf(8,12)),
        arrayOf(intArrayOf(4,5), intArrayOf(2,3), intArrayOf(3,6)),
    )
    for (intervals in list) {
        print("intervals: ")
        intervals.forEach { print("${it.contentToString()}, ") }
        println(" can attend all appointments? ${p55(intervals)}")
    }
}

fun p55(intervals: Array<IntArray>): Boolean {
    intervals.sortWith(compareBy({ it[0] }, { it[1] }))
    for (i in 0 until intervals.lastIndex) {
        if (intervals[i][1] > intervals[i+1][0])
            return false
    }
    return true
}