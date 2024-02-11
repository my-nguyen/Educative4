package practice1.p4_fast_slow_pointers

import Node

fun main() {
    val arrays = listOf(intArrayOf(1,2,3,4,5), intArrayOf(1,2,3,4,5,6))
    for (array in arrays) {
        val head = Node.fromArray(array)
        println("list: ${array.contentToString()}, middle: ${p45(head)}")
    }
}

fun p45(head: Node): Node {
    var slow = head.next
    var fast = head.next?.next
    while (fast?.next != null && fast.next!!.next != null) {
        slow = slow?.next!!
        fast = fast.next!!.next
    }
    return slow!!
}