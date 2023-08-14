package p15_kway_merge

data class ListNode(val value: Int, var next: ListNode? = null) {
    override fun toString() = "$value"

    fun print() {
        var current: ListNode? = this
        while (current != null) {
            print("$current ")
            current = current.next
        }
        println()
    }

    companion object {
        fun build(array: IntArray): ListNode {
            val dummy = ListNode(-1)
            var current = dummy
            for (number in array) {
                current.next = ListNode(number)
                current = current.next!!
            }
            return dummy.next!!
        }
    }
}