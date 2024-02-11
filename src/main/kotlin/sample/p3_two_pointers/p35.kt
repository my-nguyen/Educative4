package sample.p3_two_pointers

fun main() {
    val arrays = listOf(intArrayOf(-3,0,1,2,-1,1,-2), intArrayOf(-5,2,-1,-2,3))
    for (array in arrays) {
        println("array: ${array.contentToString()} => ${p35(array)}")
    }
}

fun p35(array: IntArray): List<Triple<Int, Int, Int>> {
    val result = mutableListOf<Triple<Int, Int, Int>>()
    array.sort()
    for (i in 0..array.lastIndex-2) {
        if (array[i] == array[i+1])
            continue
        var j = i + 1
        var k = array.lastIndex
        while (j < k) {
            val sum = array[i] + array[j] + array[k]
            if (sum == 0) {
                result.add(Triple(array[i], array[j], array[k]))
                do
                    j++
                while (j < k && array[j] == array[j+1])
                do
                    k--
                while (j < k && array[k] == array[k-1])
            }
            else if (sum < 0)
                j++
            else
                k--
        }
    }
    return result
}