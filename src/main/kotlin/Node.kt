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

    fun findMiddle(): Node {
        var slow = this
        var fast = this
        while (fast.next != null) {
            slow = slow.next!!
            fast = fast.next!!
            if (fast.next != null)
                fast = fast.next!!
        }
        return slow
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