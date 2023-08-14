package p3_two_pointers

import java.util.*

fun main() {
    val string1s = listOf("xy#z", "xy#z", "xp#", "xywrrmp")
    val string2s = listOf("xzz#", "xyz#", "xyz##", "xywrrmu#p")
    for (i in string1s.indices) {
        println("string1: ${string1s[i]}, string2: ${string2s[i]} => ${p312(string1s[i], string2s[i])}")
    }
}

fun p312(s1: String, s2: String): Boolean {
    val t1 = s1.toStack().joinToString("")
    val t2 = s2.toStack().joinToString("")
    // println("s1: $t1, s2: $t2")
    return t1 == t2
}

private fun String.toStack(): Stack<Char> {
    val stack = Stack<Char>()
    for (c in this) {
        if (c == '#')
            stack.pop()
        else
            stack.push(c)
    }
    return stack
}