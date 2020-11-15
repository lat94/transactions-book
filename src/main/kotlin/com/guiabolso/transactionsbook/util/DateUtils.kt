package com.guiabolso.transactionsbook.util

import java.time.LocalDate
import java.time.ZoneId
import java.util.*

object DateUtils {
    fun getLocalDate(longDate: Long): LocalDate {
        val date = Date(longDate)
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
    }
}
