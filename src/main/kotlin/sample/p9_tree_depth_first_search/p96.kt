package p9_tree_depth_first_search

import TreeNode

fun main() {
    val arrays = arrayOf(
        arrayOf(intArrayOf(1), intArrayOf(7,9), intArrayOf(6,5,2,3)),
        arrayOf(intArrayOf(12), intArrayOf(7,1), intArrayOf(4,-1,10,5)),
    )
    val sums = arrayOf(12, 11)
    for (i in arrays.indices) {
        val root = TreeNode.build(arrays[i])
        val count = p96(root, sums[i])
        for (array in arrays[i]) {
            print("${array.contentToString()}, ")
        }
        println("sum ${sums[i]}, count: $count")
    }
}

fun p96(root: TreeNode, sum: Int) = work(root, sum, mutableListOf())

private fun work(node: TreeNode?, sum: Int, path: MutableList<Int>): Int {
    if (node == null)
        return 0

    var count = 0
    path.add(node.value)
    if (isInPath(sum, path))
        count++

    count += work(node.left, sum, path) + work(node.right, sum, path)
    path.remove(node.value)
    return count
}

private fun isInPath(target: Int, path: List<Int>): Boolean {
    var sum = 0
    for (i in path.lastIndex downTo 0) {
        sum += path[i]
        if (sum == target)
            return true
    }
    return false
}