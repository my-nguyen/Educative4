package practice1.p8_tree_breath_first_search

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
        val depth = sample.p8_tree_breath_first_search.p86(head)
        println("minimum depth: $depth")
    }
}

fun p86(root: TreeNode): Int {
    val queue = LinkedList<TreeNode>()
    var depth = 1
    var min = Int.MAX_VALUE
    queue.add(root)
    while (queue.isNotEmpty()) {
        val size = queue.size
        depth++
        for (i in 0 until size) {
            val node = queue.remove()
            if (node.left == null && node.right == null)
                min = minOf(min, depth)
            node.left?.let { queue.add(it) }
            node.right?.let { queue.add(it) }
        }
        depth--
    }
    return min
}