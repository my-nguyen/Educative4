package sample.p8_tree_breath_first_search

import TreeNode
import java.util.*

fun main() {
    val arrays = arrayOf(
        arrayOf(intArrayOf(1), intArrayOf(2,3), intArrayOf(4,5,6,7)),
        arrayOf(intArrayOf(12), intArrayOf(7,1), intArrayOf(9,-1,10,5), intArrayOf(3,-1,-1,-1,-1,-1,-1,-1)),
    )
    for (array in arrays) {
        val head = TreeNode.build(array)
        val list = p811(head)
        for (node in list) {
            print("${node.value} ")
        }
        println()
    }
}

fun p811(root: TreeNode?): List<TreeNode> {
    val result = mutableListOf<TreeNode>()
    val queue = LinkedList<TreeNode>()
    queue.offer(root)
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 1..size) {
            val current = queue.poll()
            if (i == size)
                result.add(current)

            if (current.left != null)
                queue.add(current.left!!)
            if (current.right != null)
                queue.add(current.right!!)
        }
    }
    return result
}