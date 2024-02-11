package sample.p7_inplace_reversal_of_a_linked_list

import Node

fun main() {
    val array = intArrayOf(1,2,3,4,5,6,7,8,9)
    val rotations = arrayOf(1,2,3,4,5,6,7,8,9,10)
    for (rotation in rotations) {
        val head = Node.fromArray(array)
        print("original: ")
        head.print()
        val rotated = p77(head, rotation)
        print("rotate $rotation: ")
        rotated?.print()
    }
}

// solution copied from project "educative"
fun p77(head: Node?, rotations: Int): Node? {
    if (head?.next == null || rotations <= 0)
        return head

    var last: Node = head
    var length = 1
    // count the total number of nodes
    while (last.next != null) {
        last = last.next!!
        length++
    }

    // connect the last node with the head to make it a circular list
    last.next = head
    val modular = rotations % length
    val skip = length - modular
    var lastRotated: Node = head
    for (i in 0..<skip-1) {
        lastRotated = lastRotated.next!!
    }

    // 'lastRotated.next' is pointing to the sub-list of 'k' ending nodes
    val list = lastRotated.next
    lastRotated.next = null
    return list!!
}