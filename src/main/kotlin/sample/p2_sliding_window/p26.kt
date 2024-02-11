package sample.p2_sliding_window

fun main() {
    val strings = listOf("aabccbb", "abbbb", "abccde")
    for (string in strings) {
        println("string: $string => ${p26(string)}")
    }
}

fun p26(string: String): Int {
    var i = 0
    var max = 1
    val set = mutableSetOf<Char>()
    set.add(string.first())
    for (j in 1..string.lastIndex) {
        val c = string[j]
        if (set.contains(c)) {
            while (true) {
                if (string[i] == c) {
                    i++
                    break
                }
                i++
            }
        } else {
            set.add(c)
        }
        max = maxOf(max, j-i+1)
    }
    return max
}