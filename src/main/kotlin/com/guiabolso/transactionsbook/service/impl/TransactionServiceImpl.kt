package com.guiabolso.transactionsbook.service.impl

import com.guiabolso.transactionsbook.model.Transaction
import com.guiabolso.transactionsbook.service.TransactionService
import com.guiabolso.transactionsbook.util.*
import com.guiabolso.transactionsbook.util.exception.InvalidDescriptionException
import com.guiabolso.transactionsbook.util.exception.InvalidValueException
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class TransactionServiceImpl : TransactionService {

    override fun findTransactionsBy(id: Long, year: Int, month: Int): ResponseEntity<Any> {
        try {
            var response = ResponseHandler()
            response = checkIfIsValidPath(response, id, year, month)

            response.ifIsAble {
                val transactions: List<Transaction> = JsonFileReader().jsonToObject()
                val idFirstDigit: Int = id.toString().take(1).toInt()
                val desiredSize = idFirstDigit * month

                val transactionsFiltered: List<Transaction> = transactions.filter {
                    DateUtils.getLocalDate(it.date).year == year && DateUtils.getLocalDate(it.date).monthValue == month
                }.map {
                    checkIfIsValidFields(it, response)
                }

                val actualSize: Int = if (desiredSize > transactionsFiltered.size) transactionsFiltered.size else desiredSize

                response.pushResult(transactionsFiltered.subList(0, actualSize))
            }

            return response.getResponse()

        }
        catch (ex: UnknownError) {
            throw ex
        }
    }

    private fun checkIfIsValidFields(it: Transaction, response: ResponseHandler): Transaction {
        if (it.description.length < 10 || it.description.length > 60) {
            response.pushError(Error.INVALID_DESCRIPTION)
        }

        else if (it.value < -9999999 || it.value > 9999999) {
            response.pushError(Error.INVALID_VALUE)
        }

        return it
    }

    private fun checkIfIsValidPath(response: ResponseHandler, id: Long, year: Int, month: Int): ResponseHandler {
        if (id < 1000 || id > 100000){
            response.pushError(Error.INVALID_ID)
        }

        else if (year <= 0) {
            response.pushError(Error.INVALID_YEAR)
        }

        else if (month <= 0 || month >= 13) {
            response.pushError(Error.INVALID_MONTH)
        }

        return  response
    }

}
