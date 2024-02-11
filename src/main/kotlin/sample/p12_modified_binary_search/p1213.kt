package p12_modified_binary_search

fun main() {
    val arrays = arrayOf(
        intArrayOf(10,15,1,3,8), intArrayOf(4,5,7,9,10,-1,2), intArrayOf(1,3,8,10),
        intArrayOf(1,2,3,4,5,6,7,8,9,10,11,12,13), intArrayOf(3,4,5,6,7,8,9,10,11,12,13,1,2),
        intArrayOf(12,13,1,2,3,4,5,6,7,8,9,10,11), intArrayOf(8,9,10,11,12,13,1,2,3,4,5,6,7),
    )
    for (array in arrays) {
        val rotations = p1213a(array)
        println("array: ${array.contentToString()}, rotations: $rotations")
    }
}

fun p1213(array: IntArray): Int {
    var i = 0
    var j = array.lastIndex
    while (i < j) {
        val k = (i + j) / 2
        if (array[k] > array[k+1])
            return k + 1

        if (array[i] < array[k])
            i = k
        else
            j = k
    }
    return -1
}

// copied from project "educative
fun p1213a(array: IntArray): Int {
    var i = 0
    var j = array.lastIndex
    while (i < j) {
        val k = i + (j - i) / 2
        if (k < j && array[k] > array[k + 1])
            return k + 1
        if (k > i && array[k - 1] > array[k])
            return k

        if (array[i] < array[k]) // left side is sorted, so the pivot is on right side
            i = k + 1
        else // right side is sorted, so the pivot is on the left side
            j = k - 1
    }

    return 0
}