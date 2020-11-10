fun main() {
    val letter = readLine()!!.first().toLowerCase()
    val alphabet = ('a'..'z').mapIndexed { i, c -> c to i + 1 }.toMap()
    val vowels = "aeiou"
    if (vowels.contains(letter)) print(alphabet[letter]) else println(0)
}