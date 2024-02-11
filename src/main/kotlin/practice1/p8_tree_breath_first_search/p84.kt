package practice1.p8_tree_breath_first_search

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
    val result = mutableListOf<List<Int>>()
    val queue = LinkedList<TreeNode>()
    queue.add(root)
    var ltr = true
    while (queue.isNotEmpty()) {
        val size = queue.size
        val list = mutableListOf<Int>()
        for (i in 0 until size) {
            val node = queue.remove()
            if (ltr)
                list.add(node.value)
            else
                list.add(0, node.value)
            node.left?.let { queue.add(it) }
            node.right?.let { queue.add(it) }
        }
        ltr = !ltr
        result.add(list)
    }
    return result
}