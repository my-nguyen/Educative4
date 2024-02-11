package p10_two_heaps

fun main() {
    val arrays = arrayOf(intArrayOf(1,2,-1,3,5), intArrayOf(1,2,-1,3,5))
    val windows = arrayOf(2, 3)
    for (i in arrays.indices) {
        val median = p103(arrays[i], windows[i])
        println("array: ${arrays[i].contentToString()}, window: ${windows[i]}, median: ${median.contentToString()}")
    }
}

fun p103(array: IntArray, window: Int): DoubleArray {
    val median = StreamMedian()
    for (i in 0..<window) {
        median.insert(array[i])
    }
    val result = DoubleArray(array.size - window + 1)
    result[0] = median.findMedian()

    for (i in window..array.lastIndex) {
        median.remove(array[i - window])
        median.insert(array[i])
        result[i - window + 1] = median.findMedian()
    }
    return result
}