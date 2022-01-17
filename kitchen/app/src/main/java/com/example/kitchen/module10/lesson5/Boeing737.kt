package com.example.kitchen.module10.lesson5

class Boeing737 : Aircraft(10000) {
    override val brand = "Boeing"
    override val model = "737"
    override val engineCount: Int = 2
    override val altitude: Int = 12500
    override val rows: Int = 40
    override val numberOfSeatInRow: Int = 6

    override fun getSeatScheme() {
        println("  ABC  DEF")
        seatScheme.forEachIndexed { rowIndex, row ->
            print("${rowIndex + 1} ")
            row.forEachIndexed { seatIndex, passenger ->
                if (passenger == null)
                    print('_')
                else
                    print('X')
                if (seatIndex == row.lastIndex / 2)
                    print("  ")
            }
            println()
            if (rowIndex != 0 && rowIndex % 10 == 0)
                println()
        }
    }

    override val capacity = rows * numberOfSeatInRow
}