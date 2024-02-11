package sample.p2_sliding_window

fun main() {
    val strings = listOf("araaci", "araaci", "cbbebi")
    val distincts = listOf(2, 1, 3)
    for (i in strings.indices) {
        println("string: ${strings[i]}, distinct: ${distincts[i]} => ${p24(strings[i], distincts[i])}")
    }
}

fun p24(string: String, distinct: Int): Int {
    val map = mutableMapOf<Char, Int>()
    var i = 0
    map[string[i]] = 1
    var max = 1
    // "araaci"
    for (j in 1..string.lastIndex) {
        val c = string[j]
        if (!map.containsKey(c)) {
            while (map.size == distinct) {
                val d = string[i]
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