package p13_bitwise_xor

fun main() {
    val numbers = arrayOf(8, 10)
    for (number in numbers) {
        val complement = p133(number)
        println("number: $number, complement: $complement")
    }
}

fun p133(number: Int): Int {
    val binary = number.toString(2)
    val complement = CharArray(binary.length)
    for (i in binary.indices)
        complement[i] = '0' + (binary[i] - '0' + 1) % 2
    return String(complement).toInt(2)
}