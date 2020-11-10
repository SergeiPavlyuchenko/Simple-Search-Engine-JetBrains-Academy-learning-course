package search
import java.io.File
import java.util.*
val sc = Scanner(System.`in`)



class SearchEngine {

    object Menu {

        fun create(dataList: List<String>) {
            println("\n=== Menu ===\n1. Find a person\n2. Print all people\n0. Exit")
            while(sc.hasNext()) {
                when (sc.nextInt()) {
                    1 -> PeopleList.Search.choose(dataList)
                    2 -> PeopleList.toPrint(dataList)
                    0 -> return println("\nBye!")
                    else -> println("Incorrect option! Try again.")
                }
                println("\n=== Menu ===\n1. Find a person\n2. Print all people\n0. Exit")
            }
        }

    }


    object PeopleList {

        object Search {

            fun choose(dataList: List<String>) {
                println("Select a matching strategy: ALL, ANY, NONE")
                when (sc.next()) {
                    "ALL", "all", "All" -> all(Map().fromDataList(dataList))
                    "ANY", "any", "Any" -> any(Map().fromDataList(dataList), dataList)
                    "NONE", "None", "none" -> none(Map().fromDataList(dataList), dataList)
                }
            }

            fun all(map: MutableMap<String, MutableList<Int>>) {
                println("Enter a name or email to search all suitable people.")
                val query = readLine()!!
                var isFound = false
                val filteredMap = mutableMapOf<String, MutableList<Int>>()
                val finalMap: MutableMap<String, MutableList<Int>>
                var largestList = mutableListOf<Int>()
                var count = 1
                var indexOfLine = 0

                query.toUpperCase().split(" ").forEach { word ->
                    filteredMap += map.filterKeys { it.toUpperCase() == word }
                }

                filteredMap.forEach { (_, value) ->
                    if (value.size > largestList.size) largestList = value
                }
                largestList.forEach{ i ->
                    filteredMap.values.forEach { if (it.contains(i)) count++
                        if (count == filteredMap.size) indexOfLine = i; isFound = true
                    }
                }

                if(!isFound) return println("No matching people found.") else {
                    finalMap = map.filterValues { it.contains(indexOfLine) }.toMutableMap()
                    println("1 persons found:")
                    print(finalMap.keys.joinToString(" "))
                }
            }

            fun any(map: MutableMap<String, MutableList<Int>>, dataList: List<String>) {
                println("Enter a name or email to search all suitable people.")
                val query = readLine()!!
                var isFound = false
                val filteredMap = mutableMapOf<String, MutableList<Int>>()
                val dataListValues = mutableListOf<Int>()
                query.toUpperCase().split(" ").forEach { word ->
                    filteredMap += map.filterKeys { it.toUpperCase() == word }
                }

                for (i in filteredMap.values) {
                    for (j in i) {
                        if (dataListValues.contains(j)) continue
                        else {
                            dataListValues.add(j)
                            isFound = true
                        }
                    }
                }
                println("${dataListValues.size} persons found:")
                if(!isFound) println("No matching people found.") else dataListValues.forEach { i: Int -> println(dataList[i])}
            }

            fun none(map: MutableMap<String, MutableList<Int>>, dataList: List<String>) {
                println("Enter a name or email to search all suitable people.")
                val query = readLine()!!
                var isFound = false
                val filteredMap = mutableMapOf<String, MutableList<Int>>()
                val dataListValues = mutableListOf<Int>()
                query.toUpperCase().split(" ").forEach { word ->
                    filteredMap += map.filterKeys { it.toUpperCase() == word
                    }
                }

                for (i in filteredMap.values) {
                    for (j in i) {
                        if (dataListValues.contains(j)) continue else {
                            dataListValues.add(j)
                            isFound = true }
                    }
                }
                println("${dataList.size - dataListValues.size} persons found:")
                if(!isFound) println("No matching people found.") else {
                        for (j in dataList.indices) {
                            if (dataListValues.contains(j)) continue else println(dataList[j])
                        }
                }
            }

        }


        fun toPrint(dataList: List<String>) {
            println("\n=== List of people ===")
            dataList.forEach { println(it) }
        }

    }

}

class Map {

    fun fromDataList(dataList: List<String>): MutableMap<String, MutableList<Int>> {
        val map = mutableMapOf<String, MutableList<Int>>()
        dataList.forEachIndexed { i, string -> string.split(" ").forEach { val list = mutableListOf(i)
            if (it !in map.keys) map[it] = list else map[it]?.add(i)} }
        return map
    }

}

fun main(arg: Array<String>) {
    val dataOfPersons = File(arg[1]).readLines()

    SearchEngine.Menu.create(dataOfPersons)

}
