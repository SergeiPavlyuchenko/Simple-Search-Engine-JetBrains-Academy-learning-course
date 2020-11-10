fun concatenate(a: String, b: String, c: String, sep: String = " ") = print("$a$sep$b$sep$c")

fun main() {
    val (str1, str2, str3, separator) = Array(4) { readLine()!! }
    if (separator == "NO SEPARATOR") concatenate(str1, str2, str3) else concatenate(str1, str2, str3, separator)
}