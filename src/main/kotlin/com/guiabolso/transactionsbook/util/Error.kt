package com.guiabolso.transactionsbook.util

object Error {
    const val INVALID_ID = "id must be between 1000 and 100000"
    const val INVALID_MONTH = "month must be between 1 and 12"
    const val INVALID_YEAR = "year must be higher than zero"
    const val INVALID_DESCRIPTION = "description's length must be between 10 and 60"
    const val INVALID_VALUE = "value must be between -9999999 and 9999999"
}