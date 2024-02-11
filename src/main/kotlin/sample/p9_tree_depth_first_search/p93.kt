package p9_tree_depth_first_search

import TreeNode

fun main() {
    val arrays = arrayOf(
        arrayOf(intArrayOf(1), intArrayOf(7,9), intArrayOf(4,5,2,7)),
        arrayOf(intArrayOf(12), intArrayOf(7,1), intArrayOf(4,-1,10,5)),
    )
    val sums = arrayOf(12, 23)
    for (i in arrays.indices) {
        val root = TreeNode.build(arrays[i])
        val paths = p93(root, sums[i])
        for (path in paths) {
            print("$path, ")
        }
        println()
    }
}

fun p93(root: TreeNode?, sum: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    work(root, sum, result, mutableListOf())
    return result
}

private fun work(node: TreeNode?, sum: Int, paths: MutableList<List<Int>>, path: MutableList<Int>) {
    if (node == null)
        return

    path.add(node.value)
    if (node.value == sum && node.left == null && node.right == null) {
        paths.add(path.toList())
    } else {
        work(node.left, sum-node.value, paths, path)
        work(node.right, sum-node.value, paths, path)
    }
    path.remove(node.value)
}