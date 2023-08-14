package p3_two_pointers

fun main() {
    val arrays = listOf(intArrayOf(2,5,3,10), intArrayOf(8,2,6,5), intArrayOf(1,2,3,4,5,6))
    val targets = listOf(30, 50, 150)
    for (i in arrays.indices) {
        print("array: ${arrays[i].contentToString()}, target: ${targets[i]} =>")
        for (array in p38(arrays[i], targets[i]))
            print(" ${array.contentToString()}")
        println()
    }
}

fun p38(array: IntArray, target: Int): List<IntArray> {
    val result = mutableListOf<IntArray>()
    for (i in array.indices) {
        if (array[i] >= target)
            break
        result.add(intArrayOf(array[i]))
        var product = array[i]
        val list = mutableListOf(array[i])
        for (j in i+1..array.lastIndex) {
            if (array[j] >= target)
                break
            product *= array[j]
            if (product >= target)
                break
            list.add(array[j])
            result.add(list.toIntArray())
        }
    }
    return result
}