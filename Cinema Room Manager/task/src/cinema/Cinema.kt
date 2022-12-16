package cinema

fun getMaxTax() {
    val companies = readln().toInt()
    val annualIncome = IntArray(companies) { readln().toInt() }
    val taxRate = IntArray(companies) { readln().toInt() }
    annualIncome.zip(taxRate) { i, j -> i * j }.let {
        it.indexOf(it.maxOrNull()!!).let { println(it + 1) }
    }
}

fun getMaxValueIndex() = List(readln().toInt()) { readln().toInt() }
    .run { indexOf(maxOrNull()) }
    .let(::println)

fun getMaxTaxOptimized() = List(readln().toInt()) { readln().toInt() }
    .map { it * readln().toInt() }
    .run { indexOf(maxOrNull()) + 1 }
    .let(::println)

fun findRoot() = Array(4) {
    readln().toInt()
}.let {
    for (i in 1..1000) {
        if (it[0] * i * i * i + it[1] * i * i + it[2] * i + it[3] == 0) println(i)
    }
}

fun main() {
    //cinemaRoom()
    getMaxTax()
}

fun getProfit(rows: Int, seats: Int): Int {
    //println(Array(n) { readln().toInt() }.minOrNull())
    //List(readln().toInt()) { readln().toInt() }.minOrNull().let(::print)
    val totalSeats = rows * seats
    val n = readln().toInt()

    return if (totalSeats <= 60) {
        totalSeats * 10
    } else {
        val frontRows = rows / 2
        val backRows = rows - frontRows
        val frontSeats = frontRows * seats
        val backSeats = backRows * seats

        frontSeats * 10 + backSeats * 8
    }
}

fun cinemaRoom() {
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seats = readln().toInt();

    println("Total income:\n $${getProfit(rows, seats)}")
}

fun printSeats() {
    print("Cinema:\n\t")
    (1..8).forEach { print("$it ") }
    println()
    (1..7).forEach { print("$it\t${"S ".repeat(8)}\n") }
}
