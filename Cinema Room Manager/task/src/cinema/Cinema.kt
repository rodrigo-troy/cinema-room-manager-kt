package cinema

fun main() {
    cinemaRoom()
}

fun cinemaRoom() {
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seats = readln().toInt()
    println()

    val cinema = Array(rows) { CharArray(seats) { 'S' } };

    while (true) {
        println("1. Show the seats")
        println("2. Buy a ticket")
        println("3. Statistics")
        println("0. Exit")

        when (readln().toInt()) {
            1 -> printSeats(cinema)
            2 -> buyTicket(cinema)
            3 -> getStatistics(cinema)
            0 -> return
        }
    }
}

fun getStatistics(cinema: Array<CharArray>) {
    println()
    println("Number of purchased tickets: ${getNumberOfPurchasedTickets(cinema)}")
    println("Percentage: ${getPercentageOfPurchasedTickets(cinema)}%")
    println("Current income: $${getCurrentIncome(cinema)}")
    println("Total income: $${getTotalIncome(cinema)}")
    println()
}

fun getTotalIncome(cinema: Array<CharArray>): Int {
    val rows = cinema.size
    val seats = cinema[0].size
    val totalSeats = rows * seats

    return if (totalSeats <= 60) {
        totalSeats * 10
    } else {
        val frontRows = rows / 2
        val backRows = rows - frontRows
        frontRows * seats * 10 + backRows * seats * 8
    }
}

fun getCurrentIncome(cinema: Array<CharArray>): Int {
    var income = 0

    cinema.indices.forEach { i ->
        cinema[i].indices
            .filter { cinema[i][it] == 'B' }
            .forEach { income += if (cinema.size * cinema[i].size <= 60 || i < cinema.size / 2) 10 else 8 }
    }

    return income
}

fun getPercentageOfPurchasedTickets(cinema: Array<CharArray>): String {
    val totalSeats = cinema.size * cinema[0].size
    val purchasedTickets = getNumberOfPurchasedTickets(cinema)
    return "%.2f".format((purchasedTickets.toDouble() / totalSeats) * 100)
}

fun getNumberOfPurchasedTickets(cinema: Array<CharArray>): Int {
    var count = 0

    cinema.forEach { row ->
        row.forEach { seat ->
            if (seat == 'B') {
                count++
            }
        }
    }

    return count
}

fun buyTicket(cinema: Array<CharArray>) {
    println()
    println("Enter a row number:")
    val rowNumber = readln().toInt()
    println("Enter a seat number in that row:")
    val seatNumber = readln().toInt()

    if (rowNumber > cinema.size || seatNumber > cinema[0].size) {
        println()
        println("Wrong input!")
        println()
        return buyTicket(cinema)
    }

    if (cinema[rowNumber - 1][seatNumber - 1] == 'B') {
        println("That ticket has already been purchased!")
        println()
        return buyTicket(cinema)
    } else {
        cinema[rowNumber - 1][seatNumber - 1] = 'B'
    }

    println("Ticket price: $${getTicketPrice(cinema, rowNumber)}")
    println()
}

fun getTicketPrice(cinema: Array<CharArray>, rowIndex: Int): Int {
    val totalSeats = cinema.size * cinema[0].size

    return if (totalSeats <= 60) {
        10
    } else {
        val frontRows = cinema.size / 2

        if (rowIndex <= frontRows) {
            10
        } else {
            8
        }
    }
}

fun printSeats(cinema: Array<CharArray>) {
    println()
    print("Cinema:\n  ")
    (1..cinema[0].size).forEach { i ->
        print("$i ")
    }

    println()

    cinema.indices.forEach { i ->
        print("${i + 1} ")
        cinema[i].indices.forEach { j ->
            print("${cinema[i][j]} ")
        }
        println()
    }

    println()
}
