package practice1.p2_sliding_window

fun main() {
    val arrays = listOf(intArrayOf(2, 1, 5, 2, 3, 2), intArrayOf(2, 1, 5, 2, 8), intArrayOf(3, 4, 1, 1, 6))
    val targets = listOf(7, 7, 8)
    for (i in arrays.indices) {
        println(
            "numbers: ${arrays[i].contentToString()}, target: ${targets[i]}, min length: ${
                p23(
                    arrays[i],
                    targets[i]
                )
            }"
        )
    }
}

fun p23(numbers: IntArray, target: Int): Int {
    var j = 0
    var i = 0
    var sum = 0
    var len = Int.MAX_VALUE
    while (j < numbers.size) {
        sum += numbers[j]
        while (i <= j && sum >= target) {
            len = minOf(len, j - i + 1)
            sum -= numbers[i]
            i++
        }
        j++
    }
    return if (len == Int.MAX_VALUE) 0 else len
}