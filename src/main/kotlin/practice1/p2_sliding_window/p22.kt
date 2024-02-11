package practice1.p2_sliding_window

fun main() {
    val arrays = arrayOf(intArrayOf(2,1,5,1,3,2), intArrayOf(2,3,4,1,5))
    val windows = arrayOf(3, 2)
    for (i in arrays.indices) {
        println("numbers: ${arrays[i].contentToString()}, window: ${windows[i]}, solution: ${p22(arrays[i], windows[i])}")
    }
}

fun p22(numbers: IntArray, window: Int): Int {
    var sum = numbers.take(window).sum()
    var max = sum
    for (i in window..numbers.lastIndex) {
        sum += numbers[i] - numbers[i-window]
        max = maxOf(max, sum)
    }
    return max
}