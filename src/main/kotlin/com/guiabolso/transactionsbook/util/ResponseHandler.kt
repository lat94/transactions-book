package com.guiabolso.transactionsbook.util

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class ResponseHandler {
    private var status: Int = 200
    private var errors: String? = ""
    private var bodyToResponse: Any = Any()
    private var able: Boolean = true

    fun getResponse() = responseEntity(null)

    private fun responseEntity(request: Any?): ResponseEntity<Any> {
        return if (able && errors.isNullOrEmpty()) {
            ResponseEntity(bodyToResponse, HttpStatus.resolve(status)!!)
        }
        else {
            val errorHeader = HttpHeaders()
            errorHeader["error"] = errors
            return if((400 .. 500).contains(status)) {
                val errorBody =  mutableMapOf("code" to status, "error" to errors)
                if(request!=null) {
                    errorBody["request"]=request.toString()
                }
                ResponseEntity(errorBody, errorHeader, HttpStatus.resolve(status)!!)
            }
            else {
                ResponseEntity(null, errorHeader, HttpStatus.resolve(status)!!)
            }
        }
    }

    fun pushError(error: String?) {
        able = false
        errors = error
        status = 406
    }

    fun pushError(error: String?, code: Int) {
        able = false
        errors = error
        status = code
    }

    fun pushResult(any: Any) {
        if (able)
        {
            bodyToResponse = any
        }
    }

    fun ifIsAble(function: () -> Unit) {
        if (able)
        {
            function()
        }
    }

}