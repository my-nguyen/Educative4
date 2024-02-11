package practice1.p2_sliding_window

fun main() {
    val arrays = listOf(charArrayOf('A','B','C','A','C'), charArrayOf('A','B','C','B','B','C'))
    for (array in arrays) {
        println("array: ${array.contentToString()} => ${sample.p2_sliding_window.p25(array)}")
    }
}

fun p25(array: CharArray): Int {
    val map = mutableMapOf<Char, Int>()
    map[array.first()] = 1
    var i = 0
    var length = 1
    for (j in 1..array.lastIndex) {
        if (!map.containsKey(array[j])) {
            while (map.size == 2) {
                map[array[i]] = map.getOrDefault(array[i], 0) - 1
                if (map[array[i]] == 0)
                    map.remove(array[i])
                i++
            }
        }
        length = maxOf(length, j-i+1)
        map[array[j]] = map.getOrDefault(array[j], 0) + 1
    }
    return length
}