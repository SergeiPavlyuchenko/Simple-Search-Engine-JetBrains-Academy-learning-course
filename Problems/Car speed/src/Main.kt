fun limit(speed: Int, limit: Int = 60) {
    if (speed > limit) print("Exceeds the limit by ${speed - limit} kilometers per hour") else print("Within the limit")
}

fun main(args: Array<String>) {
    Array(2) { readLine()!! }.let { if (it[1] == "no limit") limit(it[0].toInt())
    else limit(it[0].toInt(), it[1].toInt()) }
}