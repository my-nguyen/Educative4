package sample.p8_tree_breath_first_search

import TreeNode
import java.util.LinkedList

fun main() {
    val arrays = arrayOf(
        arrayOf(intArrayOf(1), intArrayOf(2,3), intArrayOf(4,5,-1,-1)),
        arrayOf(intArrayOf(12), intArrayOf(7,1), intArrayOf(-1,-1,10,5)),
        arrayOf(intArrayOf(12), intArrayOf(7,1), intArrayOf(9,-1,10,5), intArrayOf(-1,-1,-1,-1,11,-1,-1,-1)),
    )
    for (array in arrays) {
        val head = TreeNode.build(array)
        val depth = p86(head)
        println("minimum depth: $depth")
    }
}

fun p86(root: TreeNode): Int {
    val queue = LinkedList<TreeNode>()
    queue.add(root)
    var depth = 1
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 1..size) {
            val node = queue.remove()
            if (node.left == null && node.right == null)
                return depth

            if (node.left != null)
                queue.add(node.left!!)
            if (node.right != null)
                queue.add(node.right!!)
        }
        depth++
    }
    return depth
}