package me.ddevil.mal.misc

import java.time.LocalDate

class EventDate {
    val year: Int
    val day: Int
    val month: Int
    val isValid get() = year != 0 && day != 0 && month != 0
    val asLocalDate get() = LocalDate.of(year, month, day)

    constructor(localDate: LocalDate) {
        this.year = localDate.year
        this.month = localDate.monthValue
        this.day = localDate.dayOfMonth
    }

    constructor(string: String) {
        val values = string.split('-')
        if (values.size != 3) {
            throw IllegalArgumentException("The provided string '$string' is in an invalid format")
        }
        this.year = values[0].toInt()
        this.day = values[1].toInt()
        this.month = values[2].toInt()
    }

    constructor(year: Int, day: Int, month: Int) {
        this.year = year
        this.day = day
        this.month = month
    }

}