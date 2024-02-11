package sample.p7_inplace_reversal_of_a_linked_list

import Node

fun main() {
    val array = intArrayOf(1,2,3,4,5,6,7,8)
    val head = Node.fromArray(array)
    print("original: ")
    head.print()
    val reversed = p74(head, 3)
    print("reversed: ")
    reversed?.print()
}

// solution copied from project "educative"
fun p74(head: Node?, k: Int): Node? {
    if (k <= 1 || head == null)
        return head

    var previous: Node? = null
    var current = head
    var list = head
    while (true) {
        val preStart = previous
        val end = current
        for (i in 1..k) {
            if (current == null)
                break

            val tmp = current.next
            current.next = previous
            previous = current
            current = tmp
        }

        if (preStart != null) {
            preStart.next = previous
        } else {
            list = previous!!
        }

        end!!.next = current

        if (current == null)
            break
        previous = end
    }
    return list
}