package p6_cyclic_sort

fun main() {
    val arrays = listOf(intArrayOf(2,3,1,8,2,3,5,1), intArrayOf(2,4,1,2), intArrayOf(2,3,2,1))
    for (array in arrays) {
        println("array: ${array.contentToString()} => ${p64(array)}")
    }
}

fun p64(array: IntArray): List<Int> {
    for (i in array.indices) {
        while (array[i]-1 != i && array[array[i]-1] != array[i])
            swap(array, i, array[i]-1)
    }
    val result = mutableListOf<Int>()
    for (i in array.indices) {
        if (array[i]-1 != i)
            result.add(i+1)
    }
    return result
}