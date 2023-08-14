package p12_modified_binary_search

fun main() {
    val arrays = arrayOf(
        charArrayOf('a','c','f','h'), charArrayOf('a','c','f','h'), charArrayOf('a','c','f','h'), charArrayOf('a','c','f','h')
    )
    val keys = arrayOf('f', 'b', 'm', 'h')
    for (i in arrays.indices) {
        val next = p124(arrays[i], keys[i])
        println("letters: ${arrays[i].contentToString()}, key: ${keys[i]}, next: $next")
    }
}

fun p124(chars: CharArray, key: Char): Char {
    if (key < chars.first() || chars.last() <= key)
        return chars.first()

    var i = 0
    var j = chars.lastIndex
    while (i < j) {
        val k = (i + j) / 2
        if (chars[k] == key)
            return chars[k + 1]

        if (chars[k] < key)
            i = k + 1
        else
            j = k - 1
    }
    return chars[j + 1]
}