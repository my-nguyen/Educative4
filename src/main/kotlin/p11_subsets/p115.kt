package p11_subsets

fun main() {
    val strings = arrayOf("ad52", "ab7c")
    for (string in strings) {
        val permutations = p115(string)
        print("string: $string, permutations: ")
        for (permutation in permutations) {
            print("$permutation, ")
        }
        println()
    }
}

// copied from project "educative"
fun p115(string: String): List<String> {
    val permutations = mutableListOf<String>()
    if (string.isEmpty())
        return permutations

    // the original string is one permutation
    permutations.add(string)
    // iterate thru each character in string
    for (i in string.indices) {
        // println("i: $i")
        // only process characters and skip digits
        if (string[i].isLetter()) {
            val size = permutations.size
            // println("at $i is letter, permutations size: $size")
            // for each permutation in the current list, create a new permutation by changing the case of the current character
            for (j in 0 until size) {
                // convert string to a mutable array of characters
                val permutation = permutations[j].toCharArray()
                // println("j=$j, string-perm: ${permutations[j]}, array-perm: ${permutation.contentToString()}")
                // convert current character to lower case or upper case
                if (permutation[i].isUpperCase())
                    permutation[i] = permutation[i].lowercaseChar()
                else
                    permutation[i] = permutation[i].uppercaseChar()
                // println("post perm: ${permutation.contentToString()}")
                // convert character array back to string and save it as a new permutation so the next character
                // will have to account for this new permutation
                permutations.add(permutation.joinToString(""))
            }
        }
    }
    return permutations
}