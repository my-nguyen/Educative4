package sample.p4_fast_slow_pointers

import Node

fun main() {
    val array = intArrayOf(1,2,3,4,5,6)
    val head = Node.fromArray(array)
    println("array: ${head.toArray().contentToString()}")
    println("is circular? ${p42(head)}")
    head.next!!.next!!.next!!.next!!.next!!.next = head.next!!.next
    println("is circular? ${p42(head)}")
}

fun p42(node: Node): Boolean {
    var slow: Node? = node
    var fast = node.next
    while (fast!!.next != null && fast.next!!.next != null) {
        fast = fast.next!!.next
        slow = slow!!.next
        if (fast == slow)
            return true
    }
    return false
}