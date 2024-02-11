package practice1.p3_two_pointers

fun main() {
    val arrays = listOf(intArrayOf(-3,0,1,2,-1,1,-2), intArrayOf(-5,2,-1,-2,3))
    for (array in arrays) {
        println("array: ${array.contentToString()} => ${p35(array)}")
    }
}

fun p35(array: IntArray): List<Triple<Int, Int, Int>> {
    array.sort()
    val result = mutableListOf<Triple<Int, Int, Int>>()
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
                while (j < k && array[j] == array[j++])
                do
                    k--
                while (j < k && array[k - 1] == array[k])
            } else if (sum < 0)
                j++
            else
                k--
        }
    }
    return result
}