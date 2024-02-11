package sample.p2_sliding_window

fun main() {
    val arrays = listOf(intArrayOf(2,1,5,2,3,2), intArrayOf(2,1,5,2,8), intArrayOf(3,4,1,1,6))
    val targets = listOf(7, 7, 8)
    for (i in arrays.indices) {
        println("array: ${arrays[i].contentToString()}, target: ${targets[i]} => ${p23(arrays[i], targets[i])}")
    }
}

fun p23(array: IntArray, target: Int): Int {
    var i = 0
    var sum = array[0]
    var length = Int.MAX_VALUE
    for (j in 1..array.lastIndex) {
        sum += array[j]
        while (i <= j && sum >= target) {
            length = minOf(length, j - i + 1)
            sum -= array[i]
            i++
        }
    }
    return length
}