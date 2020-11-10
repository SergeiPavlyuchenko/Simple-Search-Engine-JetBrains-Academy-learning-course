fun main() {
    val words = mutableMapOf<String, Int>()

    while (true) {
        val word = readLine()!!

        if (word == "stop") break

        words[word] = words.getOrDefault(word, 0) + 1
    }

    print(words.maxBy { it.value }?.key)
}