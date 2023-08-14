package p11_subsets

import java.util.*

fun main() {
    val array = arrayOf(intArrayOf(1, 3, 5), /*intArrayOf(1, 2, 3)*/)
    for (numbers in array) {
        val permutations = p114(numbers)
        for (permutation in permutations) {
            print("$permutation, ")
        }
        println()
    }
}

// copied from project "educative"
fun p114(array: IntArray): List<List<Int>> {
    val permutations = mutableListOf<List<Int>>()
    val queue = LinkedList<List<Int>>()
    queue.add(mutableListOf())
    for (number in array) {
        // take all existing permutations and add the current number to create new permutations
        val size = queue.size
        for (i in 1..size) {
            val top = queue.poll()
            println("number $number, queue size $size, i $i, queued: $queue")
            // create a new permutation by adding the current number at every position
            for (j in 0..top.size) {
                val permutation = top.toMutableList()
                // add new number into permutation at position j which goes from 0 to queued.size
                // so if previous = [1] and number = 3, this will create 2 new permutations [3,1] and [1,3]
                permutation.add(j, number)
                println("j: $j, queued.size: ${queue.size}, number $number, new permutation: $permutation, ")
                if (permutation.size == array.size) {
                    // if permutation contains all elements from array, then save permutation in result list
                    permutations.add(permutation)
                } else {
                    // otherwise, push permutation into queue for processing at the next outer loop iteration
                    queue.add(permutation)
                }
            }
        }
    }
    return permutations
}