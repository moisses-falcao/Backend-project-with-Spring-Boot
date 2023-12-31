package br.com.moisses.controllers

import br.com.moisses.models.Greeting
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {

    val counter: AtomicLong = AtomicLong()

    //É assim que passamos parametros para verbos GET EX: http://localhost:8080/greeting?name=Batata
    @RequestMapping("/greeting")
    fun greeting(@RequestParam(value="name", defaultValue = "World") name: String?) : Greeting {
        return Greeting(counter.incrementAndGet(), "Hello, $name")
    }
}