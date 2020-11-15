package com.guiabolso.transactionsbook.service

import org.springframework.http.ResponseEntity

interface TransactionService {
    fun findTransactionsBy(id: Long, year: Int, month: Int): ResponseEntity<Any>
}