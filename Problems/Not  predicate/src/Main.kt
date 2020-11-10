import java.io.File

/*
val notPredicate: (Char) -> Boolean = { !originalPredicate(it) }*/

fun main() {
    val inputFile = "D:/Temp/text.txt/"
    val textFile = File(inputFile).readLines()
    var order = "z"
    val list = mutableListOf<String>()
    for (i in textFile) {
      for (j in i.indices) {
          if( i[j] == '(') { while (i[j] == ')') continue }
          if (i[j])
      }

    }
    println(order)
}