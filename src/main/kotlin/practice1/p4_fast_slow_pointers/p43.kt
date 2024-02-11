package practice1.p4_fast_slow_pointers

import Node

fun main() {
    val array = intArrayOf(1,2,3,4,5,6)
    val head = Node.fromArray(array)
    head.next!!.next!!.next!!.next!!.next!!.next = head.next!!.next
    println("start: ${p43(head)}")
}

fun p43(head: Node): Node {
    val cycle = findCycle(head)
    val size = cycleSize(cycle)
    return cycleHead(cycle, size)
}

fun findCycle(head: Node): Node {
    var slow = head.next
    var fast = slow?.next
    while (fast != slow) {
        fast = fast?.next?.next
        slow = slow?.next
    }
    return fast!!
}

fun cycleSize(cycle: Node): Int {
    var next = cycle
    var count = 1
    while (next.next != cycle) {
        next = next.next!!
        count++
    }
    return count
}

fun cycleHead(head: Node, size: Int): Node {
    var fast = head
    for (i in 0 until size) {
        fast = fast.next!!
    }
    var slow = head
    while (slow != fast) {
        slow = slow.next!!
        fast = fast.next!!
    }
    return slow
}