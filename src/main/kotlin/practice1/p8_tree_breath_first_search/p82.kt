package practice1.p8_tree_breath_first_search

import TreeNode
import java.util.LinkedList

fun main() {
    val arrays = arrayOf(
        arrayOf(intArrayOf(1), intArrayOf(2,3), intArrayOf(4,5,6,7)),
        arrayOf(intArrayOf(12), intArrayOf(7,1), intArrayOf(9,-1,10,5)),
    )
    for (array in arrays) {
        val head = TreeNode.build(array)
        val list = p82(head)
        for (sublist in list) {
            print("$sublist, ")
        }
        println()
    }
}

fun p82(root: TreeNode): List<List<Int>> {
    val queue = LinkedList<TreeNode>()
    queue.add(root)
    val result = mutableListOf<List<Int>>()
    while (queue.isNotEmpty()) {
        val size = queue.size
        val list = mutableListOf<Int>()
        for (i in 0 until size) {
            val node = queue.remove()
            list.add(node.value)
            if (node.left != null)
                queue.add(node.left!!)
            if (node.right != null)
                queue.add(node.right!!)
        }
        result.add(list)
    }
    return result
}