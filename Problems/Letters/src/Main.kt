fun main() {
    val letters = mutableMapOf<Int, Char>()
    var count = 1
    while (true) {
        val letter = readLine()!!.first().toLowerCase()
        if (letter == 'z') break
        letters[count] = letter
        count++
    }
    if (letters.size >= 4) print(letters[4]) else println("null")
}
