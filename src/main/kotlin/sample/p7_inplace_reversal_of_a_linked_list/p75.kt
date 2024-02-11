package sample.p7_inplace_reversal_of_a_linked_list

import Node

fun main() {
    val array = intArrayOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16)
    val lengths = arrayOf(1,2,3,4,5)
    for (length in lengths) {
        val head = Node.fromArray(array)
        print("original: ")
        head.print()
        val reversed = p75(head, length)
        print("reversed: ")
        reversed?.print()
    }
}

// solution copied from project "educative"
fun p75(head: Node?, k: Int): Node? {
    if (k <= 1 || head == null)
        return head

    var previous: Node? = null
    var current = head
    var list = head
    while (current != null) {
        val preP = previous
        val atQ = current
        for (i in 1..k) {
            if (current == null)
                break

            val tmp = current.next
            current.next = previous
            previous = current
            current = tmp
        }

        if (preP != null) {
            preP.next = previous
        } else {
            list = previous!!
        }

        atQ.next = current

        for (i in 1..k) {
            if (current == null)
                break

            previous = current
            current = current.next
        }
    }
    return list
}
