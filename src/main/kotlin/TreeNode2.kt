data class TreeNode2(val value: Int, var left: TreeNode2?=null, var right: TreeNode2?=null, var next: TreeNode2?=null) {
    fun printLevelOrder() {
        var root: TreeNode2? = this
        while (root != null) {
            var current = root
            root = null
            while (current != null) {
                print("${current.value} ")
                if (root == null) {
                    if (current.left != null) {
                        root = current.left
                    } else if (current.right != null) {
                        root = current.right
                    }
                }
                current = current.next
            }
            println()
        }
    }

    fun printTree() {
        var current: TreeNode2? = this
        print("Traversal using 'next' pointer: ")
        while (current != null) {
            print("${current.value} ")
            current = current.next
        }
        println()
    }

    override fun toString() = "$value"

    companion object {
        fun build(arrays: Array<IntArray>): TreeNode2 {
            val head = TreeNode2(arrays[0][0])

            if (arrays.size > 1) {
                head.left = build(arrays[1][0])
                head.right = build(arrays[1][1])

                if (arrays.size > 2) {
                    head.left?.left = build(arrays[2][0])
                    head.left?.right = build(arrays[2][1])
                    head.right?.left = build(arrays[2][2])
                    head.right?.right = build(arrays[2][3])

                    if (arrays.size > 3) {
                        head.left?.left?.left = build(arrays[3][0])
                        head.left?.left?.right = build(arrays[3][1])
                        head.left?.right?.left = build(arrays[3][2])
                        head.left?.right?.right = build(arrays[3][3])
                        head.right?.left?.left = build(arrays[3][4])
                        head.right?.left?.right = build(arrays[3][5])
                        head.right?.right?.left = build(arrays[3][6])
                        head.right?.right?.right = build(arrays[3][7])
                    }
                }
            }

            return head
        }

        fun build(value: Int) = if (value == -1) null else TreeNode2(value)
    }
}
