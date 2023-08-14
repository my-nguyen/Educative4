package p12_modified_binary_search

fun main() {
    val arrays = arrayOf(intArrayOf(1,3,8,12,4,2), intArrayOf(3,8,3,1), intArrayOf(1,3,8,12), intArrayOf(10,9,8))
    for (array in arrays) {
        val peak = p128a(array)
        println("array: ${array.contentToString()}, peak: $peak")
    }
}

private fun p128(array: IntArray): Int {
    if (array[0] > array[1])
        return array[0]
    if (array[array.lastIndex-1] < array.last())
        return array.last()

    var i = 0
    var j = array.lastIndex
    while (i < j) {
        val k = (i + j) / 2
        if (array[k-1] < array[k] && array[k] > array[k+1])
            return array[k]
        if (array[i] < array[k])
            i = k
        else
            j = k - 1
    }
    return -1
}

// copied from sample project "educative"
fun p128a(array: IntArray): Int {
    var i = 0
    var j = array.lastIndex
    while (i < j) {
        val k = i + (j-i)/2
        if (array[k] < array[k+1]) {
            // we are in the first (ascending) part of the bitonic array. Therefore, the required number will be after k.
            // This means we will be doing: i = k + 1.
            i = k + 1
        } else {
            // we are in the second (descending) part of the bitonic array. Therefore, our required number could either
            // be pointed out by k or will be before k. This means we will be doing: j = k.
            j = k
        }
    }
    return array[j]
}
