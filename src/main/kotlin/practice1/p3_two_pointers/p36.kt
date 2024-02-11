package practice1.p3_two_pointers

import java.lang.Math.abs

fun main() {
    val arrays = listOf(intArrayOf(-2,0,1,2), intArrayOf(-3,-1,1,2), intArrayOf(1,0,1,1))
    val targets = listOf(2, 1, 100)
    for (i in arrays.indices) {
        println("array: ${arrays[i].contentToString()}, target: ${targets[i]} => ${p36(arrays[i], targets[i])}")
    }
}

fun p36(array: IntArray, target: Int): Int {
    var minDiff = Int.MAX_VALUE
    var minSum = Int.MAX_VALUE
    for (i in 0..array.lastIndex-2) {
        var j = i + 1
        var k = array.lastIndex
        while (j < k) {
            val sum = array[i] + array[j] + array[k]
            val diff = kotlin.math.abs(sum - target)
            if (diff == 0)
                return sum
            if (diff < minDiff) {
                minDiff = diff
                minSum = sum
            } else if (diff == minDiff)
                minSum = minOf(minSum, sum)
            if (sum < target)
                j++
            else
                k--
        }
    }
    return minSum
}