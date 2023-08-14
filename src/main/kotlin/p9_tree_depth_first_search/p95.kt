package p9_tree_depth_first_search

fun main() {
    val arrays = arrayOf(
        arrayOf(intArrayOf(1), intArrayOf(7,9), intArrayOf(-1,-1,2,9)),
        arrayOf(intArrayOf(1), intArrayOf(0,1), intArrayOf(1,-1,6,5)),
        arrayOf(intArrayOf(1), intArrayOf(0,1), intArrayOf(1,-1,6,5)),
    )
    val sequences = arrayOf(
        intArrayOf(1,9,9), intArrayOf(1,0,7), intArrayOf(1,1,6)
    )
    for (i in arrays.indices) {
        val root = TreeNode.build(arrays[i])
        val isPath = p95(root, sequences[i])
        println("${sequences[i].contentToString()} is path? $isPath")
    }
}

fun p95(root: TreeNode?, sequence: IntArray) = work(root, sequence, 0)

private fun work(node: TreeNode?, sequence: IntArray, i: Int): Boolean {
    if (node == null)
        return false

    if (node.value != sequence[i])
        return false

    if (node.left == null && node.right == null)
        return i == sequence.lastIndex

    return work(node.left, sequence, i+1) || work(node.right, sequence, i+1)
}