package p11_subsets

fun main() {
    val arrays = arrayOf(intArrayOf(1,3,3), intArrayOf(1,5,3,3))
    for (array in arrays) {
        val subsets = p113(array)
        for (subset in subsets) {
            print("$subset, ")
        }
        println()
    }
}

// algorithm based on description from project "educative"
fun p113(array: IntArray): List<List<Int>> {
    array.sort()

    val result = mutableListOf<List<Int>>()
    result.add(listOf())
    val previous = mutableListOf<List<Int>>()
    for (i in array.indices) {
        val tmp = if (i > 0 && array[i] == array[i-1])
            work(previous, array[i])
        else
            work(result, array[i])
        result.addAll(tmp)
        previous.clear()
        previous.addAll(tmp)
    }
    return result
}

private fun work(list: MutableList<List<Int>>, number: Int): List<List<Int>> {
    val size = list.size
    val result = mutableListOf<List<Int>>()
    for (j in 0 until size) {
        val tmp = list[j].toMutableList()
        tmp.add(number)
        result.add(tmp)
    }
    return result
}