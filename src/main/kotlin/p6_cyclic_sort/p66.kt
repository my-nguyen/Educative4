package p6_cyclic_sort

fun main() {
    val arrays = listOf(intArrayOf(3,4,4,5,5), intArrayOf(5,4,7,2,3,5,3))
    for (array in arrays) {
        println("array: ${array.contentToString()} => ${p66(array)}")
    }
}

fun p66(array: IntArray): List<Int> {
    for (i in array.indices) {
        while (array[i]-1 != i && array[array[i]-1] != array[i])
            swap(array, i, array[i]-1)
    }
    val result = mutableListOf<Int>()
    for (i in array.indices) {
        if (array[i]-1 != i)
            result.add(array[i])
    }
    return result
}