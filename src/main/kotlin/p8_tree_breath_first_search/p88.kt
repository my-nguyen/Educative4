package p8_tree_breath_first_search

import java.util.LinkedList

fun main() {
    val arrays = arrayOf(
        arrayOf(intArrayOf(1), intArrayOf(2,3), intArrayOf(4,5,6,7)),
        arrayOf(intArrayOf(12), intArrayOf(7,1), intArrayOf(-1,9,10,5)),
    )
    for (array in arrays) {
        val head = TreeNode.build(array)
        p88(head)
        head.printTree()
    }
}

fun p88(root: TreeNode): TreeNode {
    val queue = LinkedList<TreeNode>()
    queue.add(root)
    var previous: TreeNode? = null
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 1..size) {
            val node = queue.poll()
            if (previous != null)
                previous.next = node
            previous = node

            if (node.left != null)
                queue.add(node.left!!)
            if (node.right != null)
                queue.add(node.right!!)
        }
    }
    return root
}