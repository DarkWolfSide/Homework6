fun main() {
    println("Number of 'a' occurrences: ${f646("Average Programming Enjoyer", 'a')}")
    println("acbca".isPalindrome())
    println(f648("Box of toys",'o', 'x'))
    println(f649("abszotoz", 'z'))
    println(f650("Town","Tower"))
    println(f651("California"))
    println(f652("Town","Tower"))
    println(f653("California"))
    println(f654("California"))
    println(f655("Mario"))
    println(f656("xenon"))
    println(f657("Chocolate"))
}
fun f646(str: String, targetChar: Char): Int {
    return str.count { it == targetChar }
}
fun String.isPalindrome(): Boolean {
    for (i in 0 until this.length / 2) {
        if (this[i] != this[this.length - 1 - i]) {
            return false
        }
    }
    return true
}
fun f648(text: String, char: Char, afterChar: Char): Int {
    var count = 0
    var foundAfterChar = false

    for (c in text) {
        if (foundAfterChar && c == char) {
            count++
        }

        if (c == afterChar) {
            foundAfterChar = true
        }
    }

    return count
}
fun f649(text: String, char: Char): Int {
    var count = 0
    var foundFirst = false

    for (c in text) {
        if (!foundFirst && c == char) {
            foundFirst = true
        } else if (foundFirst && c == char) {
            break
        }

        if (foundFirst) {
            count++
        }
    }

    return count
}
fun f650(string1: String, string2: String): Int {
    return string1.filter { char -> string2.contains(char, ignoreCase = true) }.length
}
fun f651(input: String): String {
    return input.groupBy { it }
        .filter { it.value.size > 1 }
        .keys
        .joinToString("")
}
fun f652(string1: String, string2: String): String {
    return string1.filter { char -> string2.contains(char, ignoreCase = true) }
}
fun f653(input: String): String {
    return input.replace("a", "ac")
}
fun f654(input: String): String {
    return input.replace("a", "")
}
fun f655(string: String): String {
    var reversed = ""
    for (i in string.length - 1 downTo 0) {
        reversed += string[i]
    }
    return reversed
}
fun f656(input: String): String {
    return input.replace("x", "yy")
}
fun f657(input: String): String {
    var result = ""

    for (i in input.indices step 2) {
        val first = input[i].toInt()
        val second = if (i < input.length - 1) input[i + 1].toInt() else first
        val greater = if (first >= second) first.toChar() else second.toChar()
        result += greater
    }

    return result
}