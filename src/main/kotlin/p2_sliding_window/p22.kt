package p2_sliding_window

fun main() {
    val arrays = listOf(intArrayOf(2,1,5,1,3,2), intArrayOf(2,3,4,1,5))
    val sizes = listOf(3, 2)
    for (i in arrays.indices) {
        println("array: ${arrays[i].contentToString()}, k: ${sizes[i]} => ${p22(arrays[i], sizes[i])}")
    }
}

fun p22(array: IntArray, size: Int): Int {
    var sum = array.copyOfRange(0, size).sum()
    var max = sum
    for (i in size..array.lastIndex) {
        sum += array[i] - array[i-size]
        max = maxOf(max, sum)
    }
    return max
}