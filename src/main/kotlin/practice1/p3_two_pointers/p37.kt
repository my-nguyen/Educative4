package practice1.p3_two_pointers

fun main() {
    val arrays = listOf(intArrayOf(-1,0,2,3), intArrayOf(-1,4,2,1,3))
    val targets = listOf(3, 5)
    for (i in arrays.indices) {
        println("array: ${arrays[i].contentToString()}, target: ${targets[i]} => ${p37(arrays[i], targets[i])}")
    }
}

fun p37(array: IntArray, target: Int): Int {
    var count = 0
    array.sort()
    for (i in 0..array.lastIndex-2) {
        var j = i + 1
        var k = array.lastIndex
        while (j < k) {
            val sum = array[i] + array[j] + array[k]
            if (sum < target) {
                count += k - j
                j++
            } else
                k--
        }
    }
    return count
}