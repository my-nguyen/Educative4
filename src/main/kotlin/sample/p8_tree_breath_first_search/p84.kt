package sample.p8_tree_breath_first_search

import TreeNode
import java.util.LinkedList

fun main() {
    val arrays = arrayOf(
        arrayOf(intArrayOf(1), intArrayOf(2,3), intArrayOf(4,5,6,7)),
        arrayOf(intArrayOf(12), intArrayOf(7,1), intArrayOf(9,-1,10,5))
    )
    for (array in arrays) {
        val head = TreeNode.build(array)
        val list = p84(head)
        for (sublist in list) {
            print("$sublist, ")
        }
        println()
    }
}

fun p84(root: TreeNode): List<List<Int>> {
    val queue = LinkedList<TreeNode>()
    queue.add(root)
    val result = mutableListOf<List<Int>>()
    var direction = 0
    while (queue.isNotEmpty()) {
        val size = queue.size
        val list = mutableListOf<Int>()
        for (i in 1..size) {
            val node = queue.remove()
            if (direction == 0)
                list.add(node.value)
            else
                list.add(0, node.value)
            if (node.left != null)
                queue.add(node.left!!)
            if (node.right != null)
                queue.add(node.right!!)
        }
        direction = (direction + 1) % 2
        result.add(list)
    }
    return result
}