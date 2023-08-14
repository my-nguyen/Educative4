package p11_subsets

import java.util.*

fun main() {
    val counts = arrayOf(2, 3)
    for (count in counts) {
        val parens = p116(count)
        println("count: $count, parentheses: $parens")
    }
}

data class Parenthesis(val string: String, var opens: Int, var closes: Int)

// copied from project "educative"
fun p116(count: Int): List<String> {
    val queue = LinkedList<Parenthesis>()
    val emptyParen = Parenthesis("", 0, 0)
    queue.offer(emptyParen)
    val result = mutableListOf<String>()
    while (queue.isNotEmpty()) {
        // pop the top parenthesis
        val topParen = queue.poll()
        if (topParen.opens == count && topParen.closes == count) {
            // the maximum number of open and close parentheses is reached: add string to the result
            result.add(topParen.string)
        } else {
            if (topParen.opens < count) {
                // the maximum number of open parentheses is not reached: append an '(' and save it for next iteration
                val newParen = Parenthesis(topParen.string + "(", topParen.opens + 1, topParen.closes)
                queue.offer(newParen)
            }
            if (topParen.opens > topParen.closes) {
                // there's more open parentheses than left in the top entry: append an ')' and save it for next iteration
                val newParen = Parenthesis(topParen.string + ")", topParen.opens, topParen.closes + 1)
                queue.offer(newParen)
            }
        }
    }
    return result
}