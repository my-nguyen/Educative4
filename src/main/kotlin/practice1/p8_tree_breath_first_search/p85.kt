package practice1.p8_tree_breath_first_search

import TreeNode
import java.util.LinkedList

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
    val result = mutableListOf<Double>()
    val queue = LinkedList<TreeNode>()
    queue.add(root)
    while (queue.isNotEmpty()) {
        val size = queue.size
        val list = mutableListOf<Int>()
        for (i in 0 until size) {
            val node = queue.remove()
            list.add(node.value)
            node.left?.let { queue.add(it) }
            node.right?.let { queue.add(it) }
        }
        result.add(list.average())
    }
    return result
}