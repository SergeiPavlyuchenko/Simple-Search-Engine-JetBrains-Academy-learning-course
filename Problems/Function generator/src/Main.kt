/*
fun identity(arg: Int): Int {
    return arg
}

fun half(arg: Int): Int {
    return arg / 2
}

fun zero(num: Int) = 1

fun generate(functionName: String): (Int) -> Int {
    return when (functionName) {
        "identity" -> ::identity
        "half" -> ::half
        else -> ::zero
    }
}

*/



fun sum(a: Int, b: Int): Int = a + b
val mul2 = { a: Int, b: Int -> a * b }


fun placeArgument(value: Int, f: (Int, Int) -> Int): (Int) -> Int {
    return { i -> f(value, i) }
}


val a = fun(number: Int): String { return number.toString() }


fun main() {
    val increment = placeArgument(1, ::sum)
    val triple = placeArgument(3, mul2)


    println(increment(4))   // 5
    println(increment(40))  // 41
    println(triple(4))      // 12
    println(triple(40))     // 120
}

