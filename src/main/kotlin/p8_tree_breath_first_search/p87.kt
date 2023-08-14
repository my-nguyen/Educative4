package p8_tree_breath_first_search

import java.util.LinkedList

fun main() {
    val arrays = arrayOf(
        arrayOf(intArrayOf(1), intArrayOf(2, 3), intArrayOf(4, 5, -1, -1)),
        arrayOf(intArrayOf(12), intArrayOf(7,1), intArrayOf(9,-1,10,5)),
        arrayOf(intArrayOf(12), intArrayOf(7,1), intArrayOf(9,-1,10,5)),
    )
    val keys = arrayOf(3, 9, 12)
    for (i in arrays.indices) {
        val head = TreeNode.build(arrays[i])
        val successor = p87(head, keys[i])
        println("key: ${keys[i]}, successor: $successor")
    }
}

fun p87(root: TreeNode, key: Int): TreeNode? {
    val queue = LinkedList<TreeNode>()
    queue.add(root)
    var target: TreeNode? = null
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 1..size) {
            val node = queue.remove()
            if (target != null)
                return node
            if (node.value == key)
                target = node

            if (node.left != null)
                queue.add(node.left!!)
            if (node.right != null)
                queue.add(node.right!!)
        }
    }
    return null
}