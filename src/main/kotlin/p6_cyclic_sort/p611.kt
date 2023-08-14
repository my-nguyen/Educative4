package p6_cyclic_sort

fun main() {
    val arrays = listOf(intArrayOf(3,-1,4,5,5), intArrayOf(2,3,4))
    val counts = listOf(3, 3)
    for (i in arrays.indices) {
        println("array: ${arrays[i].contentToString()} => ${p611(arrays[i], counts[i])}")
    }
}

// incorrect solution
fun p611(array: IntArray, count: Int): List<Int> {
    for (i in array.indices) {
        while (array[i] > 0 && array[i] < array.size && array[i]-1 != i)
            swap(array, i, array[i]-1)
    }
    println("sorted ${array.contentToString()}")
    val result = mutableListOf<Int>()
    for (i in array.indices) {
        if (array[i]-1 != i) {
            println("adding ${i+1}")
            result.add(i + 1)
        }
    }
    for (i in 0 until count-result.size)
        result.add(i + 1 + array.size)
    return result
}