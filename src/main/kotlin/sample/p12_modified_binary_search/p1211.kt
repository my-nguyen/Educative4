package p12_modified_binary_search

fun main() {
    val arrays = arrayOf(
        intArrayOf(10, 15, 1, 3, 8),
        intArrayOf(4, 5, 7, 9, 10, -1, 2),
        intArrayOf(4, 5, 6, 7, 0, 1, 2),
        intArrayOf(4, 5, 6, 7, 0, 1, 2),
        intArrayOf(1)
    )
    val keys = arrayOf(15, 10, 0, 3, 0)
    for (i in arrays.indices) {
        val index = p1211(arrays[i], keys[i])
        println("array: ${arrays[i].contentToString()}, key: ${keys[i]}, index: $index")
    }
}

// copied from project "educative"
fun p1211(array: IntArray, key: Int): Int {
    var i = 0
    var j = array.lastIndex
    while (i <= j) {
        val k = i + (j - i) / 2
        if (array[k] == key)
            return k

        if (array[i] <= array[k]) { // left side (between i and k) is sorted
            if (array[i] <= key && key < array[k]) // key is between i and k
                j = k - 1
            else // key is on the right side (rotated)
                i = k + 1
        } else { // right side (between k and j) is sorted
            if (array[k] < key && key <= array[j]) // key is between k and j
                i = k + 1
            else // key is on the left side (rotated)
                j = k - 1
        }
    }

    return -1
}