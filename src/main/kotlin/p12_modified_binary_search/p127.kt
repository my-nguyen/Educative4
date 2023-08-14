package p12_modified_binary_search

fun main() {
    val arrays = arrayOf(
        intArrayOf(4, 6, 10), intArrayOf(4, 6, 10), intArrayOf(1, 3, 8, 10, 15), intArrayOf(4, 6, 10)
    )
    val keys = arrayOf(7, 4, 12, 17)
    for (i in arrays.indices) {
        val element = p127(arrays[i], keys[i])
        println("array: ${arrays[i].contentToString()}, key: ${keys[i]}, element: $element")
    }
}

fun p127(array: IntArray, key: Int): Int {
    if (key < array.first())
        return array.first()
    if (array.last() < key)
        return array.last()

    var i = 0
    var j = array.lastIndex
    while (i <= j) {
        val k = (i + j) / 2
        if (array[k] == key)
            return array[k]

        if (array[k] < key)
            i = k + 1
        else
            j = k - 1
    }
    return if (key - array[j] <= array[i] - key) array[j] else array[i]
}