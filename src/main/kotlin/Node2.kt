data class Node2(val value: Int, var next: Node2? = null) {
    override fun toString() = value.toString()

    fun findMiddle(): Node2 {
        var slow = this
        var fast = this
//        println("pre: slow $slow, fast $fast")
        /*while (fast.next != null && fast.next!!.next != null) {
            slow = slow.next!!
            fast = fast.next!!.next!!
            println("loop: slow $slow, fast $fast")
        }*/
        while (fast.next != null) {
            slow = slow.next!!
            fast = fast.next!!
            if (fast.next != null)
                fast = fast.next!!
//            println("loop: slow $slow, fast $fast")
        }
//        println("post: slow $slow, fast $fast")
        return slow
    }

    fun toArray(): IntArray {
        var node: Node2? = this
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