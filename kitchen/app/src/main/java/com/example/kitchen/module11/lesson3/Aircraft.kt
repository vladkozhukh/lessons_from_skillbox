package com.example.kitchen.module11.lesson3

abstract class Aircraft(maxWeightArg: Int) : Transporter(maxWeightArg) {
    abstract val brand: String
    abstract val model: String
    abstract val engineCount: Int
    abstract val altitude: Int


    abstract val rows: Int
    abstract val numberOfSeatInRow: Int

    protected val seatScheme by lazy {
        List(rows) {
            MutableList<Passenger?>(numberOfSeatInRow) {
                null
            }
        }
    }

    fun addPassenger(passenger: Passenger) {
        val row = passenger.seat.row
        val number = passenger.seat.letter - 'A'
        seatScheme[row][number] = passenger
    }

    fun getPassenger(seat: Seat): Passenger? {
        val row = seat.row
        val number = seat.letter - 'A'
        return seatScheme[row][number]
    }

    abstract fun getSeatScheme()

    fun getInfo() =
        """Aircraft: $brand $model
            |Max weight: $maxWeight
            |Capacity: $capacity
            |Number of row: $rows
            |Number of seats in rows: $numberOfSeatInRow
        """.trimMargin()

    override fun move() {
        println("Aircraft flying")
    }

    fun getAvailableSeat(): Seat? {
        val availableSeat = mutableListOf<Seat>()
        seatScheme.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { seatIndex, passenger ->
                if (passenger == null)
                    availableSeat.add(Seat(rowIndex, 'A' + seatIndex))
            }
        }
        return availableSeat.randomOrNull()
    }
}