package practice1.p4_fast_slow_pointers

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
    var slow = node.next
    var fast = node.next?.next
    while (fast != null) {
        if (fast == slow)
            return true
        slow = slow?.next
        fast = fast.next?.next
    }
    return false
}