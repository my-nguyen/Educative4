package practice1.p3_two_pointers

fun main() {
    val arrays = listOf(intArrayOf(2,3,3,3,6,9,9), intArrayOf(2,2,2,11))
    for (array in arrays) {
        println("array: ${array.contentToString()} => ${p33(array)}")
    }
}

fun p33(array: IntArray): Int {
    var i = 0
    for (j in 0 until array.lastIndex) {
        if (array[j] == array[j+1])
            continue
        array[i] = array[j]
        i++
    }
    return i + 1
}