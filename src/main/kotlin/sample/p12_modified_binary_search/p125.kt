package p12_modified_binary_search

fun main() {
    val arrays = arrayOf(
        intArrayOf(4,6,6,6,9), intArrayOf(1,3,8,10,15), intArrayOf(1,3,8,10,15)
    )
    val keys = arrayOf(6, 10, 12)
    for (i in arrays.indices) {
        val range = p125(arrays[i], keys[i])
        println("array: ${arrays[i].contentToString()}, key: ${keys[i]}, range: $range")
    }
}

fun p125(array: IntArray, key: Int): Pair<Int, Int> {
    var i = 0
    var j = array.lastIndex
    while (i < j) {
        val k = (i + j) / 2
        if (array[k] == key)
            return Pair(left(array, key, k), right(array, key, k))

        if (array[k] < key)
            i = k + 1
        else
            j = k - 1
    }
    return Pair(-1, -1)
}

private fun left(array: IntArray, key: Int, end: Int): Int {
    var i = 0
    var j = end
    while (i <= j) {
        val k = (i + j) / 2
        if (array[k] == key)
            return k

        if (array[k] < key)
            i = k + 1
        else
            j = k - 1
    }
    return -1
}

private fun right(array: IntArray, key: Int, start: Int): Int {
    var i = start
    var j = array.lastIndex
    while (i <= j) {
        val k = (i + j) / 2
        if (array[k] == key)
            return k

        if (array[k] < key)
            i = k + 1
        else
            j = k - 1
    }
    return -1
}