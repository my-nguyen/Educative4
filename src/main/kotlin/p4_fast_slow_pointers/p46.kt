package p4_fast_slow_pointers

fun main() {
    val arrays = listOf(intArrayOf(2,4,6,4,2), intArrayOf(2,4,6,6,4,2), intArrayOf(2,4,6,6,4,2,2))
    for (array in arrays) {
        val head = Node.fromArray(array)
        println("list: ${array.contentToString()}, is palindrome? ${p46(head)}")
    }
}

fun p46(head: Node): Boolean {
    val copy = Node.fromArray(head.toArray())
    val reversed = Node.reverse(copy)
    println("reversed: ${reversed.toArray().contentToString()}")
    return head.toArray().contentEquals(reversed.toArray())
}

