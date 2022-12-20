package cinema

fun main() {
    cinemaRoom()
}

fun cinemaRoom() {
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seats = readln().toInt()

    printSeats(rows, seats)

    println("Enter a row number:")
    val rowNumber = readln().toInt()
    println("Enter a seat number in that row:")
    val seatNumber = readln().toInt()

    println("\nTicket price: $${getTicketPrice(rows, seats, rowNumber - 1)}")
    printSeatsWithReservation(rows, seats, rowNumber - 1, seatNumber - 1)
}

fun getTicketPrice(rows: Int, seats: Int, rowIndex: Int): Int {
    val totalSeats = rows * seats

    return if (totalSeats <= 60) {
        10
    } else {
        val frontRows = rows / 2

        if (rowIndex < frontRows) {
            10
        } else {
            8
        }
    }
}

fun printSeats(rows: Int, seats: Int) {
    print("\nCinema:\n  ")
    (1..seats).forEach { print("$it ") }
    println()
    (1..rows).forEach { print("$it ${"S ".repeat(seats)}\n") }
    println()
}

fun printSeatsWithReservation(rows: Int, seats: Int, rowIndex: Int, seatIndex: Int) {
    print("\nCinema:\n  ")
    (1..seats).forEach { print("$it ") }
    println()
    (1..rows).forEach {
        print("$it ")
        (1..seats).forEach { seat ->
            if (it == rowIndex + 1 && seat == seatIndex + 1) {
                print("B ")
            } else {
                print("S ")
            }
        }
        println()
    }
}

fun printProfit(rows: Int, seats: Int) {
    println("Total income:\n $${getProfit(rows, seats)}")
}

fun getProfit(rows: Int, seats: Int): Int {
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
