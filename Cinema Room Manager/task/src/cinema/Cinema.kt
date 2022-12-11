package cinema

fun printSeats() {
    print("Cinema:\n\t")
    (1..8).forEach { print("$it ") }
    println()
    (1..7).forEach { print("$it\t${"S ".repeat(8)}\n") }
}

fun getProfit(rows: Int, seats: Int): Int {
    val totalSeats = rows * seats

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

fun main() {
    println("Enter the number of rows:")
    val rows = readln().toInt();
    println("Enter the number of seats in each row:")
    val seats = readln().toInt();

    println("Total income:\n $${getProfit(rows, seats)}")
}
