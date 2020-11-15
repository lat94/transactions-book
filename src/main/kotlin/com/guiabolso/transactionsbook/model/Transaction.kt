package com.guiabolso.transactionsbook.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Transaction (
        @JsonProperty(value = "descricao")
        val description: String,

        @JsonProperty(value = "data")
        val date: Long,

        @JsonProperty(value = "valor")
        val value: Long
)