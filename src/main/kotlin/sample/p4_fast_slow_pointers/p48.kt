package sample.p4_fast_slow_pointers

import Node

fun main() {
    val arrays = listOf(intArrayOf(1,2,3,4,5,6), intArrayOf(2,4,6,8,10,12), intArrayOf(2,4,6,8,10))
    for (array in arrays) {
        val head = Node.fromArray(array)
        println("list: ${array.contentToString()}, rearranged: ${p48(head).toArray().contentToString()}")
    }
}

fun p48(head: Node): Node {
    val middle = head.findMiddle()
    var right: Node? = Node.reverse(middle)
    var left: Node? = head
    while (left != null && right != null) {
        val tmp1 = left.next
        left.next = right
        left = tmp1
        val tmp2 = right.next
        right.next = left
        right = tmp2
        if (left!!.next == null || right!!.next == null)
            break
    }
    return head
}

fun p48a(head: Node): Node {
    val middle = head.findMiddle()
    val reversed = Node.reverse(middle)
    println("head: ${head.toArray().contentToString()}")
    println("reversed: ${reversed.toArray().contentToString()}")
    val forward = head.toArray()
    val backward = reversed.toArray()
    var i = 0
    val dummy = Node(0)
    var current = dummy
    while (i < forward.size && i < backward.size) {
        current.next = Node(forward[i])
        current = current.next!!
        current.next = Node(backward[i])
        current = current.next!!
        i++
    }
    return dummy.next!!
}