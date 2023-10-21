package br.com.moisses.models

import java.util.*

data class ExceptionResponse (
        val timestamp: Date,
        val message: String?,
        val details: String?
)

