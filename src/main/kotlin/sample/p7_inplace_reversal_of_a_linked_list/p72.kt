package sample.p7_inplace_reversal_of_a_linked_list

import Node

fun main() {
    val arrays = listOf(intArrayOf(2,4,6,8,10))
    for (array in arrays) {
        println("original: ${array.contentToString()}, reversed: ${p72(Node.fromArray(array)).toArray().contentToString()}")
    }
}

fun p72(head: Node): Node {
    var previous: Node? = null
    var next: Node? = head
    while (next != null) {
        val tmp = next.next
        next.next = previous
        previous = next
        next = tmp
    }
    return previous!!
}