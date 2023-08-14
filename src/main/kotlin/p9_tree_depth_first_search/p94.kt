package p9_tree_depth_first_search

fun main() {
    val arrays = arrayOf(
        arrayOf(intArrayOf(1), intArrayOf(7,9), intArrayOf(-1,-1,2,9)),
        arrayOf(intArrayOf(1), intArrayOf(0,1), intArrayOf(1,-1,6,5)),
    )
    for (i in arrays.indices) {
        val root = TreeNode.build(arrays[i])
        val sum = p94(root)
        println("sum of all paths: $sum")
    }
}

fun p94(root: TreeNode) = work(root, 0)

private fun work(node: TreeNode?, current: Int): Int {
    if (node == null)
        return 0

    val value = current*10 + node.value
    if (node.left == null && node.right == null)
        return value

    return work(node.left, value) + work(node.right, value)
}