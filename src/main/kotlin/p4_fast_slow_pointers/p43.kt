package p4_fast_slow_pointers

fun main() {
    val array = intArrayOf(1,2,3,4,5,6)
    val head = Node.fromArray(array)
    head.next!!.next!!.next!!.next!!.next!!.next = head.next!!.next
    println("start: ${p43(head)}")
}

fun p43(head: Node): Node {
    val cycle = findCycle(head)!!
    val count = countNodes(cycle)
    return findCycleHead(head, count)
}

private fun findCycle(head: Node): Node? {
    var slow = head
    var fast = head
    do {
        fast = fast.next!!.next!!
        slow = slow.next!!
    } while (slow != fast)
    return slow
}

private fun countNodes(cycle: Node): Int {
    var node = cycle
    var count = 1
    while (node.next != cycle) {
        node = node.next!!
        count++
    }
    return count
}

private fun findFast(head: Node, count: Int): Node {
    var node = head
    var i = 0
    while (i < count) {
        node = node.next!!
        i++
    }
    return node
}

private fun findCycleHead(head: Node, count: Int): Node {
    var slow = head
    var fast = findFast(head, count)
    while (slow != fast) {
        slow = slow.next!!
        fast = fast.next!!
    }
    return slow
}