package com.guiabolso.transactionsbook.util

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.guiabolso.transactionsbook.model.Transaction
import java.io.File

class JsonFileReader {
    fun jsonToObject(): List<Transaction> {
        val mapper = jacksonObjectMapper()
        val jsonString: String = File("./src/main/resources/transactions.json").readText(Charsets.UTF_8)

        return mapper.readValue(jsonString)
    }
}