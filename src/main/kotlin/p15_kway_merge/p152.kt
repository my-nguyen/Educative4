package p15_kway_merge

import java.util.PriorityQueue

fun main() {
    val data = arrayOf(
        arrayOf(intArrayOf(2,6,8), intArrayOf(3,6,7), intArrayOf(1,3,4)),
        arrayOf(intArrayOf(5,8,9), intArrayOf(1,7))
    )
    for (arrays in data) {
        val lists = mutableListOf<ListNode>()
        for (array in arrays) {
            val list = ListNode.build(array)
            lists.add(list)
        }
        val merged = p152(lists.toTypedArray())
        merged.print()
    }
}

// sample from project "educative"
fun p152(lists: Array<ListNode>): ListNode {
    val minHeap = PriorityQueue<ListNode> { n1, n2 -> n1.value - n2.value }

    // put the root of each list onto minHeap
    for (root in lists)
        minHeap.add(root)

    var result: ListNode? = null
    var current: ListNode? = null
    while (minHeap.isNotEmpty()) {
        // take the top element from minHeap and add it to the result linked list
        val node = minHeap.poll()
        if (result == null) { // the very first node out of minHeap
            current = node
            result = node
        } else { // connect subsequent nodes
            current!!.next = node
            current = current.next
        }

        // if the top element has a next element add it to the heap
        if (node!!.next != null)
            minHeap.add(node.next)
    }

    return result!!
}