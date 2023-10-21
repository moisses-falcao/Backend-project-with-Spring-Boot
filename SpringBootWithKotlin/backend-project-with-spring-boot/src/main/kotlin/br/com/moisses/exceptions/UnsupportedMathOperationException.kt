package br.com.moisses.exceptions

import java.lang.RuntimeException

class UnsupportedMathOperationException(exception: String?) : RuntimeException(exception)