package practice1.p8_tree_breath_first_search

import TreeNode
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
    var current = root
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            val node = queue.remove()
            current.next = node
            current = node
            node.left?.let { queue.add(it) }
            node.right?.let { queue.add(it) }
        }
    }
    return root
}