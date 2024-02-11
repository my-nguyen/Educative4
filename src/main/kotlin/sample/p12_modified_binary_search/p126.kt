package p12_modified_binary_search

fun main() {
    val arrays = arrayOf(
        intArrayOf(4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30),
        intArrayOf(4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30),
        intArrayOf(1, 3, 8, 10, 15),
        intArrayOf(1, 3, 8, 10, 15),
    )
    val keys = arrayOf(16, 11, 15, 200)
    for (i in arrays.indices) {
        val reader = ArrayReader(arrays[i])
        val index = p126(reader, keys[i])
        println("array: ${arrays[i].contentToString()}, key: ${keys[i]}, index: $index")
    }
}

class ArrayReader(val array: IntArray) {
    fun get(index: Int) = if (index >= array.size) Int.MAX_VALUE else array[index]
}

fun p126(reader: ArrayReader, key: Int): Int {
    if (reader.get(0) == Int.MAX_VALUE)
        return -1

    var j = 1
    var i = 0
    while (true) {
        val number = reader.get(j - 1)
        if (number == key)
            return j - 1
        if (number == Int.MAX_VALUE || number > key)
            break
        i = j
        j *= 2
    }

    while (i <= j) {
        val k = (i + j) / 2
        if (reader.get(k) == key)
            return k

        if (reader.get(k) < key)
            i = k + 1
        else
            j = k - 1
    }
    return if (reader.get(i) == Int.MAX_VALUE) -1 else i
}