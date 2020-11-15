package com.guiabolso.transactionsbook.resource

import com.guiabolso.transactionsbook.service.TransactionService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class TransactionResource(private val transactionService: TransactionService) {
    @GetMapping(value = ["{id}/transacoes/{year}/{month}"])
    fun getTransactions(@PathVariable("id") id: Long,
                        @PathVariable("year") year: Int,
                        @PathVariable("month") month: Int) = transactionService.findTransactionsBy(id, year, month)
}