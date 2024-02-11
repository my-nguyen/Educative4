package p12_modified_binary_search

fun main() {
    val arrays = arrayOf(intArrayOf(1,3,8,4,3), intArrayOf(3,8,3,1), intArrayOf(1,3,8,12), intArrayOf(10,9,8))
    val keys = arrayOf(4, 8, 12, 10)
    for (i in arrays.indices) {
        val index = p129(arrays[i], keys[i])
        println("array: ${arrays[i].contentToString()}, key: ${keys[i]}, index: $index")
    }
}

fun p129(array: IntArray, key: Int): Int {
    val peak = findPeak(array)
    if (array[peak] == key)
        return peak

    val value = ascend(array, key, 0, peak)
    if (value != -1)
        return value

    return descend(array, key, peak, array.lastIndex)
}

private fun findPeak(array: IntArray): Int {
    var i = 0
    var j = array.lastIndex
    while (i < j) {
        val k = (i + j) / 2
        if (array[k] < array[k+1])
            i = k + 1
        else
            j = k
    }
    return j
}

private fun ascend(array: IntArray, key: Int, low: Int, high: Int): Int {
    var i = low
    var j = high
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

private fun descend(array: IntArray, key: Int, low: Int, high: Int): Int {
    var i = low
    var j = high
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