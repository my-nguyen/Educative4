package p12_modified_binary_search

fun main() {
    val arrays = arrayOf(
        intArrayOf(4,6,10), intArrayOf(1,3,8,10,15), intArrayOf(4,6,10), intArrayOf(4,6,10)
    )
    val keys = arrayOf(6, 12, 17, -1)
    for (i in arrays.indices) {
        val index = p123(arrays[i], keys[i])
        println("array: ${arrays[i].contentToString()}, key: ${keys[i]}, index: $index")
    }
}

fun p123(array: IntArray, key: Int): Int {
    if (key < array.first() || array.last() < key)
        return -1

    var i = 0
    var j = array.lastIndex
    while (i < j) {
        val k = (i + j) / 2
        if (array[k] == key)
            return k
        if (array[k] < key)
            i = k + 1
        else
            j = k - 1
    }
    return j
}