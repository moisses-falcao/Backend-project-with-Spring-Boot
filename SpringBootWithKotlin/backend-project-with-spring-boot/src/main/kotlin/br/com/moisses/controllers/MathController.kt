package br.com.moisses.controllers

import br.com.moisses.exceptions.UnsupportedMathOperationException
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.math.sqrt

@RestController
class MathController {

    //Ex: http://localhost:8080/sum/1/2.3
    @RequestMapping(value = ["/sum/{num1}/{num2}"])
    fun sum(@PathVariable(value="num1") num1 : String,
            @PathVariable(value="num2") num2 : String
    ) : Double{

        if (!isNumeric(num1) || !isNumeric(num2))
            throw UnsupportedMathOperationException("Please, set only numeric values")
        return convertToDouble(num1) + convertToDouble(num2)
    }

    //Ex: http://localhost:8080/sub/1/2.3
    @RequestMapping(value = ["/sub/{num1}/{num2}"])
    fun sub(@PathVariable(value="num1") num1: String,
            @PathVariable(value="num2") num2: String
    ) : Double{

        if(!isNumeric(num1) || !isNumeric(num2))
            throw UnsupportedMathOperationException("Please, set only numeric values")
        return convertToDouble(num1) - convertToDouble(num2)
    }

    //Ex: http://localhost:8080/mult/1/2.3
    @RequestMapping(value = ["/mult/{num1}/{num2}"])
    fun mult(@PathVariable(value="num1") num1: String, @PathVariable(value="num2") num2: String) : Double{

        if(!isNumeric(num1) || !isNumeric(num2)) throw UnsupportedMathOperationException("Please, set only numeric values")
        return convertToDouble(num1) * convertToDouble(num2)
    }

    //Ex: http://localhost:8080/divi/1/2.3
    @RequestMapping(value = ["/divi/{num1}/{num2}"])
    fun divi(@PathVariable(value="num1") num1: String, @PathVariable(value="num2") num2: String) : Double{

        if (!isNumeric(num1) || !isNumeric(num2)) throw UnsupportedMathOperationException("Please, set only numeric values")
        return convertToDouble(num1) / convertToDouble(num2)
    }

    //Ex: http://localhost:8080/media/1/2.3
    @RequestMapping(value = ["/media/{num1}/{num2}"])
    fun media(@PathVariable(value="num1") num1: String, @PathVariable(value="num2") num2: String) : Double{

        if (!isNumeric(num1) || !isNumeric(num2)) throw UnsupportedMathOperationException("Please, set only numeric values")
        return (convertToDouble(num1) + convertToDouble(num2)) / 2
    }

    //Ex: http://localhost:8080/sqr/1/2.3
    @RequestMapping(value = ["sqr/{num}"])
    fun sqr(@PathVariable(value="num") num: String) : Double{

        if (!isNumeric(num)) throw UnsupportedMathOperationException("Please, set only numeric values")
        return sqrt(convertToDouble(num))
    }

    fun convertToDouble(number: String): Double {
        if(number.isNullOrBlank()) return 0.0
        val numberWithDot = number.replace(",".toRegex(), ".")
        return if (isNumeric(numberWithDot)) numberWithDot.toDouble() else 0.0
    }

    fun isNumeric(number: String?): Boolean{
        if (number.isNullOrBlank()) return false
        val newNumber = number.replace(",".toRegex(), ".")
        return newNumber.matches("""[+-]?[0-9]*\.?[0-9]+""".toRegex())
    }

}