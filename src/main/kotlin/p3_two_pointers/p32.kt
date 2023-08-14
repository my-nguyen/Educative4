package p3_two_pointers

fun main() {
    val arrays = listOf(intArrayOf(1,2,3,4,6), intArrayOf(2,5,9,11))
    val targets = listOf(6, 11)
    for (i in arrays.indices) {
        println("array: ${arrays[i].contentToString()}, target: ${targets[i]} => ${p32(arrays[i], targets[i])}")
    }
}

fun p32(array: IntArray, target: Int): Pair<Int, Int> {
    var i = 0
    var j = array.lastIndex
    while (i < j) {
        val sum = array[i] + array[j]
        if (sum == target)
            return Pair(i, j)
        if (sum < target)
            i++
        else
            j--
    }
    return Pair(0, 0)
}