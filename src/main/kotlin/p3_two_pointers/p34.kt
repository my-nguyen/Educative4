package p3_two_pointers

fun main() {
    val arrays = listOf(intArrayOf(-2,-1,0,2,3), intArrayOf(-3,-1,0,1,2))
    for (array in arrays) {
        println("array: ${array.contentToString()} => ${p34(array).contentToString()}")
    }
}

fun p34(array: IntArray): IntArray {
    var i = 0
    while (array[i] < 0)
        i++
    var j = i - 1
    val squares = IntArray(array.size)
    var k = 0
    while (i <= array.lastIndex && j >= 0) {
        if (-array[j] < array[i]) {
            squares[k] = array[j] * array[j]
            j--
        } else {
            squares[k] = array[i] * array[i]
            i++
        }
        k++
    }
    while (i <= array.lastIndex) {
        squares[k] = array[i] * array[i]
        i++
        k++
    }
    while (j >= 0) {
        squares[k] = array[j] * array[j]
        j--
        k++
    }
    return squares
}