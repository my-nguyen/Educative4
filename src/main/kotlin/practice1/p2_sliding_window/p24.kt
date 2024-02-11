package practice1.p2_sliding_window

fun main() {
    val strings = listOf("araaci", "araaci", "cbbebi")
    val distincts = listOf(2, 1, 3)
    for (i in strings.indices) {
        println("string: ${strings[i]}, distinct: ${distincts[i]}, max length: ${p24(strings[i], distincts[i])}")
    }
}

fun p24(string: String, distinct: Int): Int {
    var i = 0
    val map = mutableMapOf<Char, Int>()
    map[string[i]] = 1
    var length = 0
    for (j in 1..string.lastIndex) {
        if (!map.contains(string[j])) {
            while (i <= j && map.size == distinct) {
                map[string[i]] = map[string[i]]!! - 1
                if (map[string[i]] == 0)
                    map.remove(string[i])
                i++
            }
        }
        map[string[j]] = map.getOrDefault(string[j], 0) + 1
        length = maxOf(length, j-i+1)
    }
    return length
}