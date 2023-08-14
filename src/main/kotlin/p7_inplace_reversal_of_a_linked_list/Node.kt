package p7_inplace_reversal_of_a_linked_list

data class Node(val value: Int, var next: Node? = null) {
    override fun toString() = value.toString()

    fun print() {
        var current: Node? = this
        while (current != null) {
            print("${current.value} ")
            current = current.next
        }
        println()
    }

    fun toArray(): IntArray {
        var node: Node? = this
        val result = mutableListOf<Int>()
        while (node != null) {
            result.add(node.value)
            node = node.next
        }
        return result.toIntArray()
    }

    companion object {
        fun fromArray(array: IntArray): Node {
            var head = Node(array.last())
            for (i in array.lastIndex - 1 downTo 0) {
                head = Node(array[i], head)
            }
            return head
        }

        fun reverse(head: Node): Node {
            var prev: Node? = null
            var next: Node? = head
            while (next != null) {
                val tmp = next.next
                next.next = prev
                prev = next
                next = tmp
            }
            return prev!!
        }
    }
}