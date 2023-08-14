package p3_two_pointers

fun main() {
    val arrays = listOf(intArrayOf(4,1,2,-1,1,-3))
    val targets = listOf(1)
    for (i in arrays.indices) {
        print("array: ${arrays[i].contentToString()}, target: ${targets[i]} =>")
        for (array in p310(arrays[i], targets[i]))
            print(" ${array.contentToString()}")
        println()
    }
}

fun p310(array: IntArray, target: Int): List<IntArray> {
    array.sort()
    val result = mutableListOf<IntArray>()
    for (i in 0..array.lastIndex-3) {
        if (array[i] == array[i+1])
            continue
        for (j in i+1..array.lastIndex-2) {
            if (array[j] == array[j+1])
                continue
            var k = j + 1
            var l = array.lastIndex
            // -3,-1,1,1,2,4
            // println("pre i $i, j $j, k $k, l $l")
            while (k < l) {
                val sum = array[i] + array[j] + array[k] + array[l]
                // println("sum $sum, target $target, k $k, l $l")
                if (sum == target) {
                    result.add(intArrayOf(array[i], array[j], array[k], array[l]))
                    do {
                        k++
                    } while (k < l && array[k] == array[k+1])
                    do {
                        l--
                    } while (k < l && array[l-1] == array[l])
                    /*k++
                    l--*/
                } else if (sum < target)
                    k++
                else
                    l--
            }
            // println("post i $i, j $j, k $k, l $l")
        }
    }
    return result
}