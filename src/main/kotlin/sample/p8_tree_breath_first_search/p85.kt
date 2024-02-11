package sample.p8_tree_breath_first_search

import TreeNode
import java.util.*

fun main() {
    val arrays = arrayOf(
        arrayOf(intArrayOf(1), intArrayOf(2,3), intArrayOf(4,5,6,7)),
        arrayOf(intArrayOf(12), intArrayOf(7,1), intArrayOf(9,2,10,5))
    )
    for (array in arrays) {
        val head = TreeNode.build(array)
        val averages = p85(head)
        for (average in averages) {
            print("$average, ")
        }
        println()
    }
}

fun p85(root: TreeNode): List<Double> {
    val queue = LinkedList<TreeNode>()
    queue.add(root)
    val result = mutableListOf<Double>()
    while (queue.isNotEmpty()) {
        val size = queue.size
        var sum = 0.0
        for (i in 1..size) {
            val node = queue.remove()
            sum += node.value
            if (node.left != null)
                queue.add(node.left!!)
            if (node.right != null)
                queue.add(node.right!!)
        }
        result.add(sum / size)
    }
    return result
}