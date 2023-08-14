package p9_tree_depth_first_search

fun main() {
    val arrays = arrayOf(
        arrayOf(intArrayOf(1), intArrayOf(2,3), intArrayOf(4,5,6,7)),
        arrayOf(intArrayOf(12), intArrayOf(7,1), intArrayOf(9,-1,10,5)),
        arrayOf(intArrayOf(12), intArrayOf(7,1), intArrayOf(9,-1,10,5)),
    )
    val sums = arrayOf(10, 23, 16)
    for (i in arrays.indices) {
        val root = TreeNode.build(arrays[i])
        val hasPath = p92(root, sums[i])
        println("Tree has path: $hasPath")
    }
}

fun p92(root: TreeNode, sum: Int): Boolean {
    if (root.left == null && root.right == null)
        return root.value == sum

    if (root.left != null) {
        if (p92(root.left!!, sum-root.value))
            return true
    }
    if (root.right != null) {
        if (p92(root.right!!, sum-root.value))
            return true
    }
    return false
}

// copied from project "educative
private fun p92a(root: TreeNode?, sum: Int): Boolean {
    if (root == null)
        return false

    // if the current node is a leaf and its value is equal to the sum, we've found a path
    if (root.value == sum && root.left == null && root.right == null)
        return true

    // recursively call to traverse the left and right sub-tree
    return p92a(root.left, sum - root.value) || p92a(root.right, sum - root.value)
}