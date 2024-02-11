package practice1.p2_sliding_window

fun main() {
    val strings = listOf("aabccbb", "abbbb", "abccde")
    for (string in strings) {
        println("string: $string => ${sample.p2_sliding_window.p26(string)}")
    }
}

fun p26(string: String): Int {
    val set = mutableSetOf<Char>()
    set.add(string[0])
    var i = 0
    var length = 1
    for (j in 1.. string.lastIndex) {
        if (set.contains(string[j])) {
            while (true) {
                set.remove(string[i])
                if (string[i] == string[j])
                    break
                i++
            }
        }
        length = maxOf(length, j-i+1)
        set.add(string[j])
    }
    return length
}