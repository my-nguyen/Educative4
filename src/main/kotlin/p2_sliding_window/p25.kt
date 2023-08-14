package p2_sliding_window

fun main() {
    val arrays = listOf(charArrayOf('A','B','C','A','C'), charArrayOf('A','B','C','B','B','C'))
    for (array in arrays) {
        println("array: ${array.contentToString()} => ${p25(array)}")
    }
}

fun p25(array: CharArray): Int {
    var i = 0
    var max = 2
    val map = mutableMapOf<Char, Int>()
    map[array.first()] = 1
    for (j in 1..array.lastIndex) {
        val c = array[j]
        if (!map.containsKey(c)) {
            while (map.size == 2) {
                val d = array[i]
                map[d] = map[d]!! - 1
                if (map[d] == 0)
                    map.remove(d)
                i++
            }
        }
        map[c] = map.getOrDefault(c, 0) + 1
        max = maxOf(max, j-i+1)
    }
    return max
}