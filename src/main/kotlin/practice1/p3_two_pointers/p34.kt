package practice1.p3_two_pointers

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
    var k = 0
    val result = IntArray(array.size)
    while (j >= 0 && i <= array.lastIndex) {
        val j2 = array[j]*array[j]
        val i2 = array[i]*array[i]
        if (j2 <= i2) {
            result[k] = j2
            j--
        } else {
            result[k] = i2
            i++
        }
        k++
    }
    while (j >= 0) {
        result[k++] = array[j]*array[j]
        j--
    }
    while (i <= array.lastIndex) {
        result[k++] = array[i]*array[i]
        i++
    }
    return result
}