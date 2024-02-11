package p12_modified_binary_search

fun main() {
    val arrays = arrayOf(
        intArrayOf(4,6,10), intArrayOf(1,2,3,4,5,6,7), intArrayOf(10,6,4), intArrayOf(10,6,4)
    )
    val keys = arrayOf(10, 5, 10, 4)
    for (i in arrays.indices) {
        val index = p122(arrays[i], keys[i])
        println("array: ${arrays[i].contentToString()}, key: ${keys[i]}, index: $index")
    }
}

fun p122(array: IntArray, key: Int): Int {
    if (array.first() < array.last())
        return ascend(array, key)
    if (array.first() > array.last())
        return descend(array, key)
    return plain(array, key)
}

private fun ascend(array: IntArray, key: Int): Int {
    var i = 0
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

private fun descend(array: IntArray, key: Int): Int {
    var i = 0
    var j = array.lastIndex
    while (i <= j) {
        val k = (i + j) / 2
        if (array[k] == key)
            return k
        if (array[k] < key)
            j = k - 1
        else
            i = k + 1
    }
    return -1
}

private fun plain(array: IntArray, key: Int) = if (array.first() == key) 0 else -1